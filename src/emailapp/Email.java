package emailapp;

import java.util.Random;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String department;
    private String alternativeEmail;
    private int mailboxCapacity = 500;

    //constructyor to receive firstname and lastname
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        //ask the department
        this.department = setDepartment();
        //call a method that returns a random password
        this.password = randomPassword(8);
        //combine elements to create an email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + ".company";
        System.out.println("Email: " + email);
    }

    //set random password
    private String randomPassword(int lentgh){
        Random random = new Random();
        String charPossibilities = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
        String randomPassword = "";
        for(int i = 0; i < lentgh; i++){
            randomPassword += charPossibilities.charAt(random.nextInt(41));
        }
        System.out.println("Your password is: " + randomPassword);
        return randomPassword;
    }

    //change password
    public void changePassword(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the new password: ");
        this.mailboxCapacity = scan.nextInt();
    }

    //set mailbox capacity
    public void setMailboxCapacity(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the new mailbox capacity: ");
        this.mailboxCapacity = scan.nextInt();
    }

    //set alternative email
    public void setAlternativeEmail(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter an alternative email address: ");
        this.alternativeEmail = scan.nextLine();
    }

    //set department
    private String setDepartment(){
        Scanner scan = new Scanner(System.in);
        int option = 10;
        while(option > 3 || option < 0){
            System.out.print("Department codes \n0 - for none\n1 - for Sales\n2 - for Development\n3 - for Accounting\nEnter the department: ");
            option = scan.nextInt();
        }
        switch(option){
            case 0:
                return "";
            case 1:
                return "sales";
            case 2:
                return "development";
            case 3:
                return "accounting";
            default:
                return null;
        }
    }

    //show info
    public String showInfo(){
        return String.format("Name: %s %s\nEmail: %s\nMailbox capacity: %d\n", firstName, lastName, email, mailboxCapacity);
    }

    //getters

    public int getMailboxCapacity(){ return mailboxCapacity; }

    public String getAlternativeEmail(){ return alternativeEmail; }

    public String getPassword(){ return password; }
}
