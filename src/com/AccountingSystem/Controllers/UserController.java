package com.AccountingSystem.Controllers;

import com.AccountingSystem.Models.IndividualUser;
import com.AccountingSystem.Models.LegalUser;
import com.AccountingSystem.Models.User;

import java.util.ArrayList;
import java.util.Scanner;

public class UserController {
    public static void manageUsers(Scanner scanner, ArrayList<User> users)
    {
        while (true)
        {
            System.out.println("What do you want to do? \n"
                    + "\t1.Add new user\n"
                    + "\t2.Remove existing user\n"
                    + "\t3.Modify existing user\n"
                    + "\t4.Show all users\n"
                    + "\t5.Go back\n"
                    + "\t6.Quit\n");

            switch (scanner.next()) {
                case "1":
                    AddNewUser(scanner, users);
                    break;

                case "2":
                    System.out.println("Which user would you like to remove?");
                    RemoveUser(scanner, scanner.next(), users);
                    break;

                case "3":
                    System.out.println("Which user would you like to modify?");
                    ModifyUser(scanner,scanner.next(),users);
                    break;

                case "4":
                    ShowUsers(users);
                    break;

                case "5":
                    return;

                case "6":
                    System.exit(0);

                default:
                    System.out.println("Read your options again.");
            }
        }
    }

    private static void AddNewUser(Scanner scanner, ArrayList<User> users)
    {
        System.out.println("What kind of user would you like to add? \n1.IndividualUser \n2.LegalUser \n3.Go back \n4.Exit");
        switch (scanner.next())
        {
            case "1":
                AddIndividualUser(users);
                break;

            case "2":
                AddLegalUser(users);
                break;

            case "3":
                return;

            case "4":
                System.exit(0);

            default:
                System.out.println("Read the options again.");
        }
    }

    private static void RemoveUser(Scanner scanner, String userName, ArrayList<User> users)
    {
        if (UserIsValid(scanner, userName, users))
        {
            users.remove(FindUserIndex(userName, users));
            //ar nera kad trinamas vartotojas yra kazkurios kategorijos astakingas asmuo
        }
    }

    private static void ModifyUser(Scanner scanner, String userName, ArrayList<User> users)
    {
        if (UserIsValid(scanner, userName, users))
        {
            int userIndex = FindUserIndex(userName, users);

            while (true)
            {
                System.out.println("What do you want to do for user " + users.get(userIndex).getLoginName() + " ?\n"
                        + "\t1.Edit username\n"
                        + "\t2.Edit password\n"
                        + "\t3.Go back\n"
                        + "\t4.Quit\n");

                switch (scanner.next())
                {
                    case "1":
                        System.out.println("What will be the new username?");
                        SetUsername(users.get(userIndex),scanner.next());
                        break;

                    case "2":
                        System.out.println("What will be the new password?");
                        SetPassword(users.get(userIndex),scanner.next());
                        break;

                    case "3":
                        return;

                    case "4":
                        System.exit(0);

                    default:
                        System.out.println("Read options again.");
                }
            }


        }
    }

    private static void SetUsername(User user, String newUsername)
    {
        user.setLoginName(newUsername);
        System.out.println("New username for this user will be " + user.getLoginName());
    }

    private static void SetPassword(User user, String newPassword)
    {
        user.setLoginPassword(newPassword);
        System.out.println("New password for user " + user.getLoginName() + " will be " + user.getLoginPassword());
    }

    private static boolean UserIsValid(Scanner scanner, String userName, ArrayList<User> users)
    {
        int userIndex = FindUserIndex(userName, users);


            if(userIndex != -1)
            {
                if(users.get(userIndex).getLoginName().equals(userName))
                {
                    System.out.println("Please enter password for " + userName);
                    if (UserIsAuthenticated(scanner, users.get(userIndex)))
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
            }
            System.out.println("Such user doesn't exist.");
            return false;
    }

    private static int FindUserIndex (String userName, ArrayList<User> users)
    {
        for (int i = 0;i < users.size(); i++)
        {
            if(users.get(i).getLoginName().equals(userName))
            {
                return i;
            }
        }
        return -1;
    }

    private static boolean UserIsAuthenticated(Scanner scanner, User user)
    {
        if (user.getLoginPassword().equals(scanner.next()))
        {
            return true;
        }
        else
        {
            System.out.println("Password is wrong.");
            return false;
        }
    }

    public static boolean LoginSuccessful(Scanner scanner, ArrayList<User> users)
    {
        System.out.println("Please enter username.");
        if (UserIsValid(scanner,scanner.next(), users))
        {
            return true;
        }
        else return false;
    }

    public static void ShowUsers(ArrayList<User> users)
    {
        System.out.print("Users: ");
        for (User user : users)
        {
            System.out.print(user.getLoginName() + " ");
        }
        System.out.print("\n");
    }

    public static void AddIndividualUser(ArrayList<User> users)
    {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter details for new individual user. \t Pattern: Name;Surname;Email;Phone;Username;Password");

            String[] userDetails = scanner.next().replace(" ", "").split(";");

            User individualUser = new IndividualUser(userDetails[0],
                    userDetails[1],
                    userDetails[2],
                    userDetails[3],
                    userDetails[4],
                    userDetails[5]);

            users.add(individualUser);

        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println(e.getMessage());
        }
    }

    public static void AddLegalUser(ArrayList<User> users)
    {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter details for new legal user. \t Pattern:Name;Address;Email;Phone;CompanyCode;Username;Password");

            String[] userDetails = scanner.next().replace(" ", "").split(";");

            User legalUser = new LegalUser(userDetails[0],
                    userDetails[1],
                    userDetails[2],
                    userDetails[3],
                    userDetails[4],
                    userDetails[5],
                    userDetails[6]);

            users.add(legalUser);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.toString());
        }
    }
}
