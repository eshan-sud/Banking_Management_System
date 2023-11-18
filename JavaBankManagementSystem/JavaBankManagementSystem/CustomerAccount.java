package JavaBankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomerAccount extends JPanel implements Constants, ActionListener, KeyListener{
    private String newData = "", customerAccountID;
    private JButton viewAccountHolderDetails, withdrawButton, depositButton, changeCustomerPasswordButton,logoutButton;
    private CardLayout cardLayout;
    private Container cardPanel;
	public CustomerAccount(String customerAccountID, CardLayout cardLayout, Container cardPanel){
        // Panel Settings
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
        this.customerAccountID = customerAccountID;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(FRAME_SIZE);
        this.addKeyListener(this);
        // Creating Components
        viewAccountHolderDetails = Utility.createButton("View Account Details", this);
        withdrawButton = Utility.createButton("Withdraw", this);
        depositButton = Utility.createButton("Deposit", this);
        changeCustomerPasswordButton = Utility.createButton("Change Password", this);
        logoutButton = Utility.createButton("Logout", this);
        // Adding Components To The Customer Account Panel
        this.add(Utility.createRigidSpaceBox(0, 10));
        this.add(Utility.createGrandLabel("Customer Account Options"));
        this.add(Utility.createRigidSpaceBox(0, 20));
        this.add(viewAccountHolderDetails);
        this.add(Utility.createRigidSpaceBox(0, 10));
        this.add(withdrawButton);
        this.add(Utility.createRigidSpaceBox(0, 10));
        this.add(depositButton);
        this.add(Utility.createRigidSpaceBox(0, 10));
        this.add(changeCustomerPasswordButton);
        this.add(Utility.createRigidSpaceBox(0, 50));
        this.add(logoutButton);
    }
//-------------------------Key/Event-Action----------------------------------
    @Override
    public void keyTyped(KeyEvent e){}
    @Override
    public void keyPressed(KeyEvent e){
        if (e.getKeyChar() == KeyEvent.VK_ESCAPE){System.exit(1);}
        else if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE){cardLayout.show(cardPanel, "mainPanel");}
    }
    @Override
    public void keyReleased(KeyEvent event){}
	@Override
	public void actionPerformed(ActionEvent event){
        // View Account Holder Details Button
        if (event.getSource() == viewAccountHolderDetails){
            String oldData = Utility.getData(customerAccountID, CUSTOMER_FILE_PATH), accountDataGender;
            String[] accountData = oldData.split("_");
            if (accountData[9].equals("true")) accountDataGender = "Male";
            else if (accountData[10].equals("true")) accountDataGender = "Female";
            else accountDataGender = "Other";
            Utility.createMessageDialog("Customer ID : " + accountData[0] + "\nAccount Holder Name : " + accountData[2] + "\nAccount Holder Address : " + accountData[3] + "\nAccount Holder Phone Number : " + accountData[4] + "\nAccount Holder Email Address : " + accountData[5] + "\nAccount Holder DOB : " + accountData[6] + "-" + accountData[7] + "-" + accountData[8] + "\nAccount Holder Gender : " + accountDataGender + "\nAccount Balance : " + accountData[13], "Account Data", JOptionPane.INFORMATION_MESSAGE);
        }
        // Withdraw Button
        else if (event.getSource() == withdrawButton){
            String oldData = Utility.getData(customerAccountID, CUSTOMER_FILE_PATH);
            String[] accountData = oldData.split("_");
            float withdrawlAmount = 0;
            boolean flag = true;
            newData = "";
            while(flag){
                try{
                    float accountBalance = Float.parseFloat(accountData[13]);
                    String userInput = Utility.createInputDialog("Enter Withdrawl Amount:", "Withdrawl Menu");
                    if (userInput.equals("-1")) throw new Exception();
                    withdrawlAmount = Float.parseFloat(userInput);
                    flag = false;
                    if (withdrawlAmount < 0) withdrawlAmount = -1*withdrawlAmount;
                    if (withdrawlAmount > accountBalance){new WithdrawlAmountException();}
                    else{
                        accountBalance = accountBalance - withdrawlAmount;
                        accountData[13] = "" + accountBalance;
                        for(int i=0; i<accountData.length; i++){
                            if (i==0) newData += accountData[i];
                            else newData += "_" + accountData[i];
                        }
                        Utility.replaceData(oldData, newData, CUSTOMER_FILE_PATH);
                        Utility.createMessageDialog("Amount : Rs. "+ withdrawlAmount + "\nHas Been Withdrawn", "Withdrawl Success", JOptionPane.INFORMATION_MESSAGE);
                        Utility.createMessageDialog("New Account Balance : Rs." + accountBalance, "Account Balance", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                catch(NumberFormatException e1){Utility.createMessageDialog("Kindly Only Put Numeric values!", "Withrawl Error", JOptionPane.ERROR_MESSAGE);}
                catch(WithdrawlAmountException e1){Utility.createMessageDialog("Withdrawl Amount Cannot Be Greater Than Account Balance!", "Withdrawl Error", JOptionPane.ERROR_MESSAGE);}
                catch(Exception e1){flag = false;}
            }
        }
        // Deposit Button
        else if (event.getSource() == depositButton){
            String oldData = Utility.getData(customerAccountID, CUSTOMER_FILE_PATH);
            String[] accountData = oldData.split("_");
            float depositAmount = 0;
            boolean flag = true;
            newData = "";
            while(flag){
                try{
                    float accountBalance = Float.parseFloat(accountData[13]);
                    String userInput = Utility.createInputDialog("Enter Deposit Amount:", "Deposit Menu");
                    if (userInput.equals("-1")) throw new Exception();
                    depositAmount = Float.parseFloat(userInput);
                    if (depositAmount < 0) depositAmount *= -1;
                    flag = false;
                    accountBalance = accountBalance + depositAmount;
                    accountData[13] = "" + accountBalance;
                    for(int i=0; i<accountData.length; i++){
                        if (i==0) newData += accountData[i];
                        else newData += "_" + accountData[i];
                    }
                    Utility.replaceData(oldData, newData, CUSTOMER_FILE_PATH);
                    Utility.createMessageDialog("Amount : Rs. "+ depositAmount + "\nHas Been Deposited", "Deposit Success", JOptionPane.INFORMATION_MESSAGE);
                    Utility.createMessageDialog("New Account Balance : Rs." + accountBalance, "Account Balance", JOptionPane.INFORMATION_MESSAGE);
                }
                catch(NumberFormatException e2){
                    Utility.createMessageDialog("Kindly Only Put Numeric values!", "Deposit Error", JOptionPane.ERROR_MESSAGE);
                }
                catch(Exception e1){e1.printStackTrace();}
            }
        }
        // Change Password Button
        else if (event.getSource() == changeCustomerPasswordButton){
            try{
                String oldData = Utility.getData(customerAccountID, CUSTOMER_FILE_PATH);
                String[] accountData = oldData.split("_");
                newData = "";
                String newPassword = Utility.askForPassword();
                if (newPassword == null) throw new Exception();
                accountData[1] = newPassword;
                for(int i=0; i<accountData.length; i++){
                    if (i==0) newData += accountData[i];
                    else newData += "_" + accountData[i];
                }
                Utility.replaceData(oldData, newData, CUSTOMER_FILE_PATH);
                Utility.createMessageDialog("Account Password Has Been Changed", "ATTENTION", JOptionPane.INFORMATION_MESSAGE);
                Utility.createMessageDialog("You Will Now Be Logged Out", "ATTENTION", JOptionPane.INFORMATION_MESSAGE);
                cardLayout.show(cardPanel, "mainPanel");
            }
            catch(Exception e){}
        }
        // Logout Button
        else if (event.getSource() == logoutButton){cardLayout.show(cardPanel, "mainPanel");}
    }
//-------------------------Key/Event-Action----------------------------------
}