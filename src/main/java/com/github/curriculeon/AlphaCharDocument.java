package com.github.curriculeon;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * @author leon on 16/11/2018.
 */
public class AlphaCharDocument extends Document {
    public AlphaCharDocument(String fileName) throws IOException {
        super(fileName);
    }

    @Override
    public void write(String contentToBeWritten) throws IOException {
        if(isAlpha(contentToBeWritten)) {
            super.write(contentToBeWritten);
        }
        else {
            throw new IllegalArgumentException("String contains non-alpha characters.");
        }
    }

    private Boolean isAlpha(String s) {
        return s != null && s.matches("^[\\sa-zA-Z]*$");
    }
}
