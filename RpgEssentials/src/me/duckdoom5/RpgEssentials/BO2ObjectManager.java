package me.duckdoom5.RpgEssentials;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import me.duckdoom5.RpgEssentials.util.BO2Object;

public class BO2ObjectManager {
    static ArrayList<BO2Object> objects = new ArrayList<>();

    public static void ReadBO2Files(String path) throws FileNotFoundException {

        final File dir = new File(path);
        final File[] files = dir.listFiles();

        for (final File file : files) {
            try (Scanner s = new Scanner(file)) {
                final BO2Object obj = new BO2Object();
                final ArrayList<String> strs = new ArrayList<>();
                while (s.hasNext()) {

                    final String str = s.nextLine();
                    if (str.equalsIgnoreCase("[META]")) {
                        strs.add("name=" + file.getName());
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

    }

    public static ArrayList<BO2Object> getTrees() {
        final ArrayList<BO2Object> objs = new ArrayList<>();

        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).isTree())
                objs.add(objects.get(i));
        }
        return objs;
    }

    public static ArrayList<BO2Object> getNotTrees() {
        final ArrayList<BO2Object> objs = new ArrayList<>();

        for (int i = 0; i < objects.size(); i++) {
            if (!objects.get(i).isTree())
                objs.add(objects.get(i));
        }
        return objs;
    }
}
