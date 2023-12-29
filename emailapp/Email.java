package emailapp;

import java.util.Scanner;

public class Email {
    //atributes of email class
    private String firstName, lastName, department, password, recoveryEmail;
    private int mailBoxCapacity = 500;

    //constructor
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.format("Email created: %s %s", firstName, lastName + "\n");
        
        //call a method to ask for department + return the department
        this.department = setDepartment();
        System.out.println("Department: " + this.department);
        
        //call a method that returns a random password
        this.password = randomPassword(8);
        System.out.println("Random password created: " + this.password);
        //combine elements to create email
        String email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department.toLowerCase() + "." + "company.com";
        System.out.println("Your email: " + email);
    }
    //ask for a department
    private String setDepartment(){
        System.out.format("Enter the department:\n"
                + "1 for sales\n"
                + "2 for development\n"
                + "3 for accounting\n"
                + "0 for none\n"
                + "Code department: ");
        //select department
        try (Scanner in = new Scanner(System.in)) {
            int depChoice = in.nextInt();
            switch (depChoice){
                case 1:
                    return "sales";
                    
                case 2:
                    return "development";
                    
                case 3:
                    return "accounting";
                    
                case 0:
                    return "";
                
                default:
                    System.out.println("Invalid department code, unable to set department");
                    return "";
                    
   }
        }   
}
    //generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
        char[] password = new char[length];
        for (int i = 0 ; i < length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

        
    //set the mailbox capacity
    public void setMailBoxCapacity(int capacity){
        this.mailBoxCapacity = capacity;}
 
    //set recovery email
    public void setRecoveryEmail(String recovery){
        this.recoveryEmail = recovery;}
    
    //change the password

    public void setPassword(String password) {
        this.password = password;
    }
    //get methods
    public String getRecoveryEmail() {
        return recoveryEmail;
    }

    public int getMailBoxCapacity() {
        return mailBoxCapacity;
    }

    public String getPassword() {
        return password;
    }
    //show information
    public void showInfo(){
        String email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department.toLowerCase() + "." + "company.com";;
        System.out.println("Name: " + this.firstName + " " + this.lastName + "\nEmail: " + email + "\nMailbox capacity: " + this.mailBoxCapacity + "mb");}

    }
    



