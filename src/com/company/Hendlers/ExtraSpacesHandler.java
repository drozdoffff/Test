package com.company.Hendlers;

import com.company.IOStreams.IWriter;
import com.company.formatter.Formatter;

import java.io.IOException;

/**
 * Created by Igor on 16.05.2016.
 */
public class ExtraSpacesHandler implements IHandlers {

    public boolean canDo(char symbol) {
        if (symbol == ' ') return true;
        return false;
    }

    public void action(IWriter outStream) throws IOException {
        if (Formatter.isNewLine == false ) outStream.writeSymbol(' ');
        Formatter.indent = false;
    }

}
