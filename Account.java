/**
 * Account Class: Class that will create the bank accounts for the bank software.
 * The accounts will be stored in a data structure for easy retrieval and storage.
 * All accounts have a first name, last name, middle I, phone number and social security.
 * They also have balances, and current debt on the account as well.
 * @author mgebremariam7
 * @version 1.1
 */
public class Account {
    private String userName;
    private String passWord;
    private double balance;
    private double currentDebt;
    private Person person;
    private long accNumber;

    /**
     * Constructor that takes in all information that a Person can store in their account provided by the user.
     * @param userName username of the account
     * @param passWord password of the account
     * @param balance balance on the current account
     * @param currentDebt current debt on the account
     * @param person person associated with the account
     */
    public Account(String userName, String passWord, double balance, double currentDebt, Person person) {
        this.userName = userName;
        this.passWord = passWord;
        this.balance = balance;
        this.currentDebt = currentDebt;
        this.person = person;
        this.accNumber = (long) ((Math.random() * 900000000) + 100000000);
    }

    /**
     * Constructor with no-arg in the parameters.
     */
    public Account() {
        this.userName = "joemama";
        this.passWord = "travis999";
        this.balance = 1500.00;
        this.currentDebt = 0;
        this.person = new Person("MENELIK", 'K', "GEBREMARIAM", "4047779905", 605053456);
    }


    public double getBalance() {
        return this.balance;
    }
    public double getCurrentDebt() {
        return this.currentDebt;
    }
    public String getUserName() {
        return this.userName;
    }
    public String getPassWord() {
        return this.passWord;
    }
    public Person getPerson() {
        return this.person;
    }
    public long getAccNumber() {
        return this.accNumber;
    }


    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void setCurrentDebt(double currentDebt) {
        this.currentDebt = currentDebt;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
}
