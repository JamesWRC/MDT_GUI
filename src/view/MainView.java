package view;

import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.ExitMenuListsener;
import controller.HelpMenuListener;
import controller.CountrySelectedListener;
import database.DatabaseHelper;

public class MainView {
	// GUI component objects
	private JFrame mainFrame;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem helpMenu, exitMenu;
	private DatabaseHelper dbh = new DatabaseHelper();
	@SuppressWarnings("rawtypes")
	private JComboBox countryCodeComboBox, countryNameComboBox, tempComboBox;
	private JLabel comboBoxOrLbl, selectByNameLbl, selectByCodeLbl;
	private JTextArea resultInfo;
	private JScrollPane scrollPane;



	// GUI component parameters
	private static final int FRAME_X = 100;
	private static final int FRAME_Y = 100;
	private static final int FRAME_WIDTH = 450;
	private static final int FRAME_HEIGHT = 700;

	/**
	 * Calls the necessary methods to construct the GUI
	 * @throws SQLException 
	 */
	public MainView() throws SQLException {
		frame();
		results();
		dropdown();
		toolBar();

	}

	/**
	 * Creates the main windows/frame of the GUI.
	 */
	public void frame() {
		mainFrame = new JFrame("Malaria Diagnosis Tool");

		// set window parameters
		mainFrame.setBounds(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		// Sets frame to middle of screen
		mainFrame.setLocationRelativeTo(null);
	}

	/**
	 * adds the toolbar component to the frame.
	 */
	public void toolBar() {
		menuBar = new JMenuBar();
		menu = new JMenu("Menu");
		helpMenu = new JMenuItem("Help");
		exitMenu = new JMenuItem("Exit");

		// add listeners to the menu options.
		helpMenu.addActionListener(new HelpMenuListener());
		exitMenu.addActionListener(new ExitMenuListsener());

		menu.add(helpMenu);
		menu.add(exitMenu);
		menuBar.add(menu);

		/*
		 * Known Bug: ToolBar won't show unless window resized.
		 * 
		 * Workaround: increase the width by one, this then however changes the location
		 * of the window, so we move its relative location to null
		 */
		// Begin workaround
		mainFrame.setJMenuBar(menuBar);
		mainFrame.setBounds(FRAME_X, FRAME_Y, FRAME_WIDTH + 1, FRAME_HEIGHT);
		mainFrame.setLocationRelativeTo(null);
		// end workaround
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void dropdown() throws SQLException {
		
		selectByCodeLbl = new JLabel("Country Code: ");
		selectByCodeLbl.setBounds(100, 50, 100, 15);
		
		countryCodeComboBox = new JComboBox( dbh.getAllCountryCodes(true).toArray());
		countryCodeComboBox.setBounds(185, 50, 100, 15);
		countryCodeComboBox.setToolTipText("Select country by code");
		countryCodeComboBox.addActionListener(new CountrySelectedListener(countryCodeComboBox, resultInfo, mainFrame));
		
		comboBoxOrLbl = new JLabel("------\t OR \t------");
		comboBoxOrLbl.setBounds(175, 75, 200, 20);
		
		selectByNameLbl = new JLabel("Country Name: ");
		selectByNameLbl.setBounds(10, 100, 275, 15);
		
		countryNameComboBox = new JComboBox( dbh.getAllCountryCodes(false).toArray());
		countryNameComboBox.setBounds(100, 100, 275, 15);
		countryNameComboBox.setToolTipText("Select country by name");
		countryNameComboBox.addActionListener(new CountrySelectedListener(countryNameComboBox, resultInfo, mainFrame));

		
		tempComboBox = new JComboBox();
		tempComboBox.setBounds(200, 50, 100, 15);
		tempComboBox.setVisible(false);
		
		mainFrame.add(selectByCodeLbl);
		mainFrame.add(countryCodeComboBox);
		mainFrame.add(comboBoxOrLbl);
		mainFrame.add(selectByNameLbl);
		mainFrame.add(countryNameComboBox);
		mainFrame.add(tempComboBox);
		mainFrame.setLayout(null);
		mainFrame.setResizable(false);
	}
	
	public void results() {
		String str = "Program made by James Cockshott (JamesWRC) But you will never see this message ;)";
		resultInfo = new JTextArea(str, 6, 10);
		scrollPane = new JScrollPane(resultInfo);
		scrollPane.setBounds(10, 500, 430, 145);
		resultInfo.setText("Welcome to the Malria Diagnosis Tool. To start simply select a country code or country name to see what the malaria types are in the selected country");
		resultInfo.setLineWrap(true);
		resultInfo.setWrapStyleWord(true);
		resultInfo.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
		resultInfo.setEditable(false);
		mainFrame.add(scrollPane);

	}

}
