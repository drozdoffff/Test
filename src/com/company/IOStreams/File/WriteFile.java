package com.company.IOStreams.File;

import com.company.IOStreams.IWriter;
import java.io.*;

/**
 * Created by Igor on 15.05.2016.
 */
public class WriteFile implements IWriter {

    private Writer fileWriter;

    public WriteFile(final String fileName) throws IOException {
        this.fileWriter = new FileWriter(new File(fileName));
    }

    public void writeSymbol(char symbol) throws IOException{
        fileWriter.write(symbol);
    }

    public void writeString(String string) throws IOException{
        fileWriter.write(string);
    }

    public void close() throws IOException{
        this.fileWriter.close();
    }
    public String getString(){
        return "null";
    }
}
