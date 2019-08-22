package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

import database.DatabaseHelper;
import model.Country;

public class CountrySelectedListener implements ActionListener {
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox, boxToUpdate;
	private JTextArea resultInfo;
	private JFrame mainFrame;
	private JProgressBar bar1 = new JProgressBar();
	private JProgressBar bar2 = new JProgressBar();
	private JProgressBar bar3 = new JProgressBar();
	private JProgressBar bar4 = new JProgressBar();
	private JProgressBar bar5 = new JProgressBar();
	private Country countrySelected, countrySelectedSecondaryName;
	private DatabaseHelper dbh;
	private JLabel falciparumLbl = new JLabel();
	private JLabel vivaxLbl = new JLabel();
	private JLabel malariaeLbl = new JLabel();
	private JLabel ovaleLbl = new JLabel();
	private JLabel knowlsiLbl = new JLabel();

	
	private final static int PROG_BAR_DEFAULT_X = 75;
	private final static int PROG_BAR_Y_INCREMENT = 75;
	private final static int PROG_BAR_DEFAULT_WIDTH = 300;
	private final static int PROG_BAR_DEFAULT_HEIGHT = 50;
	private final static int PROG_BAR_LBL_OFFSET = 15;
	
	
	public CountrySelectedListener(@SuppressWarnings("rawtypes") JComboBox comboBox, JComboBox boxToUpdate, JTextArea resultInfo, JFrame mainFrame)
			throws SQLException {
		this.comboBox = comboBox;
		this.boxToUpdate = boxToUpdate;
		this.resultInfo = resultInfo;
		this.mainFrame = mainFrame;
		dbh = new DatabaseHelper();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int prog_bar_count_multiplyer = 1; //the number of prog bars shown to accurately space each bar apart. Acts as a multiplier.

		try {
			bar1.setVisible(false);
			bar2.setVisible(false);
			bar3.setVisible(false);
			bar4.setVisible(false);
			bar5.setVisible(false);
			
			falciparumLbl.setVisible(false);
			vivaxLbl.setVisible(false);
			malariaeLbl.setVisible(false);
			ovaleLbl.setVisible(false);
			knowlsiLbl.setVisible(false);
			comboBox.getSelectedItem().toString();


			countrySelected = dbh.getCountry(comboBox.getSelectedItem().toString());
			//set the opposite box to the respective name / code.
			//ie if AU is selected in the country code box, then the country name
			//in the countyName box changes to Australia
			if(comboBox.getSelectedItem().toString().length() == 2) {
				boxToUpdate.setSelectedItem(countrySelected.getCountryName());
			}else {
				boxToUpdate.setSelectedItem(countrySelected.getCountryCode());
			}
			//boxToUpdate.setSelectedItem(countrySelected.get);

			// Once set to true, it can't be printed out again
			boolean falciparumSet = false;
			boolean vivaxSet = false;
			boolean malariaeSet = false;
			boolean ovaleSet = false;
			boolean knowlsiSet = false;
			for (int currentPercentage : countrySelected.getOrderedList()) {
				if (countrySelected.getFalciparum() == currentPercentage && !falciparumSet) {
					if (currentPercentage != 0) {
						prog_bar_count_multiplyer++;
						bar1.setBounds(PROG_BAR_DEFAULT_X, prog_bar_count_multiplyer*PROG_BAR_Y_INCREMENT, PROG_BAR_DEFAULT_WIDTH, PROG_BAR_DEFAULT_HEIGHT);
						falciparumLbl.setBounds(bar1.getX(), bar1.getY() - PROG_BAR_LBL_OFFSET, bar1.getWidth(), bar1.getHeight());
						falciparumLbl.setText("falciparum: ");
						mainFrame.add(falciparumLbl);
						bar1.setMinimum(0);
						bar1.setMaximum(100);
						bar1.setValue(countrySelected.getFalciparum());
						bar1.setStringPainted(true);
						mainFrame.add(bar1);
						falciparumSet = true;
						falciparumLbl.setVisible(true);
						bar1.setValue(countrySelected.getFalciparum());
						bar1.setVisible(true);
					}else{
						bar1.setVisible(false);
						falciparumLbl.setVisible(false);
					}
				} else if (countrySelected.getVivax() == currentPercentage && !vivaxSet) {
					if (currentPercentage != 0) {
						prog_bar_count_multiplyer++;
						bar2.setMinimum(0);
						bar2.setMaximum(100);
						bar2.setValue(countrySelected.getVivax());
						bar2.setBounds(PROG_BAR_DEFAULT_X, prog_bar_count_multiplyer*PROG_BAR_Y_INCREMENT, PROG_BAR_DEFAULT_WIDTH, PROG_BAR_DEFAULT_HEIGHT);
						bar2.setStringPainted(true);
						vivaxLbl.setBounds(bar2.getX(), bar2.getY() - PROG_BAR_LBL_OFFSET, bar2.getWidth(), bar2.getHeight());
						vivaxLbl.setText("vivax: ");
						mainFrame.add(vivaxLbl);
						mainFrame.add(bar2);
						vivaxSet = true;
						vivaxLbl.setVisible(true);
						bar2.setValue(countrySelected.getVivax());
						bar2.setVisible(true);
					}else{
						bar2.setVisible(false);
						vivaxLbl.setVisible(false);
					}
				} else if (countrySelected.getMalariae() == currentPercentage && !malariaeSet) {
					if (currentPercentage != 0) {
						prog_bar_count_multiplyer++;
						bar3.setMinimum(0);
						bar3.setMaximum(100);
						bar3.setValue(countrySelected.getMalariae());
						bar3.setBounds(PROG_BAR_DEFAULT_X, prog_bar_count_multiplyer*PROG_BAR_Y_INCREMENT, PROG_BAR_DEFAULT_WIDTH, PROG_BAR_DEFAULT_HEIGHT);
						bar3.setStringPainted(true);
						malariaeLbl.setBounds(bar3.getX(), bar3.getY() - PROG_BAR_LBL_OFFSET, bar3.getWidth(), bar3.getHeight());
						malariaeLbl.setText("malariae: ");
						mainFrame.add(malariaeLbl);
						mainFrame.add(bar3);
						malariaeSet = true;
						malariaeLbl.setVisible(true);
						bar3.setValue(countrySelected.getMalariae());
						bar3.setVisible(true);

					}else{
						bar3.setVisible(false);
						malariaeLbl.setVisible(false);
					}
				} else if (countrySelected.getOvale() == currentPercentage && !ovaleSet) {
					if (currentPercentage != 0) {
						prog_bar_count_multiplyer++;

						bar4.setMinimum(0);
						bar4.setMaximum(100);
						bar4.setValue(countrySelected.getOvale());
						bar4.setBounds(PROG_BAR_DEFAULT_X, prog_bar_count_multiplyer*PROG_BAR_Y_INCREMENT, PROG_BAR_DEFAULT_WIDTH, PROG_BAR_DEFAULT_HEIGHT);
						bar4.setStringPainted(true);
						ovaleLbl.setBounds(bar4.getX(), bar4.getY() - PROG_BAR_LBL_OFFSET, bar4.getWidth(), bar4.getHeight());
						ovaleLbl.setText("ovale: ");
						mainFrame.add(ovaleLbl);
						mainFrame.add(bar4);
						ovaleSet = true;
						ovaleLbl.setVisible(true);
						bar4.setValue(countrySelected.getOvale());
						bar4.setVisible(true);
					}else{
						bar4.setVisible(false);
						ovaleLbl.setVisible(false);
					}
				} else if (countrySelected.getKnowlesi() == currentPercentage && !knowlsiSet) {
					if (currentPercentage != 0) {
						prog_bar_count_multiplyer++;
						bar5.setMinimum(0);
						bar5.setMaximum(100);
						bar5.setValue(countrySelected.getKnowlesi());
						bar5.setBounds(PROG_BAR_DEFAULT_X, prog_bar_count_multiplyer*PROG_BAR_Y_INCREMENT, PROG_BAR_DEFAULT_WIDTH, PROG_BAR_DEFAULT_HEIGHT);
						bar5.setStringPainted(true);
						knowlsiLbl.setBounds(bar5.getX(), bar5.getY() - PROG_BAR_LBL_OFFSET, bar5.getWidth(), bar5.getHeight());
						knowlsiLbl.setText("knowlsi: ");
						mainFrame.add(knowlsiLbl);
						mainFrame.add(bar5);
						knowlsiSet = true;
						knowlsiLbl.setVisible(true);
						bar5.setValue(countrySelected.getKnowlesi());
						bar5.setVisible(true);
					}else{
						bar5.setVisible(false);
						knowlsiLbl.setVisible(false);
					}
				}
			}
			falciparumSet = false;
			vivaxSet = false;
			malariaeSet = false;
			ovaleSet = false;
			knowlsiSet = false;

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		if(prog_bar_count_multiplyer == 1) {
			resultInfo.setText("No Malaria in this country");
		}else{
			String removeFormatString = countrySelected.getReport();
			removeFormatString = removeFormatString.replace("[", "").replace("#", "").replace("]", "");

			resultInfo.setText(removeFormatString);
			if(countrySelected.getNotes() == null) {
				resultInfo.append("\nNo extra information about this country");

			}else {
			String removeNotesString = countrySelected.getNotes();
			removeNotesString = "\n\tAdditional Notes:\n " + removeNotesString.replace("\n", "").replace("\t", "");
			resultInfo.append(removeNotesString);
			}
		}


	}

}
