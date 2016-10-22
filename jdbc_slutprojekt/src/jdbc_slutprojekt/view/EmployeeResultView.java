package jdbc_slutprojekt.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;

import jdbc_slutprojekt.controll.EmployeeManager;
import jdbc_slutprojekt.controll.Engine;

public class EmployeeResultView extends JFrame {

	private JButton goBackToMainButton = new JButton("Go back to main menu");
	public JTextArea result = new JTextArea();
	public EmployeeResultView(String title) throws SQLException {
		super(title);
				
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 700);
		setLocation(100, 100);

		add(goBackToMainButton);
		add(result);
		
		setVisible(true);


		goBackToMainButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setVisible(false);
					Engine.main(null);
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
		});
	}
}
