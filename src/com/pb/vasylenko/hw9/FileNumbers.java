package com.pb.vasylenko.hw9;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileNumbers {

    private final String delimiter;
    private final String filePath;
    private final String oldFilePath;

    public FileNumbers(String filePath, String oldFilePath, String delimiter) {
        this.filePath = filePath;
        this.oldFilePath = oldFilePath;
        this.delimiter = delimiter;
    }

    public void createNumbersFile() throws IOException {
        File myFile = new File(filePath);
        if (myFile.exists()) myFile.delete();
        if (myFile.createNewFile()) {
            this.appendStr(myFile);
        }
    }

    private void appendStr(File myFile) throws IOException {
        FileWriter writer = new FileWriter(myFile, false);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            str.append(i + 1);
            if ((i + 1) % 10 == 0) {
                str.append("\n");
            } else {
                str.append("\s");
            }
        }
        writer.write(str.toString());
        writer.flush();
        writer.close();
    }

    public void createOddNumbersFile() throws Exception {
        File newFile = new File(this.oldFilePath);
        FileWriter writer = new FileWriter(newFile, false);
        if (new File(this.filePath).exists()) {
            StringBuilder str = new StringBuilder();
            FileReader fr = new FileReader(this.filePath);
            Scanner scan = new Scanner(fr);
            while (scan.hasNextLine()) {
                str.append(appendOddStr(scan.nextLine()));
            }
            writer.write(str.toString());
            writer.flush();
            writer.close();
        } else {
            throw new Exception("Source file does not exist!");
        }
    }

    private String appendOddStr(String nextLine) {
        StringBuilder newStr = new StringBuilder();
        String[] arr = nextLine.split(this.delimiter);
        for (String s : arr) {
            if (s.matches("^[0-9]+")) {
                if (Integer.parseInt(s) % 2 == 0) s = "0";
            }
            newStr.append(s).append("\s");
        }
        newStr.append("\n");
        return newStr.toString();
    }
}
