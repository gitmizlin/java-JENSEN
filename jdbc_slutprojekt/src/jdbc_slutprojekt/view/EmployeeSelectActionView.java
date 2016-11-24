package jdbc_slutprojekt.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import jdbc_slutprojekt.controll.EmployeeManager;

public class EmployeeSelectActionView extends JFrame {

	private JButton addButton = new JButton("Add");
	private JButton updateButton = new JButton("Update");
	private JButton deleteButton = new JButton("Delete");
	private JButton searchButton = new JButton("Search");
	private JButton showAllButton = new JButton("Show all data");
	private JButton goBackToMainButton = new JButton("Go back to main menu");
	private Box box = Box.createVerticalBox();

	public EmployeeSelectActionView(String title, ResultSet rs, Connection conn) throws SQLException {
		super(title);

		EmployeeManager em = new EmployeeManager(conn, rs);

		try {
			System.out.println("constructor closed? " + rs.isClosed());
		} catch (SQLException e2) {

			e2.printStackTrace();
		}

		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900, 400);
		setLocation(100, 100);

		box.add(addButton);
		box.add(updateButton);
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

		searchButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					em.search(conn);
					setVisible(false);

				} catch (Exception e1) {

					e1.printStackTrace();
				}
			}
		});

		addButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					em.addRow(conn);
					setVisible(false);

				} catch (Exception e1) {

					e1.printStackTrace();
				}
			}
		});

		updateButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					em.updateRow(rs);

					setVisible(false);

				} catch (Exception e1) {

					e1.printStackTrace();
				}
			}
		});
	}
}