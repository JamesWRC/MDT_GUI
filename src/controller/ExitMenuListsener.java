package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitMenuListsener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		//terminates program
		System.exit(0);
	}
}
