package jdbc_slutprojekt.controll;

import java.sql.*;

import jdbc_slutprojekt.view.SelectTableView;
import jdbc_slutprojekt.view.EmployeeResultView;
import jdbc_slutprojekt.view.EmployeeSelectActionView;

public class Engine {
	private final String USER = "root";
	private final String PASSWORD = "";
	private final String CONN_STRING = "jdbc:mysql://localhost/company";
	private Connection conn;
	private EmployeeManager em;
	EmployeeResultView rv = new EmployeeResultView("Employee search result");

	Engine() throws SQLException {
		new SelectTableView("Select a table", this);
		conn = DriverManager.getConnection(CONN_STRING, USER, PASSWORD);
		System.out.println("end of constructor");
	}

	public static void main(String[] args) throws SQLException {
		new Engine();
	}

	public void selectTable(int tableId) throws SQLException {

		if (tableId == 1) {
			try {
				PreparedStatement stmt = conn.prepareStatement(
						"Select * from employees LEFT JOIN projects ON projects.id = employees.project "
								+ "LEFT JOIN offices on offices.id = employees.office");
				ResultSet rs = stmt.executeQuery();
				new EmployeeSelectActionView("Employee table: Select an action", rs, conn);

			} catch (Exception e) {
				System.out.println("conn----" + conn);
				System.out.println(e.getMessage());
			}

		}
		// else if (tableId == 2) {

		// try(Connection conn = DriverManager.getConnection(CONN_STRING, USER,
		// PASSWORD);
		// PreparedStatement stmt = conn.prepareStatement("Select * from
		// offices");) {
//		 ResultSet rs = stmt.executeQuery();
		// OfficeManager.editTable(rs, conn, 2);
		//
		// } catch (SQLException e) {
		// System.out.println(e.getMessage());
		// }

		// } else if (tableId == 3) {

		// try(Connection conn = DriverManager.getConnection(CONN_STRING, USER,
		// PASSWORD);
		// PreparedStatement stmt = conn.prepareStatement("Select * from
		// projects");) {
		// ResultSet rs = stmt.executeQuery();
		// ProjectManager.editTable(rs, conn);
		//
		// } catch (SQLException e) {
		// System.out.println(e.getMessage());
		// }
		// } else {
		// System.out.println("invalid input");
		// }
	}
}
