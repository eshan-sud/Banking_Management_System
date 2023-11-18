package JavaBankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class Utility implements Constants{
//-------------------------Creating-Components-------------------------------
	public static JButton createButton(String text, ActionListener object){
        /*
         * Creates A Button Object Having The Following Details:
         * Text             -   text
         * Font             -   COMPONENT_FONT
         * ForeGround       -   COMPONENT_TEXT_COLOR
         * Alignment        -   CENTER_ALIGNEMENT
         * Size             -   BUTTON_SIZE
         * ActionListener   -   Present
         * Focusable        -   false 
         * 
        */
        JButton button = new JButton(text);
        button.setFont(COMPONENT_FONT);
        button.setForeground(COMPONENT_TEXT_COLOR);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setAlignmentY(Component.CENTER_ALIGNMENT);
        button.setSize(BUTTON_SIZE);
        button.addActionListener(object);
        button.setFocusable(false);
        return button;
    }
    public static JButton createButton(String text, ActionListener object, int x, int y){
        /*
         * Creates A Button Object Having The Following Details:
         * Text             -   text
         * Font             -   COMPONENT_FONT
         * ForeGround       -   COMPONENT_TEXT_COLOR
         * Size             -   COMPONENET_SIZE
         * Location         -   (locx, locy)
         * ActionListener   -   Present
         * Focusable        -   false 
         * 
        */
        JButton button = new JButton(text);
        button.setFont(COMPONENT_FONT);
        button.setForeground(COMPONENT_TEXT_COLOR);
        button.setSize(COMPONENT_SIZE);
        button.setLocation(x, y);
        button.addActionListener(object);
        button.setFocusable(false);
        return button;
    }
    public static JButton createLoginButton(ActionListener frame){
        /*
         * Creates A Login Button Object Having The Following Details:
         * Text             -   "Login"
         * Font             -   COMPONENT_FONT
         * ForeGround       -   COMPONENT_TEXT_COLOR
         * Size             -   BUTTON_SIZE
         * Location         -   (locx, locy)
         * ActionListener   -   Present
         * Focusable        -   false
         * 
        */
        return createButton("Login", frame, 150, 380);
    }
    public static JButton createResetButton(ActionListener frame){
        /*
         * Creates A Reset Button Object Having The Following Details:
         * Text             -   "Reset"
         * Font             -   COMPONENT_FONT
         * ForeGround       -   COMPONENT_TEXT_COLOR
         * Size             -   BUTTON_SIZE
         * Location         -   (locx, locy)
         * ActionListener   -   Present
         * Focusable        -   false
         * 
        */
        return createButton("Reset", frame, 250, 380);
    }
    public static JButton createMainMenuButton(ActionListener frame){
        /*
         * Creates A Main Menu Button Object Having The Following Details:
         * Text             -   "Go Back"
         * Font             -   FRAME_FONT
         * ForeGround       -   COMPONENT_TEXT_COLOR
         * Size             -   BUTTON_SIZE
         * Location         -   (locx, locy)
         * ActionListener   -   Present
         * Focusable        -   false
         * 
        */
        return createButton("Go Back", frame, 350, 380);
    }
    public static JCheckBox createCheckBox(String text, int locx, int locy){
        /*
         * Creates A Check Box Object Having The Following Details:
         * Text             -   text
         * Font             -   COMPONENT_FONT
         * ForeGround       -   COMPONENT_TEXT_COLOR
         * Size             -   (250, 20)
         * Location         -   (locx, locy)
         * Focusable        -   false
         * 
        */
        JCheckBox cBox = new JCheckBox(text);
        cBox.setFont(COMPONENT_FONT);
        cBox.setForeground(COMPONENT_TEXT_COLOR);
        cBox.setSize(250, 20);
        cBox.setLocation(locx, locy);
        cBox.setFocusable(false);
        return cBox;
    }
    public static JTextField createTextField(){
        /*
         * Creates A Text Box Object Having The Following Details:
         * Font             -   COMPONENT_FONT
         * ForeGround       -   COMPONENT_TEXT_COLOR
         * Size             -   (240, 20)
         * Focusable        -   true
         * 
        */
        JTextField text = new JTextField();
        text.setFont(COMPONENT_FONT);
        text.setForeground(COMPONENT_TEXT_COLOR);
        text.setSize(240, 20);
        return text;
    }
    public static JTextField createTextField(int locx, int locy){
        /*
         * Creates A Text Box Object Having The Following Details:
         * Font             -   COMPONENT_FONT
         * ForeGround       -   COMPONENT_TEXT_COLOR
         * Size             -   COMPONENT_SIZE
         * Location         -   (locx, locy)
         * Focusable        -   true
         * 
        */
        JTextField textField = createTextField();
        textField.setLocation(locx, locy);
        return textField;
    }
    public static JPasswordField createPasswordField(int locx, int locy){
        /*
         * Creates A Password Field Object Having The Following Details:
         * Font             -   COMPONENT_FONT
         * ForeGround       -   COMPONENT_TEXT_COLOR
         * Size             -   COMPONENT_SIZE
         * Location         -   (locx, locy)
         * Focusable        -   true
         * 
        */
        JPasswordField password = new JPasswordField();
        password.setFont(COMPONENT_FONT);
        password.setForeground(COMPONENT_TEXT_COLOR);
        password.setSize(COMPONENT_SIZE);
        password.setLocation(locx, locy);
        return password;
    }
    public static JRadioButton createRadioButton(String text, int locx, int locy){
        /*
         * Creates A Radio Button Object Having The Following Details:
         * Font             -   COMPONENT_FONT
         * ForeGround       -   COMPONENT_TEXT_COLOR
         * Size             -   (80, 20)
         * Location         -   (locx, locy)
         * Focusable        -   false
         * 
        */
        JRadioButton rButton = new JRadioButton(text);
        rButton.setFont(COMPONENT_FONT);
        rButton.setForeground(COMPONENT_TEXT_COLOR);
        rButton.setSelected(false);
        rButton.setSize(80, 20);
        rButton.setLocation(locx, locy);
        rButton.setFocusable(false);
        return rButton;
    }
    public static JComboBox <String> createComboBox(String[] text, int locx, int locy){
        /*
         * Creates A Combo Box Object Having The Following Details:
         * Font             -   COMPONENT_FONT
         * ForeGround       -   COMPONENT_TEXT_COLOR
         * Size             -   (80, 20)
         * Location         -   (locx, locy)
         * Selected Index   -    -1
         * Focusable        -   false
         * 
        */
        JComboBox<String> cBox = new JComboBox<>(text);
        cBox.setFont(COMPONENT_FONT);
        cBox.setForeground(COMPONENT_TEXT_COLOR);
        cBox.setSize(80, 20);
        cBox.setLocation(locx, locy);
        cBox.setSelectedIndex(-1);
        cBox.setFocusable(false);
        return cBox;
    }
    public static JLabel createLabel(String text){
        /*
         * Creates A Label Object Having The Following Details:
         * Text             -   text
         * Font             -   COMPONENT_FONT
         * Size             -   (80, 20)
         * Alignment        -   CENTER_ALIGNMENT
         * Focusable        -   false
         * 
        */
        JLabel label = new JLabel(text);
        label.setFont(COMPONENT_FONT);
        label.setSize(80, 20);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setAlignmentY(Component.CENTER_ALIGNMENT);
        label.setFocusable(false);
        return label;
    }
    public static JLabel createLabel(String text, int locx, int locy){
        /*
         * Creates A Label Object Having The Following Details:
         * Text             -   text
         * Font             -   COMPONENT_FONT
         * Size             -   (80, 20)
         * Location         -   (locx, locy)
         * Focusable        -   false
         * 
        */
        JLabel label = new JLabel(text);
        label.setFont(COMPONENT_FONT);
        label.setSize(COMPONENT_SIZE);
        label.setLocation(locx, locy);
        label.setFocusable(false);
        return label;
    }
    public static JLabel createGrandLabel(String text){
        /*
         * Creates A Grand Label Object Having The Following Details:
         * Text             -   text
         * Font             -   BOLD_COMPONENT_FONT
         * Size             -   (300, 20)
         * Focusable        -   false
         * 
        */
        JLabel label = createLabel(text);
        label.setFont(BOLD_COMPONENT_FONT);
        label.setSize(300, 20);
        label.setFocusable(false);
        return label;
    }
    public static JLabel createGrandLabel(String text, int locx, int locy){
        /*
         * Creates A Grand Label Object Having The Following Details:
         * Text             -   text
         * Font             -   BOLD_COMPONENT_FONT
         * Size             -   (300, 20)
         * Location         -   (locx, locy)
         * Focusable        -   false
         * 
        */
        JLabel label = createLabel(text, locx, locy);
        label.setFont(BOLD_COMPONENT_FONT);
        label.setSize(300, 20);
        return label;
    }
    public static String createInputDialog(String message, String title){
        /*
         * Creates A Input Dialog Popup For The User To Put Data In Having The Following Details:
         * message          -   message
         * title            -   title
         * icon             -   null
         * 
         */
        return (String) JOptionPane.showInputDialog(
			null,
            message,
            title,
            JOptionPane.DEFAULT_OPTION,
            null,
            null,
            null
		);
    }
    public static String createInputDialog(String message, String title, Object[] selectionValues){
        /*
         * Creates A Input Dialog Popup For The User To Put Data In Having The Following Details:
         * message          -   message
         * title            -   title
         * icon             -   null
         * selectionValues  -   selectionValues
         * 
         */
        return (String) JOptionPane.showInputDialog(
			null,
            message,
            title,
            JOptionPane.DEFAULT_OPTION,
            null,
            selectionValues,
            null
		);
    }
    public static void createMessageDialog(String message, String title, int type){
        /*
         * Creates A Messgae Dialog Popup Object Having The Following Details:
         * Message                  -   message
         * Title                    -   title
         * Type                     -   type
         * Focusable                -   false
         * Default Close Operation  -   DISPOSE_ON_CLOSE
         * Visible                  -   true
         * 
        */
        JOptionPane pane = new JOptionPane(
            message,
            type,
            JOptionPane.DEFAULT_OPTION,
            null,
            new Object[]{},
            null
        );
        JDialog dialog = pane.createDialog(title); 
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setFocusable(false);
        dialog.setVisible(true);
    }
    public static Component createRigidSpaceBox(int w, int h){
        /*
         * Creates A Rigid Space Object Having The Following Details:
         * Width    -   w
         * Height   -   h
         * 
        */
        return Box.createRigidArea(new Dimension(w, h));
    }
//-------------------------Creating-Objects----------------------------------
//-------------------------Ask-For-Password----------------------------------
    public static String askForPassword(){
        /*
         * Takes a new password and
         * confirmes it from the
         * user and returns it
         * 
        */
        String newPassword, confirmPassword;
        newPassword = JOptionPane.showInputDialog("Enter New Password:");
        if (newPassword == null) return null;
        else if (newPassword.equals("")) return "";
        else{
            confirmPassword = JOptionPane.showInputDialog("Retype New Password:");
            if (confirmPassword == null) return null;
            else if (confirmPassword.equals("")) return "";
            if (newPassword.equals(confirmPassword)) return newPassword;
            else return "";
        }
    }
//-------------------------Ask-For-Password----------------------------------
//-------------------------Getting/Setting-Details-In-Fields-----------------
    public static String getDetails(ArrayList<? extends Component> fields){
        /*
         * Gets details of the given fields
         * and returns them
         * 
         */
        String result = new String();
        for (Component field : fields){
            if (field instanceof JTextField) result += ((JTextField) field).getText();
            else if (field instanceof JTextArea) result += ((JTextArea) field).getText();
            else if (field instanceof JComboBox) result += ((JComboBox<?>) field).getSelectedItem();
            else if (field instanceof JRadioButton) result += ((JRadioButton) field).isSelected();
            result += "_";
        }
        return result;
    }
    public static void resetFields(ArrayList<? extends Component> fields){
        /*
         * Resets the given fields
         * 
         */
        for (Component field : fields){
            if (field instanceof JTextField)((JTextField) field).setText("");
            else if (field instanceof JTextArea) ((JTextArea) field).setText("");
            else if (field instanceof JComboBox) ((JComboBox<?>) field).setSelectedIndex(-1);
            else if (field instanceof JRadioButton) ((JRadioButton) field).setSelected(false);
            else if (field instanceof JCheckBox) ((JCheckBox) field).setSelected(false);
            else if (field instanceof JRadioButtonMenuItem) ((JRadioButtonMenuItem) field).setSelected(false);
        }
    }
    public static void changeCustomerDetail(String customerAccountID, String selectedDetail, String oldData, String newDetail){
        /*
         * Changes The Given Customer Detail In The CUSTOMER_FILE_PATH
         * 
         */
        String newData = "";
        String[] splitData = {};
        if (selectedDetail.equals("Date Of Birth")){
            if (newData.contains("-"))splitData = newDetail.split("-");
            else if (newData.contains("/"))splitData = newDetail.split("/");
            else if (newData.contains(" "))splitData = newDetail.split(" ");
        }
        String[] oldDetails = oldData.split("_");
        switch(selectedDetail){
            case "Name":
                oldDetails[2] = newDetail;
                break;
            case "Address":
                oldDetails[3] = newDetail;
                break;
            case "Phone Number":
                oldDetails[4] = newDetail;
                break;
            case "Email Address":
                oldDetails[5] = newDetail;
                break;
            case "Date Of Birth":
                oldDetails[6] = splitData[0];
                oldDetails[7] = splitData[1];
                oldDetails[8] = splitData[2];
                break;
            case "gender":
                switch(newDetail){
                    case "male":
                        oldDetails[9] = "true";
                        oldDetails[10] = "false";
                        oldDetails[11] = "false";
                        break;
                    case "Female":
                        oldDetails[9] = "false";
                        oldDetails[10] = "true";
                        oldDetails[11] = "false";
                        break;
                    case "Other":
                        oldDetails[9] = "false";
                        oldDetails[10] = "false";
                        oldDetails[11] = "true";
                        break;
                }
                break;
        }
        for(int i=0; i<oldDetails.length; i++){
            if (i==0) newData += oldDetails[i];
            else newData += "_" + oldDetails[i];
        }
        replaceData(oldData, newData, CUSTOMER_FILE_PATH);
    }
//-------------------------File-Handling-------------------------------------
    public static int getCustID(){
        /*
         * Gets a new customer ID
         * from the customer file 
         * and returns It
         * 
         */
        int newID = 0;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(CUSTOMER_FILE_PATH));
            String[] data = {};
			String line = reader.readLine();
			while ((line = reader.readLine()) != null) data = line.split("_");
            newID = Integer.parseInt(data[0]) + 1;
            reader.close();
            return newID;
		}
        catch (Exception e){}
        return newID;
    }
    public static void replaceData(String oldData, String newData, String filePath){
        /*
         * Replaces oldData with newData in the given filePath Using a temp file
         * 
         */
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(TEMP_FILE_PATH));
            String line;
            while ((line = reader.readLine()) != null){
                line = line.replace(oldData, newData);
                writer.write(line + System.lineSeparator());
            }
            reader.close();
            writer.close();
            reader = new BufferedReader(new FileReader(TEMP_FILE_PATH));
            writer = new BufferedWriter(new FileWriter(filePath));
            while ((line = reader.readLine()) != null) writer.write(line + System.lineSeparator());
            reader.close();
            writer.close();
            emptyFile(TEMP_FILE_PATH);
        }
        catch (Exception e){}
    }
    public static void emptyFile(String filePath){
        /*
         * Empties the given file
         * 
         */
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write("");
            writer.close();
        }
        catch (Exception e){}
    }
    public static void storeData(String data, String filePath){
        /*
         * Appends the given data to the given file
         * 
        */
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
            writer.write(data);
            writer.close();
        }
        catch (Exception e){}
    }
    public static String getData(String accountID, String filePath){
        /*
         * Get data from the given accountID and file
         * 
         */
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
			String line = reader.readLine();
			while ((line = reader.readLine()) != null){
				String[] data = line.split("_");
				if (data[0].equals(accountID)){
                    reader.close();
                    return line;
                }
			}
            reader.close();
		}
		catch (Exception e){}
		return null;
    }
//-------------------------File-Handling-------------------------------------
//-------------------------Completed-All-Tasks-------------------------------
    public static boolean completedAllTasks(ArrayList<? extends Component> fields){
        /*
         * Returns true/false if all the given fields have been flled
         * 
         */
        String result = "noValue";
        for (int i=0; i<fields.size()-3; i++){
            Component field = fields.get(i);
            result = "noValue";
            if (field instanceof JTextField) result = ((JTextField) field).getText();
            else if (field instanceof JComboBox) result = (String) ((JComboBox<?>) field).getSelectedItem();
            else if (field instanceof JRadioButton){
                boolean val1 = ((JRadioButton) fields.get(i)).isSelected();
                boolean val2 = ((JRadioButton) fields.get(i+1)).isSelected();
                boolean val3 = ((JRadioButton) fields.get(i+2)).isSelected();
                if (val1 || val2 || val3) result = "result";
            }
            if (result == null || result.equals("")){
                result = "noValue";
                break;
            }
        }
        if (result.equals("noValue")) return false;
        else return true;
    }
//-------------------------Completed-All-Tasks-------------------------------
//-------------------------Checking-Credentials------------------------------
    public static boolean checkCredentials(String accountID, String accountPassword, String filePath){
        /*
         * Checks credentials using the accountID and accountPassword in the given file
         * 
         */
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
			String line = reader.readLine();
			while ((line = reader.readLine()) != null){
				String[] data = line.split("_");
				if (data[0].equals(accountID) && data[1].equals(accountPassword)) return true;
			}
		}
		catch (Exception e){}
		return false;
	}
//-------------------------Checking-Credentials------------------------------
}