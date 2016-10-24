package jdbc_slutprojekt.controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jdbc_slutprojekt.model.Employee;
import jdbc_slutprojekt.model.Office;
import jdbc_slutprojekt.view.EmployeeResultView;
import jdbc_slutprojekt.view.OfficeResultView;

public class OfficeManager {
	private Connection conn;
	private OfficeResultView ov;

	public OfficeManager(Connection conn) throws SQLException {
		this.conn = conn;
		ov = new OfficeResultView("Office search result:");
	}

	public static Office getOffice(ResultSet rs) throws SQLException {
		Office office = new Office();
		office.setId(rs.getInt("id"));
		office.setName(rs.getString("name"));
		return office;
	}

	public void getAllRows(ResultSet rs) throws SQLException {
		String txt = "";
		while (rs.next()) {
			txt = txt + rs.getInt("id") + " " + rs.getString("name") + " / size:" + rs.getInt("size") + "\n";
		}
		ov.setResultInTextArea(txt, ov.getResultTextArea());
	}
	
	public void addRow(Connection conn) throws SQLException {

		JTextField officeNameField = new JTextField("Enter office name");
		officeNameField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				officeNameField.setText("");
			}
		});

		ov.addToMainPanel(officeNameField);

		JButton addRowBtn = new JButton("Add");
		ov.addToMainPanel(addRowBtn);

		ov.setVisible(true);

		addRowBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try (PreparedStatement stmtAddRow = conn.prepareStatement(
						"INSERT INTO offices (name) VALUES (?)");) {
				
					String officeName = officeNameField.getText();
					stmtAddRow.setString(1, officeName);
					stmtAddRow.executeUpdate();

					// get the last row
					String query2 = "SELECT * FROM offices ORDER by id DESC LIMIT 1";
					PreparedStatement stmt2 = conn.prepareStatement(query2);
					ResultSet rsLastRow = stmt2.executeQuery();
					rsLastRow.last();
					Office lastOffice = getOffice(rsLastRow);
					String addedOffice = "Office ***" + lastOffice.getId() + " " + lastOffice.getName() + " *** has been added.";

					ov.getResultTextArea().setText(addedOffice);

				} catch (Exception e1) {

					e1.printStackTrace();
				}
			}
		});
	}
//
//	public static void addRow(Connection conn) throws SQLException {
//
//		String name = InputHelper.getStringInput("Enter an Office (location) name: ");
//
//		String query = "INSERT INTO offices (name) VALUES ('" + name + "')";
//
//		PreparedStatement stmt = conn.prepareStatement(query);
//		stmt.executeUpdate(query);
//		System.out.println("A row has been inserted.");
//
//		// Print out the last row
//		String query2 = "SELECT * FROM offices ORDER by id DESC LIMIT 1";
//		PreparedStatement stmt2 = conn.prepareStatement(query2);
//		ResultSet rs = stmt2.executeQuery();
//		rs.last();
//		System.out.println(getOffice(rs).toString());
//	}

	public void deleteRow(ResultSet rs) throws SQLException {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

		while (rs.next()) {
			int officeId = getOffice(rs).getId();
			String OfficeName = getOffice(rs).getName();
			
			JPanel p2 = new JPanel();
			p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
			JLabel l = new JLabel(officeId + " " + OfficeName);
			JButton btn = new JButton("delete");
			p2.add(l);
			p2.add(btn);
			p.add(p2);
			ov.addToMainPanel(p);

			btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						l.setText("*** Office " + OfficeName + " has been deleted ***");
						btn.setVisible(false);
						String queryDelete = "DELETE FROM offices WHERE id = " + officeId;
						PreparedStatement stmt = conn.prepareStatement(queryDelete);
						stmt.executeUpdate();

					} catch (SQLException ex) {
						System.out.println(ex.getMessage());
					}
				}

			});
		}
		ov.setVisible(true);
	}

	// public void search(ResultSet rs, Connection conn) throws SQLException {
	//
	// System.out.println("------------------------");
	// System.out.println("1: Search office by name");
	// System.out.println("2: Search office by size");
	// System.out.println("3: Go back to main menu\n");
	//
	// try {
	//
	// int input = InputHelper.getIntegerInput("Select a number: ");
	//
	// switch (input) {
	// case 1:
	// getOfficeByName(conn);
	// break;
	//
	// case 2:
	// getOfficeBySize(conn);
	// break;
	//
	// case 3:
	// System.out.println("Go back to main");
	// break;
	// }
	//
	// } catch (Exception e) {
	// System.out.println("Invalid input.");
	// System.err.println(e.getMessage());
	// }
	// }

	public void getOfficeByName(Connection conn) throws SQLException {
		System.out.println("*****************************");

		String input = InputHelper.getStringInput("Enter a letter / letters. \n"
				+ "All the offices with a name containing the letter(s) will be " + "displayed: ");

		try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM offices " + "WHERE name LIKE ?");) {

			stmt.setString(1, "%" + input + "%");

			ResultSet rs = stmt.executeQuery();
			getAllRows(rs);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	// public static void getOfficeBySize(Connection conn) throws SQLException {
	//
	// String query = "";
	//
	// System.out.println("*****************************");
	// System.out.println("1. Search by min number of employees");
	// System.out.println("2. Search by max number of employees");
	//
	// int input = InputHelper.getIntegerInput("Select a number: ");
	//
	// switch (input) {
	// case 1:
	// int inputMin = InputHelper.getIntegerInput("Enter a min number: ");
	// query = "SELECT * FROM offices where size >= " + inputMin + " ORDER BY
	// size ASC";
	// break;
	// case 2:
	// int inputMax = InputHelper.getIntegerInput("Enter a max number: ");
	// query = "SELECT * FROM offices where size <= " + inputMax + " ORDER BY
	// size ASC";
	// break;
	// case 3:
	// int inputMinRange = InputHelper.getIntegerInput("Enter a min number: ");
	// int inputMaxRange = InputHelper.getIntegerInput("Enter a max number: ");
	// query = "SELECT * FROM offices where size >= " + inputMinRange + " AND
	// size <= " + inputMaxRange
	// + " ORDER BY size ASC";
	// break;
	// }
	//
	// try (PreparedStatement stmt = conn.prepareStatement(query);) {
	//
	// ResultSet rs = stmt.executeQuery();
	// System.out.println("---------------------");
	// getAllRows(rs);
	//
	// } catch (SQLException e) {
	// System.out.println(e.getMessage());
	// }
	// }
}
