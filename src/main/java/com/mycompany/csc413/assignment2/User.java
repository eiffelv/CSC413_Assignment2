/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csc413.assignment2;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Eiffel
 */
public class User {
  private String name;
  private String phone;
  private String username;
  private String password;
  private List<Account> accounts;
  private List<Transaction> transactions;

  public User(String name, String phone, String username, String password) {
    this.name = name;
    this.phone = phone;
    this.username = username;
    this.password = password;
    this.accounts = new ArrayList<>(); // Initialize account list
    this.transactions = new ArrayList<>(); // Initialize transaction list
  }

  public List<Account> getAccounts() {
    return accounts;
  }

  public void addTransaction(Transaction transaction) {
    transactions.add(transaction);
  }
  
  public String getUsername() {
      return this.username;
  }
  public String getPassword() {
      return this.password;
  }
  public String getName() {
      return this.name;
  }
  public String getPhone() {
      return this.phone;
  }
  
  public void setUsername(String username) {
      this.username = username;
  }
  public void setPassword(String password) {
      this.password = password;
  }
  public void setName(String name) {
      this.name = name;
  }
  public void setPhone(String phone) {
      this.phone = phone;
  }
}