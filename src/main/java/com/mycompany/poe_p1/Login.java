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
//Part One
public class Login {
//beginning of Login class, variable declaration and defining methods
private String userName;
private String userPassword;
private String userFirstName;
private String userLastName;

boolean checkUserName = false;
boolean checkPasswordComplexity = false;
boolean loginSuccess = false;

//Construstor metod to pass the parameters from main java class
public Login(String userFirstName, String userLastName, String userName, String userPassword)
{
this.userFirstName = userFirstName;
this.userLastName = userLastName;
this.userName = userName;
this.userPassword =  userPassword;

}
// End of Constructor

//method used to validate username i.e username contains underscore and is no more than 5 characters
public boolean checkUserName()
{//begin  checkuser method
    /*
    =============Code Attribution====================
    Author: Alan Morel
    Date: 25 May 2022
    Website: https://sabe.io/blog/java-check-string-contains-character#:~:text=string%20in%20Java.-,Using%20the%20String%20contains()%20method,the%20parameter%20to%20look%20for.
    Date of Access: 17 April 2023
    =============Code Attribution====================
    */
    //boolean variables to return true or false depending on conditions that are met
    boolean isValLengthUserName =  false;
    boolean containUnderScore = false;
    
    //this retrieves the length of the character in userName
    int numCharUserName = userName.length();
    
    //check that the userName is not longer than 5 chracters long
    if (numCharUserName <= 5)
    {//begin if 
    isValLengthUserName = true;
    }//end if
    
    // contains tells us wether the userName contains an underscore >>> returns true/false
    containUnderScore = userName.contains("_");
    
    //if statement that checks that username has an an underscore and not longer than 5 characters long
    if (isValLengthUserName && containUnderScore)
    {//begin if
        //if this is a valid user name
        JOptionPane.showMessageDialog(null, "Username successfully captured");
        checkUserName = true;  
    }//begin if
    else
    {//begin else
    //else if one or both conditions are not met >> username is not valid
        JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length .");  
    }//end else
   
    return checkUserName;
}// end checkuser method

public boolean checkPasswordComplexity()   
{ //begin checkpasswordComplexity
    
     /*
    =============Code Attribution====================
    Author: stack overflow
    Date: 03 April 2013
    Website: https://stackoverflow.com/questions/2451650/how-do-i-apply-the-for-each-loop-to-every-character-in-a-string#:~:text=The%20easiest%20way%20to%20for-each%20every%20char%20in,is%20mutable%29%2C%20so%20there%20is%20some%20cost%20penalty.
    Date of Access: 22 April 2023
    =============Code Attribution====================
    */
    
//varaibles for validation initialse false as default
    boolean valPasswordLength = false;
    boolean hasCaptialLetter = false;
    boolean containNumber = false;
    boolean containSpecialChar = false;
    
    //find the length of the password >> get the number of characters that make up the string stored in password

    int numCharPassword = userPassword.length();
    
    //check if password is greater than 8
    if (numCharPassword >= 8)
    {//begin if
    valPasswordLength = true;
    }//end if
    
    // run a for loop to get access to each character in the the password so that we can do a check each requirement for a valid password
    for (int i=0 ;i<numCharPassword;i++)
    {//begin for
    
    //variable created to store each individual character as loop runs
        char character = userPassword.charAt(i);
        
        //if statement to check if the character with the index i is in the captial letter
        if(Character.isUpperCase(character))
        {//if begin Captial Letter
          //true statement
            hasCaptialLetter = true;
        }//if end   Captial Letter
        
        //if staement to check if the character at index i is a digit
        if (Character.isDigit(character))
        {//if begin digit
            //true statement
            containNumber = true;
        }//if end digit
        
        //if statement to check if character is specail i.e not a digit and not a leter and not a space
        if (!Character.isLetterOrDigit(character))
         {//begin if special character
             //true statement
           containSpecialChar = true;
         }//end if special character
            
    }//end for

    //if the password is considered to be valid i.e has 8 characters or more, a captial letter, a digit and a specail character
    if(valPasswordLength && hasCaptialLetter && containNumber && containSpecialChar)
    {//begin if for valid password
        JOptionPane.showMessageDialog(null, "Password successfully captured");
        checkPasswordComplexity=true;
    }//end if for valid password
    //password does not meet the requirements mentioned above
    else 
    {//begin else paswword invalid
        JOptionPane.showMessageDialog(null, "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
    }//end paswword invalid
    
    return checkPasswordComplexity;
} //end checkPasswordComplexity

public void registerUser()
{//begin registerUser method
//this method contains if else statements based on the criteria met on the above methods
    //if the username and password is both valid
    if (checkPasswordComplexity && checkUserName)
    {//begin both password and username are valid
        JOptionPane.showMessageDialog(null, "User has been registered successfully");
    }//end both password and username are valid
    
    //else if just username is correct
    else if(checkUserName)
    {//begin else invalid password valid username 
        JOptionPane.showMessageDialog(null, "The password does not meet the complexity requirement");
    }//end else invalid password valid username 

    //else if password is correct
    else if(checkPasswordComplexity)
    {//begin else if password is valid and username is invalid
        JOptionPane.showMessageDialog(null, "Username is incorrectly formatted");
    }//end else if password is valid and username is invalid
    
    //else if password and username is invalid
    else
    {//begin if password and username invalid
        JOptionPane.showMessageDialog(null, "Invalid Username and Password, Please try again");
    }//end if password and username invalid   
   
    
}//end registerUser method

//This method verifies that the login details entered matches the login details stored when the user registers. 
public boolean loginUser(String verifyUserName, String verifyUserPassword) //uses the parameters that are passed from main method
{//begin LoginUser method

     /*
    =============Code Attribution====================
    Author: Programiz
    Website: https://www.programiz.com/java-programming/library/string/matches
    Date of Access: 22 April 2023
    =============Code Attribution====================
    */
    
    //if statement using a matches() method that will take in the parameters VerifyUserName and VerfiyUserPassword and return a boolean expression
    if (userName.matches(verifyUserName) && userPassword.matches(verifyUserPassword))
    {//begin if login successful 
        loginSuccess = true;
    }//end if login successful
    //return true or false
    return loginSuccess;
}//end LoginUserMethod

//method to return approperiate message for a successful or unsuccessful login
public void returnLoginStatus()
{//begin returnLoginStatus method

    //if the boolean loginSuccess = true
    if(loginSuccess)
    {//begin if successful login
        JOptionPane.showMessageDialog(null,"Login is Successful"+"+\nWelcome "+userFirstName+", "+userLastName+" it is great to see you again");
    }//end if unsuccessful login

    //else if boolean loginSuccess = false
    else
    {//begin if unsuccessful login
        JOptionPane.showMessageDialog(null, "User or password is incorrect, please try again");
    }//end if unsuccessful login
    
}//end returnLoginStatus method



//set methods for unit testing

public void setUserName(String userName)
{
this.userName = userName;
}

public void setPassword(String userPassword)
{
this.userPassword = userPassword;
}



}//end of Login Class
