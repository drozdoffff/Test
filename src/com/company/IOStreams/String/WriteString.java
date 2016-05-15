package com.company.IOStreams.String;

import com.company.IOStreams.IWriter;

import java.io.IOException;
import java.lang.String;

/**
 * Created by Igor on 15.05.2016.
 */
public class WriteString implements IWriter {

    private String outString;
    private boolean firstWrite = false;

    public void writeSymbol(char symbol) throws IOException{
        if(firstWrite == false){
            outString = "" + symbol;
            firstWrite = true;
        }else {
            outString = outString + symbol;
        }
    }
    public void writeString(String string) throws IOException{
        outString = outString + string;
    }
    public void close() throws IOException{
    }

    public String getString(){
        if (outString == null) return "";
        else return outString;
    }

}
