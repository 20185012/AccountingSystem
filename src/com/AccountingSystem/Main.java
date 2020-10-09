package com.AccountingSystem;

import com.AccountingSystem.Controllers.DataRW;
import com.AccountingSystem.Models.*;
import com.AccountingSystem.Models.SystemRoot;
import com.AccountingSystem.Controllers.RootCategoryController;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        User Admin = new User("Admin","Admin");

        Scanner scanner = new Scanner(System.in);

        SystemRoot systemRoot = null;

        while(systemRoot == null) {
            System.out.println("Enter number of your decided action:\n"
                    + "\t 1.Load system from file \n"
                    + "\t 2.Create new system \n"
                    + "\t 3.Quit \n");

            switch (scanner.next()) {
                case "1":
                    systemRoot = DataRW.LoadSystemFromFile(scanner, systemRoot);
                    break;

                case "2":
                    System.out.println("Whats the name of the system?");
                    systemRoot = new SystemRoot(scanner.next(), Admin);
                    break;

                case "3":
                    System.exit(0);

                default:
                    System.out.println("Enter number between 1-3");
            }
        }


        while (true)
        {
            System.out.println("Enter number of your decided action:\n"
                    + "\t 1.Access Accounting System \n"
                    + "\t 2.Get System Information \n"
                    + "\t 3.Quit \n\n Username: Admin \t Password: Admin");
            switch (scanner.next())
            {
                case "1":
                    RootCategoryController.manageSystemRoot(scanner,systemRoot, Admin);
                    break;

                case "2":
                    System.out.println(systemRoot.toString());
                    break;

                case "3":
                    return;
                default:
                    System.out.println("Number between 1-3, please. ");
            }
        }
    }
}
