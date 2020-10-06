package com.AccountingSystem.Models;

import com.AccountingSystem.Controllers.CategoryController;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

@Data
public class SystemRoot implements Serializable{
    public String companyName;
    public LocalDate systemInitialDate;
    public ArrayList<Category> rootCategories;
    public ArrayList<User> users;
    //ArrayList<User> currentUsers;

    public ArrayList<User> getUsers() {
        return users;
    }

    public SystemRoot(String companyName, LocalDate systemInitialDate, User systemCreator)
    {
        this.companyName = companyName;
        this.systemInitialDate = systemInitialDate;
        rootCategories = new ArrayList<Category>();

        users = new ArrayList<User>();
        users.add(systemCreator);
    }

    public void AddRootCategory (String categoryName, User user, Category parentCategory)
    {
        rootCategories.add(new Category(categoryName.toUpperCase(),user,parentCategory, LocalDate.now()));

        System.out.println("Root Category " + categoryName.toUpperCase() + " is succesfully added.\t");
    }

    public void RemoveRootCategory(String categoryName)
    {
        try
        {
            rootCategories.remove(CategoryController.findCategoryIndex(categoryName,rootCategories));
            System.out.println("Root category " + categoryName + " is successfully removed.\t");
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("Such category doesn't exist. \t");
        }
    }

    @Override
    public String toString() {
        StringBuilder systemInfo = new StringBuilder (this.companyName + "\n" + "InitialDate: "
                                                     + this.systemInitialDate + "\nSystemCreator: "
                                                     + this.users.get(0).loginName + "\nRoot Categories: ");

        for (Category category : rootCategories)
        {
            systemInfo.append(category.categoryName + " ");
        }

        return systemInfo.toString();
    }
}
