/**
 * Person class: Holds all the data of the person who has a bank account.
 * A person will be associated with an account, as that allows us to do stuff with the account in the front
 * and the personal information more abstracted from the GUI code.
 * @author mgebremariam7
 * @version 1.1
 */
public class Person {
    private String firstName;
    private char middleInitial;
    private String lastName;
    private String phoneNumber;
    private int socialSecurity;

    /**
     * Constructor that creates a person associated with an account.
     * @param firstName first name of person with the account
     * @param middleInitial middle initial of person with the account
     * @param lastName last name of person with the account
     * @param phoneNumber phone number of the person with the account
     * @param socialSecurity social security of a person with account
     */
    public Person(String firstName, char middleInitial, String lastName,
                  String phoneNumber, int socialSecurity) {
        setFirstName(firstName);
        setMiddleInitial(middleInitial);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setSocialSecurity(socialSecurity);
    }




    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public char getMiddleInitial() {
        return this.middleInitial;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    public int getSocialSecurity() {
        return this.socialSecurity;
    }



    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setMiddleInitial(char middleInitial) {
        this.middleInitial = middleInitial;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setSocialSecurity(int socialSecurity) {
        this.socialSecurity = socialSecurity;
    }
}
