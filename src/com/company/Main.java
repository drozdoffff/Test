package com.company;

import com.company.IOStreams.File.ReadFile;
import com.company.IOStreams.File.WriteFile;
import com.company.IOStreams.IReader;
import com.company.IOStreams.IWriter;
import com.company.formatter.FormatSettings;
import com.company.formatter.Formatter;

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        String nameFileIn = args[0];
        String nameFileOut = args[1];
        String nameFileSettings = args[2];
        String nameFileJson = args[3];


        IReader fr = new ReadFile(nameFileIn);
        IWriter fw = new WriteFile(nameFileOut);
        FormatSettings formatSettings = new FormatSettings(nameFileSettings,nameFileJson);

        Formatter.format(fr, fw, formatSettings);

        fw.close();


        // Способ: через регулярные выражения
        /*
        String code = "while(inputStream.hasNext()){char symbol = inputStream.read();} while(inputStream.hasNext()){char symbol = inputStream.read();}";

        String regex = "(for|while|if)";
        String result = code.replaceAll(regex, String.format("%n")+"$1");

        String regex1 = "(for|while|if)\\s?(\\(.+\\))\\s*\\{(.*)\\}";
        String result1 = result.replaceAll(regex1, String.format("%n")+"$1$2 { "+String.format("%n")+"   $3}");

        String regex2 = ";";
        String result2 = result1.replaceAll(regex2, ";"+String.format("%n")+"   ");

        System.out.println(result2);
        */

    }
}
