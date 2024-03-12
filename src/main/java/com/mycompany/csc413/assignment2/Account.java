/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csc413.assignment2;

import java.util.Date;
/**
 *
 * @author Eiffel
 */
public class Account {
  private long balance;
  private Date creationDate;

  // Getters, setters, deposit, withdraw methods

  public long getBalance() {
    return balance;
  }

  public void deposit(long amount) {
    this.balance += amount;
  }

  public void withdraw(long amount) {
    if (balance < amount) {
      System.out.println("Insufficient funds.");
    }
    this.balance -= amount;
  }
}
