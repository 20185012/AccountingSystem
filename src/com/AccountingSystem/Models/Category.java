package com.AccountingSystem.Models;

import com.AccountingSystem.Controllers.CategoryController;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

@Data
public class Category implements Serializable {
    //int categoryId;
    String categoryName;
    //String categoryDescription;
    ArrayList<User> responsibleUsers;
    //ArrayList<User> usersWithAccess;
    ArrayList<Category> subCategories;
    Category parentCategory;
    Money overallFinances;
    ArrayList<Receivable> income;
    ArrayList<Payment> expense;
    LocalDate dateCreated;
    //LocalDate dateModified;
    //boolean active;


    public Category(String categoryName,
                    User creatorUser,
                    Category parentCategory) {

        this.categoryName = categoryName;
        this.responsibleUsers = new ArrayList<User>();
        this.responsibleUsers.add(creatorUser);
        this.subCategories = new ArrayList<>();

        if (parentCategory != null) this.parentCategory = parentCategory;
        else this.parentCategory = null;

        this.income = new ArrayList<Receivable>();
        this.expense = new ArrayList<Payment>();
        this.overallFinances = new Money();


        this.dateCreated = LocalDate.now();
    }


    public String getCategoryName() {
        return categoryName;
    }

    public ArrayList<Category> getSubCategories() { return subCategories; }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }




    public void AddSubCategory(String categoryName, User user, Category parentCategory)
    {
        subCategories.add(new Category(categoryName.toUpperCase(), user, parentCategory));

        System.out.println("Subcategory " + categoryName + " is successfully created.");
    }

    public void RemoveSubCategory(String categoryName)
    {
        try
        {
            subCategories.remove(CategoryController.findCategoryIndex(categoryName,subCategories));
            System.out.println("Category " + categoryName + " is successfully removed.\t");
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("Such category doesn't exist. \t");
        }
    }



    public void ShowOverallFinances()
    {
        System.out.println("Overall monetary balance is: " + overallFinances.getAmount());
    }

    public void BuySomething()
    {
        System.out.println("How much this thing costs?");

        Money price = new Money(Money.SpecifyPrice());

        Payment payment = Payment.MakeNewPayment(price);

        AddToExpenses(payment);

        SubstractFromOverall(price);
    }



    public void ShowOutcomeHistory()
    {
        for (Payment payment : expense)
        {
            payment.ShowPaymentDetails();
        }
    }


    public void SellSomething()
    {
        System.out.println("How much this thing costs?");

        Money price =  new Money(Money.SpecifyPrice());

        Receivable receivable = Receivable.MakeNewReceivable(price);

        income.add(receivable);

        overallFinances.AddMoney(price);
    }

    public void ShowIncomeHistory()
    {
        for (Receivable receivable : income)
        {
            receivable.ShowReceivableDetails();
        }
    }

    private void SubstractFromOverall(Money price) {
        overallFinances.SubtractMoney(price);
    }

    private void AddToExpenses(Payment payment) {
        expense.add(payment);
    }

    public String toString() {
        StringBuilder categoryInfo = new StringBuilder("Category: " + this.categoryName + "\nResponsible Users: ");

        for (User user : responsibleUsers) { categoryInfo.append(user.loginName + "  "); }

        categoryInfo.append("\n");

        for (Category category : this.subCategories) { categoryInfo.append(category.categoryName + "  "); }

        categoryInfo.append("\nCategoryCreated: " + dateCreated + "\n");

        return categoryInfo.toString();
    }
}
