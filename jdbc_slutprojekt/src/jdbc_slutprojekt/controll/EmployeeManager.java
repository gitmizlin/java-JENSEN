package jdbc_slutprojekt.controll;

import java.awt.Dimension;
import java.awt.GridBagLayout;
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
import jdbc_slutprojekt.view.EmployeeResultView;

public class EmployeeManager {
	private Connection conn;
	private EmployeeResultView ev;

	public EmployeeManager(Connection conn) throws SQLException {
		this.conn = conn;
		ev = new EmployeeResultView("Employee search result:");
	}

	private Employee getEmployee(ResultSet rs) throws SQLException {

		Employee employee = new Employee();
		employee.setId(rs.getInt("id"));
		employee.setFname(rs.getString("fname"));
		employee.setLname(rs.getString("lname"));
		employee.setOffice(rs.getInt("office"));
		employee.setProject(rs.getInt("project"));
		employee.setOfficeName(rs.getString("officeName"));
		employee.setProjectName(rs.getString("projectName"));

		return employee;
	}

	public String printEmployee(ResultSet rs) throws SQLException {
		Employee employee = getEmployee(rs);

		return employee.getId() + " " + employee.getFname() + " " + employee.getLname() + " / " + employee.getOfficeName()
				+ " / " + employee.getProjectName() + "\n";
	}

	public void updateRow(Connection conn) throws SQLException {

		int employeeId = InputHelper.getIntegerInput("Enter a employee id you want to update: ");
		String officeNumber = InputHelper.getStringInput("Enter a new office number: ");
		String projectNumber = InputHelper.getStringInput("Enter a new project number: ");

		String query = "UPDATE employees " + "SET office = " + officeNumber + ", project = " + projectNumber
				+ " WHERE id = " + employeeId;

		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.executeUpdate(query);
		System.out.println("Employee ID " + employeeId + " has been updated.");

		// Print out the last row
		String query2 = "SELECT * FROM employees WHERE id = " + employeeId;
		PreparedStatement stmt2 = conn.prepareStatement(query2);
		ResultSet rs = stmt2.executeQuery();
		rs.next();
		System.out.println(getEmployee(rs).toString());
	}

	public void getAllRows(ResultSet rs) throws SQLException {

		String txt = "";

		while (rs.next()) {

			txt = txt + printEmployee(rs);
		}
		ev.setResultInTextArea(txt, ev.getResultTextArea());
	}

	public void getAllRowsWithDeleteButton(ResultSet rs) throws SQLException {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

		while (rs.next()) {
			JPanel p2 = new JPanel();
			p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
			JLabel l = new JLabel(printEmployee(rs));
			JButton btn = new JButton("delete");
			p2.add(btn);
			p2.add(l);
			p.add(p2);
			ev.addToMainPanel(p);

			int employeeId = getEmployee(rs).getId();

			btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						l.setText("*** Employee " + employeeId + " has been deleted ***");
						btn.setVisible(false);
						String queryDelete = "DELETE FROM employees WHERE id = " + employeeId;
						PreparedStatement stmt2 = conn.prepareStatement(queryDelete);
						stmt2.executeUpdate();

					} catch (SQLException ex) {
						System.out.println(ex.getMessage());
					}

				}

			});
		}
		ev.setVisible(true);
	}

	public void getEmployeeByName(Connection conn, String s) throws SQLException {

		try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employees "
				+ "JOIN offices on employees.office = offices.id " + "JOIN projects on employees.project = projects.id "
				+ "WHERE fname LIKE ? " + "OR lname LIKE ?");) {

			stmt.setString(1, "%" + s + "%");
			stmt.setString(2, "%" + s + "%");

			ResultSet rs = stmt.executeQuery();
			getAllRows(rs);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void search(Connection conn) throws SQLException {

		JTextField field = new JTextField("Enter a letter / letters for name search.");
		JTextArea searchResultTa = new JTextArea();
		searchResultTa.setMinimumSize(new Dimension(200, 24));

		field.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				field.setText("");
			}
		});

		JButton searchStartBtn = new JButton("Search");
		ev.add(field);
		ev.add(searchStartBtn);
		ev.setVisible(true);

		searchStartBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					getEmployeeByName(conn, field.getText());

				} catch (Exception e1) {

					e1.printStackTrace();
				}
			}
		});

	}

	public void addRow(Connection conn) throws SQLException {

		JTextField fnameField = new JTextField("Enter first name");
		fnameField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fnameField.setText("");
			}
		});

		ev.addToMainPanel(fnameField);

		JTextField lnameField = new JTextField("Enter last name");
		lnameField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lnameField.setText("");
			}
		});
		ev.addToMainPanel(lnameField);

		JTextField officeField = new JTextField("Enter office number");
		officeField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				officeField.setText("");
			}
		});
		ev.addToMainPanel(officeField);

		JTextField projectField = new JTextField("Enter project number");
		projectField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				projectField.setText("");
			}
		});
		ev.addToMainPanel(projectField);

		JButton addRowBtn = new JButton("Add");
		ev.addToMainPanel(addRowBtn);

		ev.setVisible(true);

		addRowBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try (PreparedStatement stmtAddRow = conn.prepareStatement(
						"INSERT INTO employees (fname, lname, project, office) " + "VALUES (?, ?, ?, ?)");) {

					String fName = fnameField.getText();
					String lName = lnameField.getText();
					int officeNumber = Integer.parseInt(officeField.getText());
					int projectNumber = Integer.parseInt(projectField.getText());

					stmtAddRow.setString(1, fName);
					stmtAddRow.setString(2, lName);
					stmtAddRow.setInt(3, officeNumber);
					stmtAddRow.setInt(4, projectNumber);

					stmtAddRow.executeUpdate();

					// get the last row
					String query2 = "SELECT * FROM employees ORDER by id DESC LIMIT 1";
					PreparedStatement stmt2 = conn.prepareStatement(query2);
					ResultSet rsLastRow = stmt2.executeQuery();
					rsLastRow.last();
					Employee lastE = getEmployee(rsLastRow);
					String addedE = "Employee ***" + lastE.getId() + " " + lastE.getFname() + " " + lastE.getLname()
							+ " " + lastE.getOffice() + " " + lastE.getProject() + "*** has been added.";

					ev.getResultTextArea().setText(addedE);

				} catch (Exception e1) {

					e1.printStackTrace();
				}
			}
		});
	}
}
