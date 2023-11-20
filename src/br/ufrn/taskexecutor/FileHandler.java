package br.ufrn.taskexecutor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {

    public static String sharedFilePath = "arquivo.txt";

    public static void createFile() {
        File file = new File(FileHandler.sharedFilePath);
        try (FileWriter writer = new FileWriter(file)) {
            file.createNewFile();
            writer.write("0");
            // System.out.print("Arquivo criado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();	
        }
    }

    public static Integer getFileValue() {
        File file = new File(FileHandler.sharedFilePath);
        try (Scanner scanner = new Scanner(file)) {
            return Integer.parseInt(scanner.next());
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Could not get file value!");
    }

    public static Integer getFileValueWithWait() {
        File file = new File(FileHandler.sharedFilePath);
        while (true) {
            try (Scanner scanner = new Scanner(file)) {
                if (scanner.hasNext()) {
                    String nextToken = scanner.next();
                    if (nextToken.matches("\\d+")) {
                        return Integer.parseInt(nextToken);
                    } else {
                        // Handle the case where the file contains non-numeric content
                        throw new RuntimeException("Invalid content in the file!");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeToFile(Integer value) {
        File file = new File(FileHandler.sharedFilePath);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(value.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
}