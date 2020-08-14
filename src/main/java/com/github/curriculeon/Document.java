package com.github.curriculeon;

import java.io.*;
import java.util.List;
import java.util.Scanner;

/**
 * @author leon on 16/11/2018.
 */
public class Document implements DocumentInterface {

    private final FileWriter fileWriter;
    private final File file;

    public Document(String fileName) throws IOException {
        this(new File(fileName));
    }

    public Document(File file) throws IOException {
        this.file = file;
        this.fileWriter = new FileWriter(file);
    }

    @Override  //GN added method body
    public void write(String contentToBeWritten)  {
        BufferedWriter bufferedWriter = new BufferedWriter(this.fileWriter);

        try {
            bufferedWriter.write(contentToBeWritten);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (bufferedWriter != null) {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void write(Integer lineNumber, String valueToBeWritten) {

    }

    @Override
    public String read(Integer lineNumber) {

        return null;
    }

    @Override
    public String read() {
        try {

            FileReader fileReader = new FileReader(this.file);
            StringBuilder contents = new StringBuilder("");
            int c;
            while(( c = fileReader.read()) != -1) {
                contents.append((char)c);
            }

            fileReader.close();
            return contents.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void replaceAll(String stringToReplace, String replacementString) {
    }

    @Override
    public void overWrite(String content) {
    }

    public List<String> toList() {
        return null;
    }

    @Override
    public File getFile() {
        return null;
    }

    @Override
    public String toString() {
        return null;
    }
}
