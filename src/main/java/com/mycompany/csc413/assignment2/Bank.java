/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.csc413.assignment2;

/**
 *
 * @author Eiffel
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Bank {

  private List<User> users;
  private PriorityQueue<Account> accounts;

  public Bank() {
    this.users = new ArrayList<>();
    this.accounts = new PriorityQueue<>();
  }

  public void registerUser(String name, String phone, String username, String password) {
    User user = new User(name, phone, username, password);
    users.add(user);
  }

  public User login(String username, String password) {
    for (User user : users) {
      if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
        return user;
      }
    }
    return null;
  }

  public void deposit(User user, Account account, long amount) {
    account.deposit(amount);
    accounts.remove(account); // Remove and re-add to update priority
    accounts.add(account);
    user.addTransaction(new Transaction(amount, "Deposit", new Date()));
  }

  public void withdraw(User user, Account account, long amount) {
    if (account.getBalance() < amount) {
      System.out.println("Insufficient funds.");
    }
    account.withdraw(amount);
    accounts.remove(account); // Remove and re-add to update priority
    accounts.add(account);
    user.addTransaction(new Transaction(amount, "Withdrawal", new Date()));
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Bank bank = new Bank();

    // Menu loop for user interaction
    while (true) {
      System.out.println("Welcome to FOO Bank by Eiffel!");
      System.out.println("1. Register");
      System.out.println("2. Login");
      System.out.println("3. Exit");

      int choice = scanner.nextInt();

      switch (choice) {
        case 1:
          // Registration logic
          System.out.println("Enter name: ");
          String name = scanner.next();
          System.out.println("Enter phone number: ");
          String phone = scanner.next();
          System.out.println("Enter username: ");
          String username = scanner.next();
          System.out.println("Enter password: ");
          String password = scanner.next();
          bank.registerUser(name, phone, username, password);
          break;
        case 2:
          // Login logic
          System.out.println("Enter username: ");
          username = scanner.next();
          System.out.println("Enter password: ");
          password = scanner.next();
          User user = bank.login(username, password);
          if (user != null) {
            // Account management options for logged-in user
          } else {
            System.out.println("Invalid login credentials");
          }
          break;
        case 3:
          System.out.println("Exiting MyBank");
          scanner.close();
          return;
        default:
          System.out.println("Invalid choice");
      }
    }
  }
}