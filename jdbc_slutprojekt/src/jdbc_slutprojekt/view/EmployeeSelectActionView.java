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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import jdbc_slutprojekt.controll.EmployeeManager;

public class EmployeeSelectActionView extends JFrame {

	private JButton addButton = new JButton("Add");
	private JButton deleteButton = new JButton("Delete");
	private JButton searchButton = new JButton("Search");
	private JButton showAllButton = new JButton("Show all data");
	private JButton goBackToMainButton = new JButton("Go back to main menu");
	private Box box = Box.createVerticalBox();

	public EmployeeSelectActionView (String title, ResultSet rs, Connection conn) throws SQLException {
		super(title);
		
		EmployeeManager em = new EmployeeManager(conn);
		
		try {
			System.out.println("constructor closed? " + rs.isClosed());
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 700);
		setLocation(100, 100);

		// addButton.setMinimumSize(new Dimension(200, 100));
		// deleteButton.setMinimumSize(new Dimension(200, 100));
		// searchButton.setMinimumSize(new Dimension(200, 100));
		// showAllButton.setMinimumSize(new Dimension(200, 100));
		// goBackToMainButton.setMinimumSize(new Dimension(200, 100));

		box.add(addButton);
		box.add(deleteButton);
		box.add(searchButton);
		box.add(showAllButton);
		box.add(goBackToMainButton);

		add(box);

		setVisible(true);		

		showAllButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println("btn callback closed? " + rs.isClosed());
					em.getAllRows(rs);
					setVisible(false);

				} catch (Exception e1) {

					e1.printStackTrace();
				}
			}
		});
		
		deleteButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					em.getAllRowsWithDeleteButton(rs);
					setVisible(false);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

	}
}
