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
public class Transaction {
  private long amount;
  private String type;
  private Date date;

  public Transaction(long amount, String type, Date date) {
    this.amount = amount;
    this.type = type;
    this.date = date;
  }
}