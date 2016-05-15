package com.company.IOStreams;
import java.io.IOException;

/**
 * Created by Igor on 14.05.2016.
 *
 * интерфейс для выходного потока символов
 *
 */
public interface IWriter {

    void writeSymbol(char symbol) throws IOException;
    void writeString(String string) throws IOException;
    void close() throws IOException;
    String getString();

}
