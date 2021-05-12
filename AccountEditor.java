import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * AccountEditor Class: Class that creates the account information page for the bank system.
 * @author mgebremariam7
 * @version 1.1
 */
public class AccountEditor extends GridPane {
    private Account account;
    private GridPane gridPane;
    /**
     * Constructor for the account editor.
     * @param account account that will be displayed
     */
    public AccountEditor(Account account) {
        // gridpane wont display!!!! FIX THIS SHIT
        this.account = account;
        this.gridPane = accountGrid();
        gridPane.setAlignment(Pos.CENTER);
    }

    /**
     * Method that produces the grid pane that holds the data from the account.
     * @return the gridPane that holds displayed account information
     */
    public GridPane accountGrid() {
        GridPane gridPane1 = new GridPane();
        gridPane1.setAlignment(Pos.CENTER);
        //gridPane.setStyle("-fx-border-width:5");
        gridPane1.setHgap(35);
        gridPane1.setVgap(25);
        Label nameHeader = new Label("FULL NAME:");
        nameHeader.setFont(Font.font("family", FontWeight.BOLD, 20));
        Label ssHeader = new Label("LAST 4 DIGITS - SSID:");
        ssHeader.setFont(Font.font("family", FontWeight.BOLD, 20));
        Label debtHeader = new Label("CURRENT DEBT ON ACCOUNT:");
        debtHeader.setFont(Font.font("family", FontWeight.BOLD, 20));
        Label accNumHeader = new Label("ACCOUNT NUMBER:");
        accNumHeader.setFont(Font.font("family", FontWeight.BOLD, 20));
        gridPane1.add(nameHeader, 0, 0);
        gridPane1.add(ssHeader, 0, 1);
        gridPane1.add(debtHeader, 0, 2);
        gridPane1.add(accNumHeader, 0, 3);
        gridPane1.add(new Label(account.getPerson().getFirstName() + " "
                + account.getPerson().getMiddleInitial() + " " + account.getPerson().getLastName()), 1, 0);
        String ssid = "" + account.getPerson().getSocialSecurity();
        gridPane1.add(new Label("***-**-" + ssid.substring(5)), 1, 1);
        gridPane1.add(new Label(String.format("%.2f", account.getCurrentDebt())), 1, 2);
        gridPane1.add(new Label(String.format("%d", account.getAccNumber())), 1, 3);
        return gridPane1;
    }

    /**
     * Gets the gridPane for the account setting.
     * @return the gridpane displaying the account information
     */
    public GridPane getGridPane() {
        return this.gridPane;
    }
}