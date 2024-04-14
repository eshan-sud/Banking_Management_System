package JavaBankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class NewCustomerAccount extends JPanel implements Constants, ActionListener, KeyListener{
    private ButtonGroup genderGroup;
    private JCheckBox agreeToTerms;
    private JButton submitButton, mainMenuButton, resetButton;
    private CardLayout cardLayout;
    private Container cardPanel;
    private ArrayList<Component> listOfFields;
    public NewCustomerAccount(CardLayout cardLayout, Container cardPanel){
        // Panel Settings
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
        this.setLayout(null);
        this.setPreferredSize(FRAME_SIZE);
        this.addKeyListener(this);
        // Creating Components
        JLabel headingLabel = Utility.createGrandLabel("New Customer Account:-", 30, 20);
        JLabel nameLabel = Utility.createLabel("Name:", 50, 50);
        JTextField nameField = Utility.createTextField(200, 50);
        JLabel addressLabel = Utility.createLabel("Address:", 50, 100);
        JTextField addressField = Utility.createTextField(200, 100);
        JLabel phoneNumberLabel = Utility.createLabel("Phone No.:", 50, 150);
        JTextField phoneNumberField = Utility.createTextField(200, 150);
        JLabel emailLabel = Utility.createLabel("Email:", 50, 200);
        JTextField emailField = Utility.createTextField(200, 200);
        JLabel dobLabel = Utility.createLabel("DOB:", 50, 250);
        JComboBox<String> dateOfBirthDate = Utility.createComboBox(dates, 200, 250);
        JComboBox<String> dateOfBirthMonth = Utility.createComboBox(months, 280, 250);
        JComboBox<String> dateOfBirthYear = Utility.createComboBox(years, 360, 250);
        JLabel genderLabel = Utility.createLabel("Gender:", 50, 300);
        JRadioButton maleRadioButton = Utility.createRadioButton("Male", 200, 300);
        JRadioButton femaleRadioButton = Utility.createRadioButton("Female", 280, 300);
        JRadioButton otherRadioButton = Utility.createRadioButton("Other", 360, 300);
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        genderGroup.add(otherRadioButton);
        // Accept Terms & Conditions
        agreeToTerms = Utility.createCheckBox("Accept Terms & Conditions", 200, 350);
        // Submit, Reset, Main Menu Buttons
        submitButton = Utility.createButton("Submit", this, 150, 380);
        resetButton = Utility.createButton("Reset", this, 250, 380);
        mainMenuButton = Utility.createButton("Go Back", this, 350, 380);
        // Adding Components To The NewCustomerAccount Panel
        this.add(headingLabel);
        this.add(nameLabel);
        this.add(nameField);
        this.add(addressLabel);
        this.add(addressField);
        this.add(phoneNumberLabel);
        this.add(phoneNumberField);
        this.add(emailLabel);
        this.add(emailField);
        this.add(dobLabel);
        this.add(dateOfBirthDate);
        this.add(dateOfBirthMonth);
        this.add(dateOfBirthYear);
        this.add(genderLabel);
        this.add(maleRadioButton);
        this.add(femaleRadioButton);
        this.add(otherRadioButton);
        this.add(agreeToTerms);
        this.add(submitButton);
        this.add(resetButton);
        this.add(mainMenuButton);

        listOfFields = new ArrayList<>();
        listOfFields.add(nameField);
        listOfFields.add(addressField);
        listOfFields.add(phoneNumberField);
        listOfFields.add(emailField);
        listOfFields.add(dateOfBirthDate);
        listOfFields.add(dateOfBirthMonth);
        listOfFields.add(dateOfBirthYear);
        listOfFields.add(maleRadioButton);
        listOfFields.add(femaleRadioButton);
        listOfFields.add(otherRadioButton);
        listOfFields.add(agreeToTerms);
    }
//-------------------------Key/Event-Action----------------------------------
    @Override
	public void keyTyped(KeyEvent event){}
	@Override
	public void keyPressed(KeyEvent event){
		if (event.getKeyChar() == KeyEvent.VK_ESCAPE){System.exit(1);}
		else if (event.getKeyChar() == KeyEvent.VK_BACK_SPACE){cardLayout.show(cardPanel, "mainPanel");}
	}
	@Override
	public void keyReleased(KeyEvent event){}
    @Override
    public void actionPerformed(ActionEvent event){
        // Submit Button
		if (event.getSource() == submitButton){
            try{
                if (agreeToTerms.isSelected() && Utility.completedAllTasks(listOfFields)){
                    String password = "";
                    int newCustID = Utility.getCustID();
                    while (password.equals("")){
                        password = Utility.askForPassword();
                        if (password == null) throw new Exception();
                    }
                    String data = "\n" + newCustID + "_" + password + "_" + Utility.getDetails(listOfFields) + 0.0;
                    Utility.storeData(data, CUSTOMER_FILE_PATH);
                    Utility.createMessageDialog("Account Has Been Created", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                    Utility.createMessageDialog("Your Customer ID Is : " + newCustID, "ATTENTION", JOptionPane.INFORMATION_MESSAGE);
                    Utility.resetFields(listOfFields);
                    cardLayout.show(cardPanel, "mainPanel");
                }
                else if (!agreeToTerms.isSelected()){Utility.createMessageDialog("Kindly Agree To The Terms & Conditions First!", "Error Found", JOptionPane.ERROR_MESSAGE);}
                else{Utility.createMessageDialog("Kindly Fill All Fields First!", "Error Found", JOptionPane.ERROR_MESSAGE);}
            }
            catch(Exception e){}
        }
        // Reset Button
		else if (event.getSource() == resetButton){
            genderGroup.clearSelection();
            Utility.resetFields(listOfFields);
        }
        // Main Menu Button
		else if (event.getSource() == mainMenuButton){
            cardLayout.show(cardPanel, "mainPanel");
        }
//-------------------------Key/Event-Action----------------------------------
    }
}