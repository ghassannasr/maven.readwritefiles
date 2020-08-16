package com.github.curriculeon;

import java.io.IOException;

/**
 * @author leon on 18/11/2018.
 */
public class SpecialCharDocument extends Document {
    public SpecialCharDocument(String fileName) throws IOException {
        super(fileName);
    }

    @Override
    public void write(String contentToBeWritten) throws IOException {
        if(isSpecialCharacters(contentToBeWritten)) {
            super.write(contentToBeWritten);
        }
        else {
            throw new IllegalArgumentException("String contains special characters.");
        }
    }

    private Boolean isSpecialCharacters(String s) {
        return s != null && !s.matches("^[\\sa-zA-Z0-9]*$");
    }
}
