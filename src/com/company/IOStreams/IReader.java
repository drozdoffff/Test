package com.company.IOStreams;

import com.company.IOStreams.String.ReadString;

import java.io.IOException;


/**
 * Created by Igor on 14.05.2016.
 *
 * интерфейс для входного потока символов
 *
 */
public interface IReader {
    char readSymbol() throws IOException;
    boolean isEnd();
}
