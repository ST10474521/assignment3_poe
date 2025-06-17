 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MxolisiMaluleka;

import java.util.HashMap;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

//THIS CLASS CONTAINS A HASH MAP THAT HOLDS AND STORES THE USER'S INFORMATION. 
public class Login{   
    private static HashMap<String, String> userDatabase = new HashMap<>();
     private boolean loginStatus = false;
    
   //THIS METHOD CHECKS THE USERNAME. 
    public static boolean checkingtheusername(String username) throws IllegalArgumentException {
        String regex = "^(?=.*_)[a-zA-Z0-9_]{1,5}$";
        return username.matches(regex);
    }
 //THIS METHOD CHECKS THE PASSWORD COMPLEXITY.
    public static boolean checkpasswordcomplexity(String password)  throws IllegalArgumentException{
    
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return Pattern.matches(regex, password);
    }
    //THIS METHOD CHECKS THE SOUTH AFRICAN CELLPHONE NUMBER.
    public static boolean checkingtheSAcellnumber(String number) throws IllegalArgumentException{
        String Regex =  "^\\+27[6-8][0-9]{8}$";
      return Pattern.matches(Regex,number);
    }
    
     //THIS METHOD CHECKS AND CAPTURES THE FIRST NAME.
     public String UserRegistration(String username, String password, String phoneNumber)  throws IllegalArgumentException {
         
          if ( Registration.firstname.equals("")){
             String Firstname = "Please Enter Your First Name";
            JOptionPane.showMessageDialog(null, Firstname, "Registration Error", JOptionPane.ERROR_MESSAGE);
            return Firstname; 
          }else {
        
           String message = "YOUR FIRST NAME IS: " +Registration.firstname;
           JOptionPane.showMessageDialog(null, message);
        }
          
          //THIS METHOD CHECKS AND CAPTURES THE LAST NAME.
          if ( Registration.lastname.equals("")){
             String lastname = "Please Enter Your Last Name";
            JOptionPane.showMessageDialog(null, lastname, "Registration Error", JOptionPane.ERROR_MESSAGE);
            return lastname; 
          }else {
        
           String SAY = "YOUR LAST NAME IS: " +Registration.lastname;
           JOptionPane.showMessageDialog(null, SAY);
        }
          
          
       //THIS METHOD CHECKS AND VERIFIES THE USERNAME.   
        if (!checkingtheusername(username)) {
              
            String message = "INCORRECT USERNAME FORMAT, Please ensure that your username contains an underscore and is no more than five(5) characters.";
            JOptionPane.showMessageDialog(null, message, "Registration Error", JOptionPane.ERROR_MESSAGE);
            
            return message;
        }else {
              
            String messagee1 = "USERNAME HAS BEEN SUCCESSFULLY ADDED.";
            JOptionPane.showMessageDialog(null, messagee1, "Registration ", JOptionPane.INFORMATION_MESSAGE);
            
        }
        
        // THIS METHOD CHECKS AND VERIFIES THE PASSWORD COMPLEXITY.
        if (!checkpasswordcomplexity(password)) {
            
            String message = "THIS PASSWORD IS INVALID , your Password must contain a Capital Letter, a Special Case, an Underscore, a Number and is atleast EIGHT(8) Characters Long.";
            JOptionPane.showMessageDialog(null, message, "Registration Error", JOptionPane.ERROR_MESSAGE);
            
            return message;
        }else {
            
            String messagee1 = "PASSWORD HAS BEEN SUCCESSFULLY ADDED.";
            JOptionPane.showMessageDialog(null, messagee1, "Registration ", JOptionPane.INFORMATION_MESSAGE);
            
        }
        
        // THIS METHOD CHECKS AND VERIFIES THE CELLPHONE NUMBER.
        if (!checkingtheSAcellnumber(phoneNumber)) {
            
            String message = "INVALID CELLPHONE NUMBER , PLEASE MAKE SURE THIS A SOUTH AFRICAN NUMBER AND STARTS WITH THE SA_INTERNATIONAL CODE(+27)";
            JOptionPane.showMessageDialog(null, message, "Registration Error", JOptionPane.ERROR_MESSAGE);
            
            return message;
        }else {
            
            String messagee1 = "YOUR CELLPHONE NUMBER HAS BEEN SUCCESSFULLY ADDED.";
            JOptionPane.showMessageDialog(null, messagee1, "Registration ", JOptionPane.INFORMATION_MESSAGE);
            
        }
        
//THIS METHOD RETURNS THE REGISTRATION SUCCESS MESSAGE IF THE USER MEETS THE REQUIREMENTS.
        userDatabase.put(username, password);
        String successMessage = "YOUR ACCOUNT REGISTRATION IS COMPLETE AND SUCCESSFUL , PLEASE LOG IN.";
        JOptionPane.showMessageDialog(null, successMessage, "Registration Successful", JOptionPane.INFORMATION_MESSAGE);
       
        return successMessage;
    }

    //THIS METHOD CHECKS THE STORED USER'S INFORMATION.
    public boolean Logintheuser(String username, String password) {
        System.out.println("Loging in : " + username);
        System.out.println("Password stored : " + userDatabase.get(username));
        System.out.println("Your Password is: " + password);

      return userDatabase.containsKey(username) && userDatabase.get(username).equals(password);
    }

    // THIS METHOD CHECKS AND VERIFIES THE USER'S STORED DETAILS AND RETURNS THE LOGIN STATUS
    public String LoginStatusreturner(boolean isSuccess) {
        String message = isSuccess ? 
        "WELCOME BACK " + Registration.firstname + " " +  Registration.lastname + " IT IS GREAT TO SEE YOU AGAIN!!!" :
        "INCORRECT USERNAME OR PASSWORD, PLEASE TRY AGAIN.";
    
        JOptionPane.showMessageDialog(null, message, "LOGIN STATUS", isSuccess ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
        
      return message;
    }
}
