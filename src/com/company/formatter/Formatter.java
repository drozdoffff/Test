package com.company.formatter;

import com.company.Hendlers.IHandlers;
import com.company.IOStreams.IReader;
import com.company.IOStreams.IWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Handler;

/**
 * Created by Igor on 14.05.2016.
 *
 * класс, который форматирует с публичным методом void format(IReader reader, IWriter writer)
 *
 */
public class Formatter {

    public static boolean indent = false;
    public static boolean isNewLine = true;
    public static int indentLevel = 0;
    public static String indentString;
    public static int pastHandlers;
    public static ArrayList<IHandlers> handlers = new ArrayList<IHandlers>();
    public static void format(IReader inStream, IWriter outStream,FormatSettings formatSettings) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        indentString = formatSettings.getIndentString();
        char currentSymbol;
        handlers = formatSettings.getHandlersList();
        while (true) {
            pastHandlers = 0;
            currentSymbol = inStream.readSymbol();
            if (inStream.isEnd()) break;
            if (indent == true){
                for (int j = 0; j < indentLevel; j++) {
                    outStream.writeString(indentString);
                }
            }
            for (int i = 0; i < handlers.size(); i++) {
                if (handlers.get(i).canDo(currentSymbol)){
                    handlers.get(i).action(outStream);
                    break;
                }
                pastHandlers++;
            }
            if (pastHandlers ==  handlers.size()){
                outStream.writeSymbol(currentSymbol);
                indent = false;
                isNewLine = false;
            }
        }
    }
}
