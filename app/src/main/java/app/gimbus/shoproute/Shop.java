package app.gimbus.shoproute;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by tobi6 on 31.01.2018.
 */

class Shop {
    private String fileName = "shops.txt";
    private static List<String> names;
    private static Shop instance = null;

    private Shop(){
        createList();
    }

    public static Shop getInstance(){
        if(instance==null) instance = new Shop();
        return instance;
    }

    private void createList(){
        if(instance == null) instance = new Shop();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        Scanner s = new Scanner(inputStream).useDelimiter("\n");
        while (s.hasNext()) names.add(s.next());
        s.close();
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] getNames(){
        return (String[]) names.toArray();
    }


}
