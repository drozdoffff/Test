package com.company.IOStreams.File;

import com.company.IOStreams.IReader;

import java.io.*;

/**
 * Created by Igor on 15.05.2016.
 */
public class ReadFile implements IReader {

        private Reader fileReader;
        private boolean end = false;
        public ReadFile(final String fileName) throws FileNotFoundException {
            this.fileReader = new FileReader(new File(fileName));
        }

        public char readSymbol() throws IOException {
            int i = this.fileReader.read();
            if (i == -1) {
                end = true;
            }
            return (char) i;
        }

        public boolean isEnd() {
            return end;
        }
    }

