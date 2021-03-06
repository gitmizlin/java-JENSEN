package jdbc_slutprojekt.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.JTextField;

import jdbc_slutprojekt.controll.Engine;

public class SelectTableView extends JFrame {
	public JPanel panel = new JPanel();
	Engine engine;
	JButton employeeButton = new JButton("Employee");
	JButton officeButton = new JButton("Office");
	JButton projectButton = new JButton("Project");
	JLabel selectTablelabel = new JLabel("Select a table");

	public SelectTableView(String title, Engine engine) {
		super(title);

		this.engine = engine;
		
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 700);
		setLocation(100, 100);

		employeeButton.setPreferredSize(new Dimension(130, 50));
		officeButton.setPreferredSize(new Dimension(130, 50));
		projectButton.setPreferredSize(new Dimension(130, 50));

		panel.add(selectTablelabel);
		panel.add(employeeButton);
		panel.add(officeButton);
		panel.add(projectButton);

		add(panel);

		setVisible(true);

		employeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					engine.selectTable(1);
					setVisible(false);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		officeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					engine.selectTable(2);
					setVisible(false);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		projectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					engine.selectTable(3);
					setVisible(false);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
