package com.AccountingSystem.Controllers;

import com.AccountingSystem.Models.*;

import java.util.Scanner;


public class RootCategoryController {
    public static void manageSystemRoot(Scanner scanner, SystemRoot systemRoot, User user)
    {
        if (UserController.LoginSuccessful(scanner, systemRoot.getUsers()))
        {
            while (true)
            {
                System.out.println("Choose an action:\n"
                        + "\t1.Add new root category\n"
                        + "\t2.Remove root category\n"
                        + "\t3.Manage root category\n"
                        + "\t4.Manage users \n"
                        + "\t5.Save system to file\n"
                        + "\t6.Show system information\n"
                        + "\t7.Go back\n"
                        + "\t8.Quit\n");

                switch (scanner.next())
                {
                    case "1":
                        System.out.println("How do you want to name this new root category?");
                        systemRoot.AddRootCategory(scanner.next(), user ,null);
                        break;

                    case "2":
                        System.out.println("Which category would you like to delete?");
                        systemRoot.RemoveRootCategory(scanner.next().toUpperCase());
                        break;

                    case "3":
                        System.out.println("Which category would you like to manage?");
                        try {
                            CategoryController.manageCategory(scanner,
                                    //category from root categories
                                    systemRoot.getRootCategories().get(CategoryController.findCategoryIndex(scanner.next(), systemRoot.getRootCategories())),
                                    user);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Such root category doesn't exist");
                        }

                        break;

                    case "4":
                        UserController.manageUsers(scanner, systemRoot.getUsers());
                        break;

                    case "5":
                        DataRW.writeSystemToFile(scanner,systemRoot);
                        break;

                    case "6":
                        System.out.println(systemRoot.toString());
                        break;

                    case "7":
                        return;

                    case "8":
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Read options again.");
                }
            }
        }

    }

}
