package com.company;

import java.io.*;
public class Main {
    public static void main(String[] args) throws
            IOException {


        String code = "while(inputStream.hasNext()){char symbol = inputStream.read();} while(inputStream.hasNext()){char symbol = inputStream.read();}";

        String regex = "(for|while|if)";
        String result = code.replaceAll(regex, String.format("%n")+"$1");

        String regex1 = "(for|while|if)\\s?(\\(.+\\))\\s*\\{(.*)\\}";
        String result1 = result.replaceAll(regex1, String.format("%n")+"$1$2 { "+String.format("%n")+"   $3}");

        String regex2 = ";";
        String result2 = result1.replaceAll(regex2, ";"+String.format("%n")+"   ");

        System.out.println(result2);


    }
}
