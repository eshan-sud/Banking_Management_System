package JavaBankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BankFrame extends JFrame implements Constants, ActionListener, KeyListener{
    // Main Panel
	private JButton
	mainOpenNewCustomerButton,
	mainCustomerLoginButton,
	mainAdminLoginButton,
	customerAccountLoginButton = Utility.createLoginButton(this),
	customerAccountLoginResetButton = Utility.createResetButton(this),
	customerAccountLoginGoBackButton = Utility.createMainMenuButton(this),
	adminAccountLoginButton = Utility.createLoginButton(this),
	adminAccountLoginResetButton = Utility.createResetButton(this),
	adminAccountLoginGoBackButton = Utility.createMainMenuButton(this),
	quitButton = Utility.createButton("Quit", this);
	private JMenuItem
	About_The_Application,
	About_The_Author,
	JMenuItemExit;
	private JPanel
	mainPanel,
	customerLoginPanel,
	adminAccountLoginPanel;
	private JTextField
	customerAccountIDField,
	adminAccountIDField;
	private JPasswordField
	customerAccountPasswordField,
	adminAccountPasswordField;
	private CardLayout cardLayout;
	private Container cardPanel;
	private ArrayList<Component> listOfFields;
//-------------------------Frame---------------------------------------------
    public BankFrame(){
	// Frame Settings
		this.setTitle("Java Bank Management System - Eshan Sud");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(FRAME_SIZE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.addKeyListener(this);
		// File Menu
		JMenu File = new JMenu("File");
		File.setMnemonic('F');
		About_The_Application = new JMenuItem("About The Game");
		About_The_Application.setMnemonic('a');
		About_The_Application.addActionListener(this);
		About_The_Author = new JMenuItem("About The Author");
		About_The_Author.setMnemonic('a');
		About_The_Author.addActionListener(this);
		File.add(About_The_Application);
		File.add(About_The_Author);
		// Exit Menu
		JMenu JMenuExit = new JMenu("Exit");
		JMenuExit.setMnemonic('e');
		JMenuItemExit = new JMenuItem("exit");
		JMenuItemExit.setMnemonic('e');
		JMenuItemExit.addActionListener(this);
		JMenuExit.add(JMenuItemExit);
		// Menu Bar
		JMenuBar GameMenuBar = new JMenuBar();
		GameMenuBar.add(File);
		GameMenuBar.add(JMenuExit);
		// Adding The Game Menu Bar
		this.setJMenuBar(GameMenuBar);
//-------------------------Main-Panel----------------------------------------
		// Main Panel Settings
		mainPanel = new JPanel();
		mainPanel.setSize(FRAME_SIZE);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		// Creating Components & Adding Them To The Main Panel
		mainOpenNewCustomerButton = Utility.createButton("Open New Customer Account", this);
		mainCustomerLoginButton = Utility.createButton("Current Customer Account", this);
		mainAdminLoginButton = Utility.createButton("Admin Account", this);
		mainPanel.add(Utility.createRigidSpaceBox(0, 30));
		mainPanel.add(Utility.createGrandLabel("Java Bank Management System"));
		mainPanel.add(Utility.createRigidSpaceBox(0, 40));
		mainPanel.add(mainOpenNewCustomerButton);
		mainPanel.add(Utility.createRigidSpaceBox(0, 40));
		mainPanel.add(mainCustomerLoginButton);
		mainPanel.add(Utility.createRigidSpaceBox(0, 40));
		mainPanel.add(mainAdminLoginButton);
		mainPanel.add(Utility.createRigidSpaceBox(0, 40));
		mainPanel.add(quitButton);
		mainPanel.add(Utility.createRigidSpaceBox(0, 40));
//-------------------------Main-Panel----------------------------------------
//-------------------------Customer-Login-Panel------------------------------
		// Creating Customer Login Panel
		customerLoginPanel = new JPanel();
		customerLoginPanel.setPreferredSize(FRAME_SIZE);
		customerLoginPanel.setLayout(null);
		customerLoginPanel.setFocusable(false);
		// Creating Components
		JLabel customerAccountLoginHeadingLabel = Utility.createGrandLabel("Customer Login:-", 30, 40);
		JLabel customerAccountIDLabel = Utility.createLabel("Customer ID:", 50, 150);
		customerAccountIDLabel.setSize(BIG_COMPONENT_SIZE);
		customerAccountIDField = Utility.createTextField(200, 150);
		customerAccountIDField.setSize(BIG_COMPONENT_SIZE);
		JLabel customerAccountPasswordLabel = Utility.createLabel("Password:", 50, 200);
		customerAccountPasswordLabel.setSize(BIG_COMPONENT_SIZE);
		customerAccountPasswordField = Utility.createPasswordField(200, 200);
		customerAccountPasswordField.setSize(BIG_COMPONENT_SIZE);
		// Adding Components To The Customer Login Panel
		customerLoginPanel.add(customerAccountLoginHeadingLabel);
		customerLoginPanel.add(customerAccountIDLabel);
		customerLoginPanel.add(customerAccountIDField);
		customerLoginPanel.add(customerAccountPasswordLabel);
		customerLoginPanel.add(customerAccountPasswordField);
		customerLoginPanel.add(customerAccountLoginButton);
		customerLoginPanel.add(customerAccountLoginResetButton);
		customerLoginPanel.add(customerAccountLoginGoBackButton);
//-------------------------Customer-Login-Panel------------------------------
//-------------------------Admin-Login-Panel---------------------------------
		// Creating Admin Login Panel
		adminAccountLoginPanel = new JPanel();
		adminAccountLoginPanel.setPreferredSize(FRAME_SIZE);
		adminAccountLoginPanel.setLayout(null);
		adminAccountLoginPanel.setFocusable(false);
		// Creating Components
		JLabel admingAccountLoginHeadingLabel = Utility.createGrandLabel("Admin Login:-", 30, 40);
		JLabel adminAccountIDLabel = Utility.createLabel("Admin ID:", 50, 150);
		adminAccountIDLabel.setSize(BIG_COMPONENT_SIZE);
		adminAccountIDField = Utility.createTextField(200, 150);
		adminAccountIDField.setSize(BIG_COMPONENT_SIZE);
		JLabel adminAccountPasswordLabel = Utility.createLabel("Password:", 50, 200);
		adminAccountPasswordLabel.setSize(BIG_COMPONENT_SIZE);
		adminAccountPasswordField = Utility.createPasswordField(200, 200);
		adminAccountPasswordField.setSize(BIG_COMPONENT_SIZE);
		// Adding Components To The Admin Login Panel
		adminAccountLoginPanel.add(admingAccountLoginHeadingLabel);
		adminAccountLoginPanel.add(adminAccountIDLabel);
		adminAccountLoginPanel.add(adminAccountIDField);
		adminAccountLoginPanel.add(adminAccountPasswordLabel);
		adminAccountLoginPanel.add(adminAccountPasswordField);
		adminAccountLoginPanel.add(adminAccountLoginButton);
		adminAccountLoginPanel.add(adminAccountLoginResetButton);
		adminAccountLoginPanel.add(adminAccountLoginGoBackButton);
//-------------------------Admin-Login-Panel---------------------------------
		// Creating Card Layout
		cardPanel = new Container();
		cardLayout = new CardLayout();
		cardPanel.setLayout(cardLayout);
		cardPanel.add(mainPanel, "mainPanel");
        cardPanel.add(customerLoginPanel, "customerLoginPanel");
		cardPanel.add(adminAccountLoginPanel, "adminAccountLoginPanel");
		// Addming The Card Layout
        this.add(cardPanel, BorderLayout.CENTER);
		this.setVisible(true);
		// Adding Components To The ListOfFields
		listOfFields = new ArrayList<>();
		listOfFields.add(adminAccountIDField);
		listOfFields.add(adminAccountPasswordField);
		listOfFields.add(customerAccountIDField);
		listOfFields.add(customerAccountPasswordField);
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
		// Main Account Options
		// Main Panel Open New Customer Account Button
		if (event.getSource() == mainOpenNewCustomerButton){
			cardPanel.add(new NewCustomerAccount(cardLayout, cardPanel),"newCustomerOptionsPanel");
			cardLayout.show(cardPanel, "newCustomerOptionsPanel");
		}
		// Main Panel Customer Accout Login Button
		else if (event.getSource() == mainCustomerLoginButton){cardLayout.show(cardPanel, "customerLoginPanel");}
		// Customer Account Login Check
		else if (event.getSource() == customerAccountLoginButton){
			// Getting The Credentials
			String customerAccountID = customerAccountIDField.getText();
			String customerAccountPassword = new String(customerAccountPasswordField.getPassword());
			// Checking The Credentials
			if (Utility.checkCredentials(customerAccountID, customerAccountPassword, CUSTOMER_FILE_PATH)){
				customerAccountIDField.setText("");
				customerAccountPasswordField.setText("");
				cardPanel.add(new CustomerAccount(customerAccountID, cardLayout, cardPanel), "customerOptionsPanel");
				cardLayout.show(cardPanel, "customerOptionsPanel");
			}
			else{
				Utility.createMessageDialog("Customer Login Failed!", "Error Logging In", JOptionPane.ERROR_MESSAGE);
			}
		}
		// Main Panel Admin Login Button
		else if (event.getSource() == mainAdminLoginButton){cardLayout.show(cardPanel, "adminAccountLoginPanel");}
		// Admin Account Login Reset Buttin
		else if (event.getSource() == customerAccountLoginResetButton || event.getSource() == adminAccountLoginResetButton){
			Utility.resetFields(listOfFields);
		}
		// Admin Account Login Check
		else if (event.getSource() == adminAccountLoginButton){
			// Getting The Credentials
			String adminAccountNumber = adminAccountIDField.getText();
			String adminAccountPassword = new String(adminAccountPasswordField.getPassword());
			// Checking The Credentials
			if (Utility.checkCredentials(adminAccountNumber, adminAccountPassword, ADMIN_FILE_PATH)){
				adminAccountIDField.setText("");
				adminAccountPasswordField.setText("");
				cardPanel.add(new AdminAccount(adminAccountNumber, adminAccountPassword, cardLayout, cardPanel), "adminOptionsPanel");
				cardLayout.show(cardPanel, "adminOptionsPanel");
			}
			else{
				Utility.createMessageDialog("Admin Login Failed!", "Error Logging In", JOptionPane.ERROR_MESSAGE);
			}
		}
		// Go Back Button
		else if (event.getSource() == customerAccountLoginGoBackButton || event.getSource() == adminAccountLoginGoBackButton){cardLayout.show(cardPanel, "mainPanel");}
		// Quit Options
		else if (event.getSource() == quitButton || event.getSource() == JMenuItemExit){System.exit(1);}
		// JMenuBar Options
		else if (event.getSource() == About_The_Application){
			Utility.createMessageDialog("This is a Banking Management System which includes functions of both the customer and the admin", "About The Application", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (event.getSource() == About_The_Author){
			Utility.createMessageDialog(
				"This has been created by Eshan Sud\nContact Me :\nLinkedIn : \"https://www.linkedin.com/in/eshan-sud/\" \nE-Mail     : \"eshansud22@gmail.com\"",
				"About The Author",
				JOptionPane.INFORMATION_MESSAGE
			);
		}
//-------------------------Key/Event-Action----------------------------------
	}
//-------------------------Frame---------------------------------------------
}