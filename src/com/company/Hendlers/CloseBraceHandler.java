package com.company.Hendlers;

import com.company.IOStreams.IWriter;
import com.company.formatter.Formatter;

import java.io.IOException;

/**
 * Created by Igor on 16.05.2016.
 */
public class CloseBraceHandler implements IHandlers {

    public boolean canDo(char symbol) {
        if (symbol == '}') return true;
        return false;
    }

    public void action(IWriter outStream) throws IOException {
        outStream.writeSymbol('\n');

        for (int j = 0; j < Formatter.indentLevel - 1; j++) {
            outStream.writeString(Formatter.indentString);
        }
        outStream.writeSymbol('}');
        outStream.writeSymbol('\n');
        Formatter.indent = true;
        Formatter.isNewLine = true;

        Formatter.indentLevel = Formatter.indentLevel - 1;
    }
}
