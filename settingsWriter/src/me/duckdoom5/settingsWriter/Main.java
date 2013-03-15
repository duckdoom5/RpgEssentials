package me.duckdoom5.settingsWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	private static Set<String> recipes = new HashSet<String>();
	
	public static void main(String[] args) {
		recipes.clear();
		System.out.println("Please enter a file name");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		scanner.close();

		System.out.println("Conveting...");
		startConverting(name);
	}
	
	private static void startConverting(String name){
		
		String text = "";
		
		if(name.equalsIgnoreCase("items")){
			for(int i = 0; i < 300; i++){
				if(! (i == 3 || i == 6 || i == 7 || i == 14 || i == 15 || i == 16 || i == 66)){
					text = text + "{" + i + "|99}\n";
				}
			}
		}else{
			System.out.println("Error: Can't find Items file!");
		}
		
		try{
			File file = new File(System.getProperty("user.dir")+ "\\" + name + ".dat");
			FileWriter fw = new FileWriter(file, false);
			BufferedWriter file2 = new BufferedWriter(fw);
			file2.write(text);
			file2.close();
			fw.close();
			System.out.println("Done!");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
