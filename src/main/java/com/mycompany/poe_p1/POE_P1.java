/*
=====================================Student Information=================================================
Student Number:     st10251759
Student Name:       Cameron Chetty
Course:             BCAD PROG5112
Group:              1
==========================================================================================================
*/

package com.mycompany.poe_p1;
//import the joptionpane to project => used for user input and output messages
import javax.swing.JOptionPane;

public class POE_P1 {//begin public class

    public static void main(String[] args)
    {//begin main method
      
    //Geting the user Input using JOptionPane    
     String userFirstName = JOptionPane.showInputDialog(null, "Please enter your first name/s");
     String userLastName = JOptionPane.showInputDialog(null, "Please enter your last name");
     String userName = JOptionPane.showInputDialog(null, "Please enter your User name");
     String userPassword = JOptionPane.showInputDialog(null, "Please enter your password");
    /*
    =============Code Attribution====================
    Author: Alex Lee
    Date: 13 April 2023
    Website: https://www.youtube.com/watch?v=XNWvF-xsCoY
    Date of Access: 22 April 2023
    =============Code Attribution====================
    */    
    
     //instantiation of object where the login constructor passess the parameters
     Login registerUser = new Login(userFirstName,userLastName,userName,userPassword);   
     
     
     //checkUserName method call from Login Class and is stored in a boolean varaible i.e return true/false
     boolean isValidUserName = registerUser.checkUserName();
     
     //checkPasswordComplexity method call from Login Class and is stored in a boolean varaible i.e return true/false
     boolean isValidUserPassword = registerUser.checkPasswordComplexity();
     
     
     
     //registerUser method from Login Class where based on the validity of the userName and UserPassword will determine if the user has registered successfully
     registerUser.registerUser();
     
     //if statement to allow user to enter userName and userPassword only if they are successfully registereed
     if(isValidUserName && isValidUserPassword)
     {//begin if true statement
         String verifyUserName = JOptionPane.showInputDialog(null, "Please verify your username to login");
         String verifyUserPassword = JOptionPane.showInputDialog(null, "Please verify your password to login");
         //Pass parametters to LoginUser method to check the password and username
         registerUser.loginUser(verifyUserName, verifyUserPassword);
         //call returnLoginStatus to see if the login is successful or not
         registerUser.returnLoginStatus();
     }//end if true statement
     
        
    }//end main method
}//end public class
