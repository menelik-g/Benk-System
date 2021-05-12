import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.ArrayList;

/**
 * BANKGUI CLASS: Practice with JAVAFX layouts and inner classes with eventHandlers.
 * Also was able to try out and get working music lists to play back and cycle through with buttons!
 * 3 more weeks my dude!
 * 04/07/2021
 * @author mgebremariam7
 * @version 1.1
 */
public class BankGUI extends Application {
    private double balance;
    private ArrayList<Account> listOfAccounts = new ArrayList<Account>();
    private Account accountInUse;
    protected Stage myStage = new Stage();

    /**
     * Inner class Bank Header: Creates a specific kind of header banner for the bank system in a sHBox!
     */
    class BankHeader extends HBox {
        private Text headerText = new Text("Benk Systems Inc.");
        private ImageView headerPicture = new ImageView(new Image("bankheaderpic.jpg"));

        /**
         * Constructor for the bank header. Creates a header layout for the banking system.
         */
        public BankHeader() {
            this.headerText.setFont(Font.font("family", FontPosture.ITALIC, 70));
            this.headerPicture.setFitWidth(160);
            this.headerPicture.setFitHeight(100);
            getChildren().addAll(headerText, headerPicture);
            setStyle("-fx-background-color:lightblue");
            setSpacing(85);
            setAlignment(Pos.CENTER);
            setMaxHeight(280);
        }
    }

    public void createAccountLayout() {
        VBox createAccountBox = new VBox();
        BankHeader createAccountHeader = new BankHeader();
        createAccountHeader.setStyle("-fx-background-color:orange");
        Button confirmAccountCreation = new Button("Create Account");
        // Create entries for you to put in your new account's info
        TextField newFirstName = new TextField();
        TextField newMiddleInitial = new TextField();
        TextField newLastName = new TextField();
        TextField newUserName = new TextField();
        TextField newPassword = new TextField();
        TextField newPhoneNumber = new TextField();
        TextField newSocialSecurity = new TextField();
        TextField newBalance = new TextField();

        //Creates layout for each entry to create your new account
        Label firstNameEntry = new Label("First Name:", newFirstName);
        firstNameEntry.setContentDisplay(ContentDisplay.RIGHT);
        Label middleNameEntry = new Label("Middle Initial:", newMiddleInitial);
        middleNameEntry.setContentDisplay(ContentDisplay.RIGHT);
        Label lastNameEntry = new Label("Last Name:", newLastName);
        lastNameEntry.setContentDisplay(ContentDisplay.RIGHT);
        Label newUserNameEntry = new Label("New Username:", newUserName);
        newUserNameEntry.setContentDisplay(ContentDisplay.RIGHT);
        Label newPasswordEntry = new Label("New Password:", newPassword);
        newPasswordEntry.setContentDisplay(ContentDisplay.RIGHT);
        Label newPhoneNumberEntry = new Label("New Phone Number:", newPhoneNumber);
        newPhoneNumberEntry.setContentDisplay(ContentDisplay.RIGHT);
        Label newSocialSecurityEntry = new Label("Social Security:", newSocialSecurity);
        newSocialSecurityEntry.setContentDisplay(ContentDisplay.RIGHT);
        Label newBalanceEntry = new Label("Money to start account:", newBalance);
        newBalanceEntry.setContentDisplay(ContentDisplay.RIGHT);

        // Creates a HBox for a couple of labels
        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll(firstNameEntry, middleNameEntry, lastNameEntry);
        hBox1.setSpacing(40);
        hBox1.setAlignment(Pos.CENTER);

        // Creates a HBox for a couple of labels
        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(newPhoneNumberEntry, newSocialSecurityEntry, newBalanceEntry);
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setSpacing(40);

        // Creates a HBox for a couple of labels
        HBox hBox3 = new HBox();
        hBox3.getChildren().addAll(newUserNameEntry, newPasswordEntry);
        hBox3.setAlignment(Pos.CENTER);
        hBox3.setSpacing(40);

        HBox hBox4 = new HBox(confirmAccountCreation);
        hBox4.setAlignment(Pos.CENTER);

        HBox hBox5 = new HBox();
        Button goBack = new Button("Go Back");
        hBox5.getChildren().add(goBack);
        hBox5.setAlignment(Pos.CENTER);
        goBack.setOnAction((ae) -> {
            myStage.setScene(new Scene(loginLayout()));
        });

        // Adds everything to a VBox and sets it to the stage
        createAccountBox.getChildren().addAll(createAccountHeader, hBox1, hBox2, hBox3, hBox4, hBox5);
        createAccountBox.setSpacing(80);

        myStage.setTitle("Create Account");
        myStage.setScene(new Scene(createAccountBox));
        myStage.show();

        confirmAccountCreation.setOnAction((e) -> {
            if (newFirstName.getText().isEmpty() || newMiddleInitial.getText().isEmpty()
                    || newLastName.getText().isEmpty() || newUserName.getText().isEmpty()
                    || newPassword.getText().isEmpty() || newPhoneNumber.getText().isEmpty()
                    || newSocialSecurity.getText().isEmpty() || newBalance.getText().isEmpty()) {
                Alert missingInfo = new Alert(Alert.AlertType.WARNING,
                        "ERROR: Fill out all entries in order to create an account!");
                missingInfo.showAndWait();
            } else {
                listOfAccounts.add(new Account(newUserName.getText(), newPassword.getText(),
                        Double.parseDouble(newBalance.getText()), 0.0, new Person(newFirstName.getText().toUpperCase(),
                        newMiddleInitial.getText().toUpperCase().charAt(0), newLastName.getText().toUpperCase(),
                        newPhoneNumber.getText(), Integer.parseInt(newSocialSecurity.getText()))));
                myStage.setScene(new Scene(loginLayout()));
            }
        });
    }

    /**
     * Method that creates layout for the login screen of the banking system.
     * @return VBox holding the layout of the login screen.
     */
    public VBox loginLayout() {
        // Creates the header for the login system.
        Button loginButton = new Button("Login");
        Button clearLoginEntries = new Button("Clear");
        Button createAccountButton = new Button("Create New Account");
        BankHeader loginHeader = new BankHeader();
        loginHeader.setStyle("-fx-background-color:lightgreen");

        // Creates username entry row: Label and TextField
        TextField userNameEntry = new TextField();
        userNameEntry.setPrefSize(300, 45);
        Label userNameLabel = new Label("Username:");
        userNameLabel.setFont(Font.font(40));
        HBox userNameLine = new HBox(userNameLabel, userNameEntry);
        userNameLine.setSpacing(27);
        userNameLine.setAlignment(Pos.CENTER);

        // Creates password entry row: Label, passwordfield, and reveal button.
        PasswordField passWordEntry = new PasswordField();
        passWordEntry.setPrefSize(300, 45);
        Label passWordLabel = new Label("Password:");
        passWordLabel.setFont(Font.font(40));
        //CheckBox revealPassword = new CheckBox("Show password:");
        HBox passWordLine = new HBox(passWordLabel, passWordEntry);
        passWordLine.setAlignment(Pos.CENTER);
        passWordLine.setSpacing(35);

        // Creates the two buttons on the login screen with their actions.
        // One button is clear and the other does the login.
        loginButton.setMinSize(100, 80);
        clearLoginEntries.setMinSize(100, 80);
        createAccountButton.setMinSize(100, 80);
        HBox buttons = new HBox(loginButton, clearLoginEntries, createAccountButton);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(60);
        VBox loginVertical = new VBox(userNameLine, passWordLine, buttons);
        loginVertical.setSpacing(50);
        VBox loginLayout = new VBox(loginHeader, loginVertical);
        loginLayout.setSpacing(80);
        createAccountButton.setOnAction((ae) -> {
            createAccountLayout();
        });

        clearLoginEntries.setOnAction((ActionEvent ae) -> {
            userNameEntry.clear();
            passWordEntry.clear();
        });
        // Creates functionality for a login popup (If the account is not found)
        loginButton.setOnAction((e) -> {
            boolean accountFound = false;
            Alert loginAlert = new Alert(Alert.AlertType.WARNING);
            loginAlert.setTitle("Error");
            if (listOfAccounts.isEmpty()) {
                loginAlert.setContentText("No accounts are in the system currently, please create a new account!");
                loginAlert.showAndWait();
            } else {
                for (Account account : listOfAccounts) {
                    if (userNameEntry.getText().equals(account.getUserName())
                            && passWordEntry.getText().equals(account.getPassWord())) {
                        accountFound = true;
                        accountInUse = account;
                        myStage.setScene(new Scene(createMainBankPage()));
                    }
                }
                if (!accountFound) {
                    loginAlert.setContentText("Username/Password is incorrect. Retry again");
                    loginAlert.showAndWait();
                }
            }
        });
        return loginLayout;
    }

    /**
     * Creates the labels for the main bank page. This method is called by the createMainBankPage.
     * @return VBox with the labels of the balance, deposit and withdraw textfields
     */
    public VBox mainBankLabels() {
        VBox mainBankPageLabel = new VBox();
        Label balanceLabel = new Label("Account Balance:");
        Label depositLabel = new Label("Deposit to Account:");
        Label withdrawalLabel = new Label("Withdrawal from Account:");
        mainBankPageLabel.getChildren().addAll(balanceLabel, depositLabel, withdrawalLabel);
        balanceLabel.setFont(Font.font(20));
        depositLabel.setFont(Font.font(20));
        withdrawalLabel.setFont(Font.font(20));
        mainBankPageLabel.setAlignment(Pos.CENTER_LEFT);
        mainBankPageLabel.setSpacing(85);
        return mainBankPageLabel;
    }

    /**
     * Method that creates the main bank page that allows you withdraw, deposit and set the bank balance.
     * @return VBox that is the layout of the main bank page
     */
    public VBox createMainBankPage() {
        // Creates the full button layout for the bank system in this class.
        BankHeader headerBox = new BankHeader();
        VBox mainPageLabels = mainBankLabels();

        // Creates all of the input text fields for the bank system. Puts it into a VBox

        TextField balanceInput = new TextField();
        balanceInput.setFont(Font.font("family", FontWeight.MEDIUM, 20));
        TextField withdrawalInput = new TextField();
        withdrawalInput.setFont(Font.font("family", FontWeight.MEDIUM, 20));
        TextField depositInput = new TextField();
        depositInput.setFont(Font.font("family", FontWeight.MEDIUM, 20));
        VBox bankEntries = new VBox(balanceInput, depositInput, withdrawalInput);
        bankEntries.setAlignment(Pos.CENTER);
        bankEntries.setSpacing(70);

        // Creates the buttons that will execute the action of a particular text field. Puts it into HBox
        Button balanceButton = new Button("Set");
        Button withdrawalButton = new Button("OK");
        Button depositButton = new Button("OK");
        VBox buttons = new VBox(balanceButton, depositButton, withdrawalButton);
        buttons.setSpacing(95);
        HBox bankPageBody = new HBox(mainPageLabels, bankEntries, buttons);
        bankPageBody.setAlignment(Pos.CENTER);
        bankPageBody.setSpacing(70);

        // Creates a text space that shows the current balance. Changes as you deposit and withdraw.
        Button toAccountSettings = new Button("Account Settings");
        Button logOut = new Button("Log Out");
        Text displayChanges = new Text("Balance currently for " + accountInUse.getPerson().getLastName()
                + " account: " + accountInUse.getBalance());
        displayChanges.setFont(Font.font(16));
        displayChanges.setFill(Color.BLACK);
        HBox changes = new HBox(logOut, toAccountSettings, displayChanges);
        changes.setSpacing(80);
        changes.setAlignment(Pos.CENTER);

        VBox mainPageContent = new VBox(headerBox, bankPageBody, changes);
        mainPageContent.setSpacing(85);

        // Sets balance button to set the balance to what is entered into the balance textfield.
        Alert balanceAlert = new Alert(Alert.AlertType.ERROR);
        balanceButton.setOnAction((e) -> {
            if (balanceInput.getText().isEmpty() || Double.parseDouble(balanceInput.getText()) < 0.0) {
                balanceAlert.setContentText("ERROR: Desired Balance entry is not valid, please enter a non-negative number!");
                balanceAlert.showAndWait();
            } else {
                double balanceVal = Double.parseDouble(balanceInput.getText());
                accountInUse.setBalance(balanceVal);
            }
            displayChanges.setText("Balance currently for " + accountInUse.getPerson().getLastName()
                        + " account: " + accountInUse.getBalance());
        });

        // Sets deposit button to set the balance to what the balance is currently + value in deposit textfield
        depositButton.setOnAction(e -> {
            if (depositInput.getText().isEmpty() || Double.parseDouble(depositInput.getText()) < 0.0) {
                balanceAlert.setContentText("ERROR: Desired Deposit entry is not valid,"
                        + " please enter a non-negative number!");
                balanceAlert.showAndWait();
            } else {
                double depositVal = Double.parseDouble(depositInput.getText());
                accountInUse.setBalance(accountInUse.getBalance() + depositVal);
            }
            displayChanges.setText("Balance currently for " + accountInUse.getPerson().getLastName()
                    + " account: " + accountInUse.getBalance());
        });

        // Sets withdraw button to set the balance to what the balance is - value in withdraw textfield.
        withdrawalButton.setOnAction((ActionEvent ae) -> {
            if (withdrawalInput.getText().isEmpty() || Double.parseDouble(withdrawalInput.getText()) < 0.0) {
                balanceAlert.setContentText("ERROR: Desired Withdrawal entry is not valid,"
                        + " please enter a entry less than or equal to your current balance!");
                balanceAlert.showAndWait();
            } else {
                double withdrawVal = Double.parseDouble(withdrawalInput.getText());
                accountInUse.setBalance(accountInUse.getBalance() - withdrawVal);
            }
            displayChanges.setText("Balance currently for " + accountInUse.getPerson().getLastName()
                    + " account: " + accountInUse.getBalance());
        });

        toAccountSettings.setOnAction((ActionEvent ae) -> {
            // Creates the account settings page!
            BankHeader editorHeader = new BankHeader();
            editorHeader.setStyle("-fx-background-color:pink");
            GridPane accountEditor = new AccountEditor(accountInUse).getGridPane();
            Button goBack = new Button("Go back");
            VBox vBox = new VBox();
            vBox.getChildren().addAll(accountEditor, goBack);
            vBox.setSpacing(75);
            vBox.setAlignment(Pos.CENTER);
            VBox accountEditBox = new VBox();
            accountEditBox.getChildren().addAll(editorHeader, vBox);
            accountEditBox.setSpacing(75);
            myStage.setTitle("Account Editor");
            myStage.setScene(new Scene(accountEditBox));
            goBack.setOnAction((e) -> {
                myStage.setScene(new Scene(createMainBankPage()));
            });
        });
        logOut.setOnAction((e) -> {
            myStage.setScene(new Scene(loginLayout()));
            accountInUse = null;
        });
        return mainPageContent;
    }

    /**
     * Inner class: creates the startup screen that appears when the program is launched initially.
     * The screen shows the logo, company name, and has signatures at the bottom (COPYRIGHT, Author)
     */
    class StartupScreen extends VBox {
        /**
         * Constructor: creates the Startup screen/
         * This could be a method??
         */
        public StartupScreen() {
            setStyle("-fx-background-color:lightblue");
            Label mainHeader = new Label("Benk System Software");
            mainHeader.setFont(Font.font("family", FontWeight.EXTRA_BOLD, 40));
            Label signature1 = new Label("Benk Systems Inc. TM 2021");
            signature1.setFont(Font.font("family", FontPosture.ITALIC, 15));
            Label signature2 = new Label("Programmed by: Menelik Gebremariam");
            signature2.setFont(Font.font("family", FontPosture.ITALIC, 15));
            Label signature3 = new Label("Finished on: April 10, 2021");
            signature3.setFont(Font.font("family", FontPosture.ITALIC, 12));

            ImageView startupPicView = new ImageView(new Image("startuppic.jpg"));
            startupPicView.setFitWidth(370);
            startupPicView.setFitHeight(300);
            VBox center = new VBox(mainHeader, startupPicView);
            center.setAlignment(Pos.CENTER);
            center.setSpacing(40);

            VBox signature = new VBox(signature1, signature2);
            signature.setAlignment(Pos.BOTTOM_CENTER);
            signature.setSpacing(10);
            getChildren().addAll(center, signature);
            setAlignment(Pos.CENTER);
            setSpacing(60);
        }
    }

    @Override
    public void start(Stage stage) {
        listOfAccounts.add(new Account());
        StartupScreen startupScreen = new StartupScreen();
        Stage introStage = new Stage();
        Scene introScene = new Scene(startupScreen, 600, 600);
        introStage.setScene(introScene);
        introStage.setTitle("Benk Startup");
        introStage.getIcons().add(new Image("icon.jpg"));
        introStage.show();
        PauseTransition introDelay = new PauseTransition(Duration.seconds(4));
        introDelay.setOnFinished((e) -> {
            introStage.close();
            myStage.show();
        });
        introDelay.play();


        accountInUse = new Account();

        // Creates the main page and header
        // also Creates the full layout for the login screen!
        VBox createMainPage = createMainBankPage();
        VBox mainPage = new VBox(createMainPage);
        VBox loginPage = loginLayout();
        mainPage.setSpacing(50);
        Scene scene = new Scene(loginPage, 800, 600);
        myStage.setTitle("Benk Inc.");
        myStage.setScene(scene);
        myStage.getIcons().add(new Image("icon.jpg"));
    }
}