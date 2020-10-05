package com.AccountingSystem.Controllers;

import com.AccountingSystem.Models.SystemRoot;

import java.io.*;
import java.util.Scanner;

public class DataRW {
    public static SystemRoot LoadSystemFromFile(Scanner scanner, SystemRoot systemRoot)
    {
        System.out.println("Enter name of file you want to load system from.");
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(scanner.next()));
            systemRoot = (SystemRoot) objectInputStream.readObject();
            objectInputStream.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Failed with class recognition.");
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Failed to open file.");
        }
        return systemRoot;
    }

    public static void writeSystemToFile(Scanner scanner, SystemRoot systemRoot)
    {
        try
        {
            System.out.println("Enter file name:\n");
            String fileName = scanner.next();
            if (fileName.isEmpty()) fileName = "AccountingSystem";
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName + ".lib"));
            out.writeObject(systemRoot);
            out.close();
        }
        catch (IOException e)
        {
            System.out.println("Fail.\n");
        }
    }
}
