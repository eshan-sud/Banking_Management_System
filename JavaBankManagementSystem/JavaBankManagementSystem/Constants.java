package JavaBankManagementSystem;

import java.awt.*;
import java.io.File;
import java.nio.file.Paths;

interface Constants{
//-------------------------Constants-----------------------------------------
    // Application Constants
	static final Dimension FRAME_SIZE = new Dimension(600, 500);
	static final Dimension BUTTON_SIZE = new Dimension(100, 50);
	static final Dimension COMPONENT_SIZE = new Dimension(100, 20);
	static final Dimension BIG_COMPONENT_SIZE = new Dimension(200, 20);
	static final Font COMPONENT_FONT = new Font("Consolas", Font.PLAIN, 15);
	static final Font BOLD_COMPONENT_FONT = new Font("Consolas", Font.BOLD, 20);
	static final Color COMPONENT_TEXT_COLOR = Color.BLACK;
	// File Path Constants
	static final String ADMIN_FILE_PATH = "" + Paths.get(System.getProperty("user.dir"), "Data" + File.separator + "admin_data.txt").toAbsolutePath();
	static final String CUSTOMER_FILE_PATH = "" + Paths.get(System.getProperty("user.dir"), "Data" + File.separator + "customer_data.txt").toAbsolutePath();
	static final String TEMP_FILE_PATH = "" + Paths.get(System.getProperty("user.dir"), "Data" + File.separator + "temp_file.txt").toAbsolutePath();
	// Date of Birth Constants
	static final String dates[] = {
		"1", "2", "3", "4", "5",
		"6", "7", "8", "9", "10",
		"11", "12", "13", "14", "15",
		"16", "17", "18", "19", "20",
		"21", "22", "23", "24", "25",
		"26", "27", "28", "29", "30",
		"31" };
	static final String months[] = {
		"Jan", "Feb", "Mar", "Apr",
		"May", "Jun", "Jul", "Aug",
		"Sep", "Oct", "Nov", "Dec"
	};
	static final String years[] = {
		"1987", "1989", "1990", "1991",
		"1992", "1993", "1994", "1995",
		"1996", "1997", "1998", "1999",
		"2000", "2001", "2002", "2003",
		"2004", "2005", "2006", "2007",
		"2008", "2009", "2010", "2011",
		"2012", "2013", "2014", "2015",
		"2016", "2017", "2018", "2019",
		"2020", "2021", "2022", "2023"
	};
	static final Object[] emptySelctionValues = null;
	final class WithdrawlAmountException extends Exception{}
//-------------------------Constants-----------------------------------------
}