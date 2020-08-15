package com.github.curriculeon;

import java.io.*;
//import java.io.FileWriter;
//import java.io.File;
//import java.io.IOException;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Paths;
//import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import java.util.Scanner;

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

    @Override
    public void write(String contentToBeWritten) throws IOException {
        this.fileWriter.write(contentToBeWritten);
        this.fileWriter.flush();
    }

    @Override
    public void write(Integer lineNumber, String valueToBeWritten) throws IOException {
        Path path = file.toPath();
        String[] lines = this.read().split("\n");
        lines[lineNumber] = valueToBeWritten;
        StringBuilder stringBuilder = new StringBuilder("");
        for(String s: lines) {
            stringBuilder.append(s + "\n");
        }

        this.overWrite(stringBuilder.toString().trim());
    }

    @Override
    public String read(Integer lineNumber) throws IOException {
        String[] lines = this.read().split("\n");
        return lines[lineNumber];
    }

    @Override
    public String read() throws IOException {
        StringBuilder contents = new StringBuilder("");
        Path path = file.toPath();
        BufferedReader bufferedReader = Files.newBufferedReader(path);
        while(bufferedReader.ready()) {
            contents.append((char)(bufferedReader.read()));
        }
        return contents.toString();
    }

    @Override
    public void replaceAll(String stringToReplace, String replacementString) throws IOException {
        String fileAsString = this.read();
        String newString = fileAsString.replaceAll(stringToReplace, replacementString);
        this.overWrite(newString);
    }

    @Override
    public void overWrite(String content) throws IOException {
        Path path = file.toPath();
        Files.write(path, content.getBytes());
    }

    public List<String> toList() {
        return null;
    }

    @Override
    public File getFile() {
        return this.file;
    }

    @Override
    public String toString() {
        try {
            return this.file.getPath() + "{" + this.read() + "}";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
