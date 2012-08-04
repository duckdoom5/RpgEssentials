package me.duckdoom5.RpgEssentials.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BO2ObjectManager {
	static ArrayList<BO2Object> objects = new ArrayList<BO2Object>();

	public static void ReadBO2Files(String path) throws FileNotFoundException {

		File dir = new File(path);
		File[] files = dir.listFiles();

		for (int i = 0; i < files.length; i++) {
			Scanner s = new Scanner(files[i]);
			BO2Object obj = new BO2Object();
			ArrayList<String> strs = new ArrayList<String>();
			while (s.hasNext()) {

				String str = s.nextLine();
				if (str.equalsIgnoreCase("[META]")) {
					strs.add("name=" + files[i].getName());
				} else if (str.equalsIgnoreCase("[DATA]")) {
					obj.ParseMetadata(strs.toArray(new String[1]));
					strs.clear();
				} else {
					strs.add(str);
				}
			}
			obj.ParseBlockdata(strs.toArray(new String[1]));
			objects.add(obj);
		}

	}

	public static ArrayList<BO2Object> getTrees() {
		ArrayList<BO2Object> objs = new ArrayList<BO2Object>();

		for (int i = 0; i < objects.size(); i++) {

			if (objects.get(i).isTree()) {

				objs.add(objects.get(i));
			}

		}

		return objs;
	}

	public static ArrayList<BO2Object> getNotTrees() {
		ArrayList<BO2Object> objs = new ArrayList<BO2Object>();

		for (int i = 0; i < objects.size(); i++) {

			if (!objects.get(i).isTree())
				objs.add(objects.get(i));

		}

		return objs;
	}
}
