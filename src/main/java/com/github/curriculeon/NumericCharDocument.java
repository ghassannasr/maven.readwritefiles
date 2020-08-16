package com.github.curriculeon;

import java.io.IOException;

/**
 * @author leon on 16/11/2018.
 */
public class NumericCharDocument extends Document {
    public NumericCharDocument(String fileName) throws IOException {
        super(fileName);
    }

    @Override
    public void write(String contentToBeWritten) throws IOException {
        if(isNumeric(contentToBeWritten)) {
            super.write(contentToBeWritten);
        }
        else {
            throw new IllegalArgumentException("String contains non-numeric characters.");
        }
    }

    private Boolean isNumeric(String s) {
        return s != null && s.matches("^[0-9]*$");
    }
}
