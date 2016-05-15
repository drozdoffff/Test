package com.company.Hendlers;

import com.company.IOStreams.IWriter;
import java.io.IOException;

/**
 * Created by Igor on 16.05.2016.
 */
public interface IHandlers {
    public boolean canDo(char symbol);
    public void action(IWriter outStream) throws IOException;
}
