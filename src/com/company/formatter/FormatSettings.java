package com.company.formatter;


import com.company.Hendlers.IHandlers;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Igor on 16.05.2016.
 */
public class FormatSettings {
    private static final char INDENT_CHAR_DEFAULT = ' ';
    private static final int INDENT_LENGHT_DEFAULT = 4;
    private char indentChar;
    private String indentString = "";
    private int indentLenght;
    private boolean extraBraces;
    private Properties properties;
    private Reader jFileReader;
    private Reader fileReader;
    public FormatSettings(){
        setDefaultSettings();
    }
    public FormatSettings(final String fileName, final String jsonFileName) throws IOException {
        fileReader = new FileReader(new File(fileName));
        jFileReader = new FileReader(new File(jsonFileName));
        //jReader.nextName();
        //int one = json.fromJson(jReader,int.class);
        //System.out.println("name:"+jReader.nextName()+" "+jReader.nextInt());
        properties = new Properties();
        properties.load(fileReader);
        indentLenght = Integer.parseInt(properties.getProperty("indentLenght"));
        indentChar = properties.getProperty("indentChar").charAt(1);
        extraBraces = Boolean.parseBoolean(properties.getProperty("extraBraces"));
        setSetting();
    }

    private void  setDefaultSettings() {
        for (int i = 0;i < INDENT_LENGHT_DEFAULT;i++) {
            indentString = indentString + INDENT_CHAR_DEFAULT;
        }
        extraBraces = false;
    }
    private void setSetting(){
        for (int i = 0;i < indentLenght;i++) {
            indentString = indentString + indentChar;
        }
    }
    public ArrayList<IHandlers> getHandlersList() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        ArrayList<IHandlers> outList = new ArrayList<IHandlers>();
        Gson json = new Gson();
        JsonReader jReader = new JsonReader(jFileReader);
        ArrayList<String> handlers = json.fromJson(jReader,new TypeToken<List<String>>(){}.getType());
        for (int i = 0; i < handlers.size(); i++) {
            Class c = Class.forName(handlers.get(i));

            Object o = c.newInstance();
            outList.add((IHandlers) o);
        }

        return outList;
    }
    public String getIndentString (){
        return indentString;
    }
    public boolean getExtraBraces () { return extraBraces; }
}

