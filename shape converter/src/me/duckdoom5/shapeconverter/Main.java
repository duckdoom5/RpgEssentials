package me.duckdoom5.shapeconverter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	private static Set<String> names = new HashSet<String>();
	
	public static void main(String[] args) {
		names.clear();
		System.out.println("Please enter a file location");
		Scanner scanner = new Scanner(System.in);
		String fileloc = scanner.nextLine();
		scanner.close();
		File file = new File(fileloc.replace("\"", ""));
		if(!file.exists()){
			System.out.println("Please enter a correct file location");
			main(null);
		}else{
			System.out.println("Conveting...");
			startConverting(file);
		}
	}
	private static void startConverting(File file){
		if(!file.canRead()){
			System.out.println("Error: Can't read file!");
			main(null);
			return;
		}
		if(!file.getName().contains(".shape")){
			System.out.println("Error: That's not a .shape file!");
			main(null);
			return;
		}
		File file2 = new File(file.getParent() + File.separator + file.getName().replace(".shape", ".yml"));
		System.out.println("Creating new file: " + file2.getAbsolutePath());
		
		String text = "";
		
		try{
			FileReader fr = new FileReader(file);
			BufferedReader f = new BufferedReader(fr);
			String temp = null;
			int i =0 ;
			while((temp=f.readLine()) !=null){
				i++;
				if(i==1){
					String[] line = temp.split("\"");
					temp = line[0] + "\"" + line[1].replace(" ", ",") + "\"";
				}else if(i==2){
					temp = "Shape:";
				}
				
				if(i-2==1){
					String[] line = new String[2];
					int num = 0;
					try{
						line = temp.split("#");
						String line1 = line[1];
					}catch(Exception e){
						line = new String[2];
						line[1] = Integer.toString(num);
						line[0] = temp;
					}
					if(!names.contains(line[1])){
						names.add(line[1]);
					}else{
						
						while(names.contains(line[1] + num))
							num++;
						line[1] = line[1] + num;
						names.add(line[1]);
					}
					text = text + "\n" + "    " + line[1] + ":";
					
					temp =  "    " + line[0].replace("-", " ").replace(" | ", "").replace(" |", "").replace("|", "");
				}else if(i-2==2 || i-2==3 || i-2==4 || i-2==5){
					temp = "        - " + temp.split("      ")[1];
				}else if(i-2==6){
					String[] line = temp.split(":");
					temp = "    " + line[0] + "Id:" + line[1];
				}
				
				if(i-2==6){
					i = i-6;
				}
				
				if(i==1){
					text = temp;
				}else{
					text = text + "\n" + temp;
				}
			}
			f.close();
			fr.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			FileWriter fw = new FileWriter(file2,false);
			BufferedWriter file3 = new BufferedWriter(fw);
			file3.write(text);
			file3.close();
			fw.close();
			System.out.println("Done!");
			main(null);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	//C:\Users\Jelle\Desktop\custom items\CEP_RPG_Blacksmith\CEP_shelf.shape
}
