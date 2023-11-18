package JavaBankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminAccount extends JPanel implements Constants, ActionListener, KeyListener{
    // Admin Account Options
	private String
	adminAccountPassword,
	adminAccountID;
	static JButton
	viewAccountHolderDetails,
	changeAccountHolderDetails,
	changeAdminPasswordButton,
	logoutButton;

	private CardLayout cardLayout;
	private Container cardPanel;

	public AdminAccount(String adminAccountID, String adminAccountPassword, CardLayout cardLayout, Container cardPanel){
		this.cardLayout = cardLayout;
		this.cardPanel = cardPanel;
		this.adminAccountID = adminAccountID;
		this.adminAccountPassword = adminAccountPassword;
		this.setFocusable(false);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(FRAME_SIZE);
		this.addKeyListener(this);

		viewAccountHolderDetails = Utility.createButton("View Account Holder Details", this);
		changeAccountHolderDetails = Utility.createButton("Change Account Holder Details", this);
		changeAdminPasswordButton = Utility.createButton("Change Password", this);
		logoutButton = Utility.createButton("Logout", this);

		// Adding Coponents To The Admin Account Panel
		this.add(Utility.createRigidSpaceBox(0, 10));
        this.add(Utility.createGrandLabel("Admin Account Options"));
        this.add(Utility.createRigidSpaceBox(0, 20));
		this.add(viewAccountHolderDetails);
        this.add(Utility.createRigidSpaceBox(0, 10));
		this.add(changeAccountHolderDetails);
        this.add(Utility.createRigidSpaceBox(0, 10));
		this.add(changeAdminPasswordButton);
        this.add(Utility.createRigidSpaceBox(0, 50));
		this.add(logoutButton);
	}
//-------------------------Key/Event-Action----------------------------------
	@Override
	public void keyTyped(KeyEvent event){}
	@Override
	public void keyPressed(KeyEvent event){
		if (event.getKeyChar() == KeyEvent.VK_ESCAPE){System.exit(1);}
	}
	@Override
	public void keyReleased(KeyEvent event){}
	@Override
	public void actionPerformed(ActionEvent event){
		// View Account Holder Details
		if (event.getSource() == viewAccountHolderDetails){
			try{
				String customerAccountID = Utility.createInputDialog("Enter Customer Account Number : ", "Viewing Details");
				if (customerAccountID == null) throw new Exception();
				String oldData = Utility.getData(customerAccountID, CUSTOMER_FILE_PATH), accountDataGender;
				if (oldData == null){
					Utility.createMessageDialog("Account Not Found!", "Account Search Error", JOptionPane.ERROR_MESSAGE);
					throw new Exception();
				}
				String[] accountData = oldData.split("_");
				if (accountData[9].equals("true")) accountDataGender = "Male";
				else if (accountData[10].equals("true")) accountDataGender = "Female";
				else accountDataGender = "Other";
				Utility.createMessageDialog("Customer ID : " + accountData[0] + "\nAccount Holder Name : " + accountData[2] + "\nAccount Holder Address : " + accountData[3] + "\nAccount Holder Phone Number : " + accountData[4] + "\nAccount Holder Email Address : " + accountData[5] + "\nAccount Holder DOB : " + accountData[6] + "-" + accountData[7] + "-" + accountData[8] + "\nAccount Holder Gender : " + accountDataGender + "\nAccount Balance : " + accountData[13], "Account Data", JOptionPane.INFORMATION_MESSAGE);
			}
			catch(Exception e){}
		}
		// Change Account Holder Details
		else if (event.getSource() == changeAccountHolderDetails){
			try{
				String customerAccountID = Utility.createInputDialog("Enter Customer Account Number : ", "Updating Details Menu");
				if (customerAccountID == null) throw new Exception();
				String oldData = Utility.getData(customerAccountID, CUSTOMER_FILE_PATH);
				if (oldData == null){
					Utility.createMessageDialog("Account Not Found!", "Account Search Error", JOptionPane.ERROR_MESSAGE);
					throw new Exception();
				}
				String selectedDetail = Utility.createInputDialog("Choose Detail To Be Changed", "Updating Details Menu", new Object[]{"Name", "Address", "Phone Number", "Email Address", "Date Of Birth", "Gender"});
				if (selectedDetail == null) throw new Exception();
				String newDetail = Utility.createInputDialog("Enter New Detail : ", "Updating Details Menu", emptySelctionValues);
				Utility.changeCustomerDetail(customerAccountID, selectedDetail, oldData, newDetail);
				Utility.createMessageDialog("Detail Has Been Updated", "Updation Success", JOptionPane.INFORMATION_MESSAGE);
			}
			catch(Exception e){}
		}
		// Change Password Button
		else if (event.getSource() == changeAdminPasswordButton){
			try{
				String
				oldData = adminAccountID + "_" + adminAccountPassword,
				newAdminAccountPassword = Utility.askForPassword();
				if (newAdminAccountPassword == null) throw new Exception();
            	String newData = adminAccountID + "_" + newAdminAccountPassword;
            	Utility.replaceData(oldData, newData, ADMIN_FILE_PATH);
            	Utility.createMessageDialog("Account Password Has Been Changed", "ATTENTION", JOptionPane.INFORMATION_MESSAGE);
            	Utility.createMessageDialog("You Will Now Be Logged Out", "ATTENTION", JOptionPane.INFORMATION_MESSAGE);
            	cardLayout.show(cardPanel, "mainPanel");
			}
			catch(Exception e){}
        }
		// Logout Button
		else if (event.getSource() == logoutButton){cardLayout.show(cardPanel, "mainPanel");}
//-------------------------Key/Event-Action----------------------------------
	}
}