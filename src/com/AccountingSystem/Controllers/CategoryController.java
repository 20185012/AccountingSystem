package com.AccountingSystem.Controllers;

import com.AccountingSystem.Models.Category;
import com.AccountingSystem.Models.User;

import java.util.ArrayList;
import java.util.Scanner;

public class CategoryController {

    public static int findCategoryIndex(String categoryName, ArrayList<Category> categories)
    {
        for (int i = 0; i < categories.size(); i++)
        {
            if (categories.get(i).getCategoryName().equals(categoryName.toUpperCase()))
            {
                return i;
            }
        }
        return -1;
    }

    public static void manageCategory(Scanner scanner, Category category, User user)
    {
        while(true)
        {
            System.out.println("Choose an action for " + category.getCategoryName() + " category\n"
                    + "\t1.Buy something\n"
                    + "\t2.Sell something\n"
                    + "\t3.Add new subcategory\n"
                    + "\t4.Remove  subcategory\n"
                    + "\t5.Manage subcategory\n"
                    + "\t6.Show category information\n"
                    + "\t7.Go back\n"
                    + "\t8.Quit\n");


            switch (scanner.next())
            {
                case "1":

                    break;

                case "2":

                    break;


                case "3":
                    System.out.println("How do you want to name this new subcategory?");
                    category.AddSubCategory(scanner.next(),user, category);
                    break;

                case "4":
                    System.out.println("Which category do you want to remove?");
                    category.RemoveSubCategory(scanner.next());
                    break;

                case "5":
                    System.out.println("Which category would you like to manage?");
                    manageCategory(scanner,
                                   category.getSubCategories().
                                                 get(findCategoryIndex(scanner.next(),category.getSubCategories())),
                                   user);
                    break;

                case "6":
                    System.out.println(category.toString());
                    break;

                case "7":
                    return;

                case "8":
                    System.exit(0);

                default:
                    System.out.println("Read options again.");
            }
        }
    }
}
