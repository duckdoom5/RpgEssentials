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
	private static Set<String> recipes = new HashSet<String>();
	
	public static void main(String[] args) {
		recipes.clear();
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
		if(!file.getName().contains(".yml")){
			System.out.println("Error: That's not a .yml file!");
			main(null);
			return;
		}
		File file2 = new File(file.getParent() + File.separator + file.getName().replace(".yml", ".settings"));
		System.out.println("Creating new file: " + file2.getAbsolutePath());
		
		String text = "";
		String title = "";
		String type = "block";
		String rtype = "";
		boolean foundrecipes = false;
		
		try{
			FileReader fr = new FileReader(file);
			BufferedReader f = new BufferedReader(fr);
			String temp = null;
			int i =0 ;
			int backup = 0;
			while((temp=f.readLine()) !=null){
				i++;
				
				if(i==1){
					try{
						title = temp = temp.split("\"")[1] + ":";
					}catch(Exception e){
						title = temp = temp.split(":")[1] + ":";
					}
				}else if(i==2){
					try{
						type = temp.split("\"")[1];
					}catch(Exception e){
						type = temp.split(":")[1];
					}
					temp = null;
				}else if(i==3){
					temp = "    base:" + temp.split(":")[1];
				}else if(i==4){
					try{
						temp = "    textureurl: http://dl.lynxdragon.com/rpgessentials/textures/" + temp.split("\"")[1];
					}catch(Exception e){
						temp = "    textureurl: http://dl.lynxdragon.com/rpgessentials/textures/" + temp.split(":")[1];
					}
					if(type.equalsIgnoreCase("block")){
						text = text + "\n" + "    texturesize: 16";
						text = text + "\n" + "    textureIds: 1,1,1,1,1,1";
					}
				}else if(i==5){
					if(type.equalsIgnoreCase("block")){
						try{
							temp = "    design: " + temp.split("\"")[1].replace(".shape", "");
						}catch(Exception e){
							temp = "    design: " + temp.split(":")[1].replace(".shape", "");
						}
					}else{
						temp = null;
					}
				}else if(i==6){
					temp = "    rotate:" + temp.split(":")[1].toLowerCase();
				
				}else if(temp.contains("Recipes")){
					backup = i;
					foundrecipes = true;
					temp=null;
					System.out.println("found recipes");
				}else if(foundrecipes && i-backup==1){
					String line;
					try{
						line = temp.split("\"")[1] + " recipe";
						rtype = temp.split("\"")[1];
					}catch(Exception e){
						line = temp.split(":")[1] + " recipe";
						rtype = temp.split(":")[1];
					}
					
					int num = 1;
					if(!recipes.contains(line + num)){
						recipes.add(line + num);
					}else{
						
						while(recipes.contains(line + num))
							num++;
						recipes.add(line + num);
					}
					temp = "    " + line + num + ":";
				}else if(foundrecipes && i-backup==2){
					temp = "        amount:" + temp.split(":")[1];
				}else if(foundrecipes && i-backup==3){
					if(!rtype.equalsIgnoreCase("furnace")){
						temp = "        ingredients:";
					}else{
						temp = null;
					}
				}else if(foundrecipes && (i-backup==4 || i-backup==5 || i-backup==6)){
					if(rtype.equalsIgnoreCase("furnace")){
						temp = "    ingredient:";
					}else{
						temp = temp.replace("      ", "        - ");
					}
				}else if(temp.contains("#") || temp.contains("Coords")){
					System.out.println("Removing: " + temp);
					temp = null;
				}
				if(foundrecipes){
					if(i-backup==6){
						i = i-6;
					}
				}
				
				if(i==1){
					text = temp;
				}else if(temp!=null){
					text = text + "\n" + temp;
				}
			}
			
			text = text + "\n" + "    Sell Able: false";
			text = text + "\n" + "    Buy Able: false";
			text = text + "\n" + "    Buy Price: 100";
			text = text + "\n" + "    Sell Price: 50";
			text = text + "\n" + "    storetype: miscellaneous";
			
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
	//C:\Users\Jelle\Desktop\custom items\CEP_RPG_Blacksmith\settings\CEP_Smith_armor_diamond.yml
}
