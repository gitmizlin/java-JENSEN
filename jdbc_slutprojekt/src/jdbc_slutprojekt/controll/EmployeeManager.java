package jdbc_slutprojekt.controll;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.mysql.jdbc.ResultSetMetaData;

import jdbc_slutprojekt.model.Employee;
import jdbc_slutprojekt.view.EmployeeResultView;
import jdbc_slutprojekt.view.EmployeeSelectActionView;

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
		
		return employee;
	}

	public String printEmployee(ResultSet rs) throws SQLException {
		Employee employee = getEmployee(rs);
		
		return employee.getId() + " " + employee.getFname() + " " + 
				employee.getLname() + " " + employee.getOffice() + " " +
				employee.getProject() + "\n";
	}

	public void editTable(ResultSet rs, Connection conn) throws SQLException {
//		new SelectActionForTableView("Employee table");
		
//		if (input == 1)
//			addRow(conn);				
//		else if (input == 2)
//			updateRow(conn);
//		else if (input == 3)
//			deleteRow(conn);
//		else if (input == 4)
//			search(conn);
//		else if (input == 5) 
//			getStats(conn);
//		else if (input == 6) 
//			getAllRows(rs);
//		else if (input == 7)
//			return;
	}
	
	public void addRow(Connection conn) throws SQLException {
		
		String fName = InputHelper.getStringInput("Enter a first name: "); 
		String lName = InputHelper.getStringInput("Enter a last name: "); 
		String officeNumber = InputHelper.getStringInput("Enter an office number: ");
		String projectNumber = InputHelper.getStringInput("Enter an project number: ");
		
		String query = "INSERT INTO employees (fname, lname, project, office) VALUES ('" + fName + 
				"', '" + lName + "', " + projectNumber + ", " + officeNumber + ")";
		
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.executeUpdate(query);
		System.out.println("A row has been inserted.");	

		// Print out the last row
		String query2 = "SELECT * FROM employees ORDER by id DESC LIMIT 1";
		PreparedStatement stmt2 = conn.prepareStatement(query2);
		ResultSet rs = stmt2.executeQuery();
		rs.last();
		System.out.println(getEmployee(rs).toString());		
	}
	
	public void updateRow(Connection conn) throws SQLException {
		
		int employeeId = InputHelper.getIntegerInput("Enter a employee id you want to update: "); 
		String officeNumber = InputHelper.getStringInput("Enter a new office number: ");
		String projectNumber = InputHelper.getStringInput("Enter a new project number: ");
		
		String query = "UPDATE employees "
				+ "SET office = " + officeNumber + ", project = " + projectNumber + 
				" WHERE id = " + employeeId; 

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
	
	
	public void search(Connection conn) throws SQLException {
		
		System.out.println("------------------------");
		System.out.println("1: Search employee by name");
		System.out.println("2: Search employee by project");
		System.out.println("3: Go back to main menu\n");
		
		try {				

			int input = InputHelper.getIntegerInput("Select a number: "); 
			
			switch(input) {
				case 1:	
					getEmployeeByName(conn);
					break;
						
				case 2:
					getEmployeeByProject(conn);
					break;
						
				case 3: System.out.println("Go back to main");
					break;			
			}
			
		} catch (Exception e) {
			System.out.println("Invalid input.");	
			System.err.println(e.getMessage());							
		}
	}
	
	public void getEmployeeByName(Connection conn) throws SQLException {
	
		System.out.println("*****************************");
		
		String input = InputHelper.getStringInput("Enter a letter / letters. \n"
				+ "All the employees with a name containing the letter(s) will be "
				+ "displayed: "); 
		
		try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employees "
				+ "JOIN offices on employees.office = offices.id "
				+ "JOIN projects on employees.project = projects.id "
				+ "WHERE fname LIKE ? "
				+ "OR lname LIKE ?");) {
			
			stmt.setString(1, "%" + input + "%");
			stmt.setString(2, "%" + input + "%");	
			
			ResultSet rs = stmt.executeQuery();
//			getAllRows(rs);			
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public void getEmployeeByProject(Connection conn) throws SQLException {	
		
		System.out.println("*****************************");
		
		int input = InputHelper.getIntegerInput("Enter a project number: "); 
		
		try {
			
			String query = "SELECT * FROM employees WHERE project = " + input;
			System.out.println(query);
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			printEmployee(rs);			
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public void getStats(Connection conn) throws SQLException {
		
		System.out.println("+++++++++++++++++");
		
		try (PreparedStatement stmt = conn.prepareStatement
				("SELECT projects.name, COUNT(*) as number_of_employees_by_project FROM employees "
						+ "INNER JOIN projects on employees.project = projects.id group by project ORDER BY number_of_employees_by_project DESC");) {
			ResultSet rs = stmt.executeQuery();
			
			System.out.print("The number of employees in each project \n");
//			while (rs.next()) {
//	            System.out.print(rs.getString("projects.name") + " : " + rs.getString("number_of_employees_by_project") + "\n");
//			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		try (PreparedStatement stmt2 = conn.prepareStatement
				("SELECT offices.name, COUNT(*) as number_of_employees_by_office FROM employees "
						+ "INNER JOIN offices on employees.office = offices.id group by office order by number_of_employees_by_office"
						+ " DESC");) {
			ResultSet rs2 = stmt2.executeQuery();
			
			System.out.println("+++++++++++++++++");
			System.out.print("The number of employees in each office \n");
//			while (rs2.next()) {
//	            System.out.print(rs2.getString("offices.name") + " : " + rs2.getString("number_of_employees_by_office") + "\n");
//			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	public void getAllRows(ResultSet rs) throws SQLException {

		String txt = "";		

		while (rs.next()) {

			txt = txt + printEmployee(rs);            
		}
		ev.result.setText(txt);		
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
			ev.add(p);
			
			int employeeId = getEmployee(rs).getId();
			
			btn.addActionListener(new ActionListener() {				
				public void actionPerformed(ActionEvent e) {					
					try {	
						l.setText("*** Employee " + employeeId + " has been deleted ***");
						btn.setVisible(false);
						String queryDelete = "DELETE FROM employees WHERE id = " + employeeId;
						System.out.println("queryDelete: " + queryDelete );
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
}
