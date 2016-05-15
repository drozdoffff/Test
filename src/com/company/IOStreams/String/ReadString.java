package com.company.IOStreams.String;

import com.company.IOStreams.IReader;
import java.io.IOException;
import java.lang.String;

/**
 * Created by Igor on 15.05.2016.
 */
public class ReadString implements IReader {
    private String currentString;
    private char currentSymbol;
    private int numberSymbol = 0;
    private boolean end = false;

    public ReadString(String s){
        this.currentString = s;
    }

    public char readSymbol() throws IOException{
        if(numberSymbol == currentString.length() ){
            end = true;
        }
        if(end == false){
            currentSymbol = currentString.charAt(numberSymbol);
            numberSymbol += 1;
        }
        return currentSymbol;
    }
    public boolean isEnd(){
        return end;
    }
}
