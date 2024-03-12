/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.csc413.assignment2;

import java.lang.*;
import java.io.*;
import java.util.List;
import java.util.Iterator;
import java.net.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.type.TypeReference;

import javax.json.stream.*;
import javax.json.JsonReader;
import javax.json.JsonObject;
import javax.json.JsonArray;
import javax.json.Json;


 /*
 * @author karunmehta
 */
public class JSON {

    static ObjectMapper objectMapper = null;

    static String jsonUserString = "{ \"username\" : \"James Madison\", \"email\" : \"jmadison@sfsu.edu\", \"phone\" : \"777-1212\", \"id\" : \"100\" }";
    static String jsonUsersString = "[{ \"username\" : \"James Madison\", \"email\" : \"jmadison@sfsu.edu\", \"phone\" : \"777-1212\", \"id\" : \"200\" }, { \"username\" : \"James Matteson\", \"email\" : \"jmatteson@sfsu.edu\", \"phone\" : \"555-1212\", \"id\" : \"400\" }]";
    
    public static void main(String[] args) {

        // Parse JSON string to JsonNode
        objectMapper = new ObjectMapper();
        
        System.out.println("\nCreating User object"); 
        
        //create User object
        User emp = new User("Paula Abdul", "415-555-5555", "pabdul", "password");
        String empString = ""; 
        
        //create string version of the employee object
        try {
            empString = objectMapper.writeValueAsString(emp);
        } catch (JsonProcessingException jpe) {
            System.out.println(jpe.getMessage());
        }
        
        System.out.println("\nJSON String version of User object\n" + empString);
        
        
        //Read in employee strings as json tree
        try {
            JsonNode jsonNode1 = objectMapper.readTree(jsonUserString);
            JsonNode jsonNode2 = objectMapper.readTree(jsonUsersString);

            // Accessing JSON properties
            String name = jsonNode1.get("username").asText();
            String phone = jsonNode1.get("phone").asText();
            String username = jsonNode1.get("username").asText();
            String password = jsonNode1.get("password").asText();
            
            System.out.println("\nSingle User Detail JSON String:");
            String treeString = jsonNode1.toPrettyString();
            System.out.println(treeString);
            
            System.out.println("\nMultiple User Detail JSON String:");
            treeString = jsonNode2.toPrettyString();
            System.out.println(treeString);
            
            System.out.println("\nNow printing each employee detail: ");
            
            Iterator it = jsonNode2.elements();
            while(it.hasNext()) {
                
                JsonNode jNode = (JsonNode)it.next();

                // Printing JSON properties for the current node
                System.out.println("\nName: " + jNode.get("name").asText());
                System.out.println("Phone: " + jNode.get("phone").asText());
                System.out.println("Username: " + jNode.get("username").asText());
                System.out.println("Password: " + jNode.get("password").asText());
            
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Working with User Objects
        readJsonUser();
        readJsonUsers();
        //readJsonStream();
    }
    
    public static void readJsonStream() {

        URL url = null;
        JsonReader rdr = null;
        
        try {
            
            url = new URL("https://developers.facebook.com/docs/graph-api");
        
        } catch(MalformedURLException me) {
                
            me.printStackTrace();
                
        }
        
        try {
        
            InputStream is = url.openStream();        
            rdr = Json.createReader(is);   
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }

        JsonArray obj;
        obj = rdr.readArray();
        JsonArray results = obj.getJsonArray(1);
        for (JsonObject result : results.getValuesAs(JsonObject.class)) {
             System.out.print(result.getJsonObject("from").getString("name"));
             System.out.print(": ");
             System.out.println(result.getString("message", ""));
             System.out.println("-----------");
         }
    }        
   
    public static void readJsonUser() {

        User usObj = null;
        
        try {
            usObj = objectMapper.readValue(jsonUserString, User.class);
        } catch(JsonProcessingException jpe) {
            System.out.println(jpe.getMessage());
        }
        
        //Getting data from User object created from JSON String
        System.out.println("\nReading data from JSON String of single employee:"); 
        if (usObj != null) {
            System.out.println("Name: " + usObj.getUsername());
            System.out.println("Phone: " + usObj.getPhone());
            System.out.println("Username: " + usObj.getUsername());
            System.out.println("Password: " + usObj.getPassword());
        }
    }

    public static void readJsonUsers() {

        List<User> empList = null;
        
        try {
            empList = objectMapper.readValue(jsonUsersString,new TypeReference<List<User>>(){});
        } catch(JsonProcessingException jpe) {
            System.out.println(jpe.getMessage());
        }

        Iterator it = empList.iterator();
        
        System.out.println("\nReading data from multiple employees in JSON array:"); 
        
        while(it.hasNext()) {
            
            User us = (User)it.next();
            System.out.println("Name: " + us.getName());
            System.out.println("Phone: " + us.getPhone());
            System.out.println("Username: " + us.getUsername());
            System.out.println("Password: " + us.getPassword() + "\n");
        }

    }     
    
}
