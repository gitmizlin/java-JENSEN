package jdbc_slutprojekt.controll;

import java.awt.Dimension;
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
import javax.swing.JTextArea;
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
	
	public void getOfficeByName(Connection conn, String s) throws SQLException {

		try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM offices "
				+ "WHERE name LIKE ?");) {

			stmt.setString(1, "%" + s + "%");

			ResultSet rs = stmt.executeQuery();
			getAllRows(rs);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void search(Connection conn) throws SQLException {
		JPanel p = new JPanel();

		JTextField field = new JTextField("Enter a letter / letters for name search.");
		JTextArea searchResultTa = new JTextArea();
		searchResultTa.setEditable(false);
		
		searchResultTa.setMinimumSize(new Dimension(200, 24));

		field.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				field.setText("");
			}
		});

		JButton searchStartBtn = new JButton("Search");
		
		p.add(field);
		p.add(searchResultTa);
		p.add(searchStartBtn);
		ov.addToMainPanel(p);
		ov.setVisible(true);

		searchStartBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					getOfficeByName(conn, field.getText());

				} catch (Exception ex) {

					ex.printStackTrace();
				}
			}
		});

	}
}
