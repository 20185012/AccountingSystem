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
                    + "\t1.Overall Finances\n"
                    + "\t2.Buy something\n"
                    + "\t3.See history of purchases\n"
                    + "\t4.Sell something\n"
                    + "\t5.See history of sales\n"
                    + "\t6.Add new subcategory\n"
                    + "\t7.Remove  subcategory\n"
                    + "\t8.Manage subcategory\n"
                    + "\t9.Show category information\n"
                    + "\t10.Go back\n"
                    + "\t11.Quit\n");


            switch (scanner.next())
            {
                case "1":
                    category.ShowOverallFinances();
                    break;

                case "2":
                    category.BuySomething(scanner);
                    break;

                case "3":
                    category.ShowOutcomeHistory();
                    break;

                case "4":

                    break;

                case "5":

                    break;

                case "6":
                    System.out.println("How do you want to name this new subcategory?");
                    category.AddSubCategory(scanner.next(),user, category);
                    break;

                case "7":
                    System.out.println("Which category do you want to remove?");
                    category.RemoveSubCategory(scanner.next());
                    break;

                case "8":
                    System.out.println("Which category would you like to manage?");
                    manageCategory(scanner,
                                   category.getSubCategories().
                                                 get(findCategoryIndex(scanner.next(),category.getSubCategories())),
                                   user);
                    break;

                case "9":
                    System.out.println(category.toString());
                    break;

                case "10":
                    return;

                case "11":
                    System.exit(0);

                default:
                    System.out.println("Read options again.");
            }
        }
    }
}
