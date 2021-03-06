package lektionmedjdbc;

/*
 * Övningar
 * http://porkforge.mardby.se/index.php?title=%C3%96va_p%C3%A5_grunderna_i_JDBC#.C3.96vning_3
*/

import java.sql.*;

public class JDBC_02 {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final String CONN_STRING ="jdbc:mysql://localhost/epic_rpg";	
	
	//Övning 2
	//Skriv en Main-klass som låter användaren mata in en siffra och sedan 
	//skriver ut name på den class som har den siffran som id.
	
//public static void main(String[] args)  {
//
//	try		
//	(
//		Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
//		Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//		ResultSet rs = stm.executeQuery("SELECT * FROM class");	
//	)
//	{			
//		// Övning 1
//		// Skriv en Main-klass som skriver ut alla värden i name-kolumnen ifrån 
//		// class-tabellen
//		
//		while (rs.next()) {		
//			CharacterClass characterClass = ClassManager.getCharacterClass(rs);
//			System.out.println(characterClass.getName());	
//		}
//
//	} 
//	catch (SQLException e) {			
//		System.err.println(e.getMessage());
//	}			
//}
	
	// Övning 2
	// Skriv en Main-klass som låter användaren mata in en siffra och sedan skriver ut name 
	// på den class som har den siffran som id.
	
//	public static void main(String[] args)  {	
//		try		
//		(
//			Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
//			PreparedStatement stm = conn.prepareStatement("SELECT * FROM class WHERE id = ?");
//		)
//		{			
//			boolean complete = false;
//			do {
//				
//				try {
//					
//					int input = InputHelper.getIntegerInput("Enter a Class ID: ");				
//					stm.setInt(1, input);
//			
//					ResultSet rs = stm.executeQuery();
//					rs.next();			
//					CharacterClass characterClass = ClassManager.getCharacterClass(rs);			
//					System.out.println("ID: " + input + " Class: " + characterClass.getName());	
//					complete = true;
//					
//				} catch (Exception e) {
//					System.err.println(e.getMessage() + "\n");
//				}			
//
//			} while (!complete);
//		} 
//		catch (SQLException e) {			
//			System.err.println(e.getMessage());
//		}
//	}
	
	// Övning 3
	//	Skriv en ny Main-klass med en main-metod som hämtar alla characters som har 
	// mer experience än 30000. Använd metoderna ovan för att skriva ut den person som 
	//	har mest experience samt hur många de är som har mer än 30000.
	
//	public static void main(String[] args)  {	
//		try	(Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
//				
//			PreparedStatement stm = conn.prepareStatement
//					("SELECT * FROM characters WHERE experience >= 30000 ORDER BY experience DESC");) {			

//						
//			ResultSet rs = stm.executeQuery();
//			
//			// Alla characters som har mer experience än 30000			
//			while (rs.next()) {		
//				Character character = CharacterManager.getCharacter(rs);
//				System.out.println(character.getFname() + " " + character.getLname() + 
//						" / Experience: " + character.getExperience());
//			}
//			
//			//  den person som har mest experience
//			rs.beforeFirst();
//			rs.next();
//			Character character = CharacterManager.getCharacter(rs);
//			System.out.println("Den som har mest experience: " + character.getFname() +
//					" " + character.getLname() + " / Experience: " + character.getExperience());
//			
//			// Antalet characters som har mer experience än 30000
//			rs.last();
//			int size = rs.getRow();
//			System.out.println("Det finns " + size + " characters som har mer experience än 30000.");
//			
//		} catch (SQLException e) {			
//			System.err.println(e.getMessage());
//		}
	
	
	// Övning5
	// Skriv en CharacterManager-klass som sköter kommunikationen med characters-tabellen. 
	// Klassen ska ha en statisk getAllRows-metod som skriver ut all data ifrån tabellen.
	// Skriv en Main-klass med en main-metod som anropar getAllRows för att testa att den fungerar.
//	public static void main(String[] args)  {
//		
//		try	(Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);				
//			PreparedStatement stm = conn.prepareStatement("SELECT * FROM characters");) {
//			ResultSet rs = stm.executeQuery();
//			CharacterManager.getAllRows(rs);			
//
//		} catch (SQLException e) {			
//			System.err.println(e.getMessage());
//		}
//	}	
	
	// Övning6 
	// Lägg till en metod getCharacter i CharacterManager. 
	// Metoden tar emot ett heltal som argument och skriver ut den character vars id 
	// motsvarar heltalet. Testa metoden ifrån din main-metod.
	
//	public static void main(String[] args)  {
//		boolean complete = false;
//		
//		try(
//			Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
//			PreparedStatement stm = conn.prepareStatement("SELECT * FROM characters WHERE id = ?");) {
//			
//			do {
//				
//				try {
//					int input = InputHelper.getIntegerInput("Enter a Character ID: ");
//					stm.setInt(1, input);
//					ResultSet rs = stm.executeQuery();
//					rs.next();
//					Character character = CharacterManager.getCharacter(rs);
//					System.out.println("ID: " + input + " " + character.getFname() + " " + character.getLname());	
//					complete = true;
//					
//				} catch (Exception e) {
//					System.err.println(e.getMessage() + "\n");
//				}
//				
//			} while (!complete)	;			
//		
//		} catch (SQLException e ) {	
//			System.err.println(e.getMessage() + "\n");			
//		}
//	}

//	public static void main(String[] args)  {	
//		try		
//		(
//			Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
//			PreparedStatement stm = conn.prepareStatement("SELECT * FROM characters WHERE id = ?");
//		)
//		{			
//			boolean complete = false;
//			do {
//				
//				try {
//					
//					int input = InputHelper.getIntegerInput("Enter a Character ID: ");				
//					stm.setInt(1, input);
//			
//					ResultSet rs = stm.executeQuery();
//					rs.next();			
//					CharacterManager.printCharacter(rs);
//					complete = true;
//				} catch (Exception e) {
//					System.err.println(e.getMessage() + "\n");
//				}
//			} while (!complete);
//		} 
//		catch (SQLException e) {			
//			System.err.println(e.getMessage());
//		}
//	}
	
	// Övning 9
	// Skriv en insert-metod som tar emot ett Character-objekt och som stoppar in 
	// dess data i characters-tabellen. Metoden bör returnera true/false så vi vet
	// om INSERT INTO lyckades eller inte. Finns det något annat metoden skulle kunna
	// returnera istället?
	
	public static void main(String[] args) {
		System.out.println(update());
	}
	
//	public static boolean insert()  {	
//	
//		try		
//		(
//			Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
//			PreparedStatement stm = conn.prepareStatement("INSERT INTO characters "
//					+ "(fname, lname, level, experience, race, class, birthdate)"
//					+ " VALUES (?, ?, ?, ?, ?, ?, ?);");
//		)
//		{		
//
//			boolean complete = false;
//			do {
//				
//				try {
//					
//					String inputFname = InputHelper.getStringInput("Enter a first name: ");
//					String inputLname = InputHelper.getStringInput("Enter a last name: ");
//					int inputLevel = InputHelper.getIntegerInput("Enter a level: ");
//					int inputExperience = InputHelper.getIntegerInput("Enter an experience: ");
//					String inputRace = InputHelper.getStringInput("Enter a race: ");
//					int inputClass = InputHelper.getIntegerInput("Enter a Class ID: ");					
//					String inputBirthdate = InputHelper.getStringInput("Enter a birth date: ");				
//					
//					stm.setString(1, inputFname);
//					stm.setString(2, inputLname);
//					stm.setInt(3, inputLevel);
//					stm.setInt(4, inputExperience);
//					stm.setString(5, inputRace);
//					stm.setInt(6, inputClass);
//					stm.setString(7, inputBirthdate);
//			
//					stm.executeUpdate();
//					
//					System.out.println("Record is inserted into table!");			
//					complete = true;
//					
//				} catch (Exception e) {
//					System.err.println(e.getMessage() + "\n");
//				}
//				
//			} while (!complete);
//			
//		} 
//		catch (SQLException e) {			
//			System.err.println(e.getMessage());
//		}
//		return true;
	
	// Övning 10
	// Skriv en update-metod som tar emot ett Character-objekt och som stoppar in dess 
	// data i characters-tabellen. Metoden bör returnera true/false så vi vet om UPDATE
	// lyckades eller inte. Finns det något annat metoden skulle kunna returnera istället?
	
	public static boolean update()  {	

	      String query = "UPDATE characters SET fname = ?, lname = ?, level = ?, experience = ?,"
	      		+ " race = ?, class = ?, birthdate = ? where id = ?"; 
	      
		try		
		(
			Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
			PreparedStatement stm = conn.prepareStatement(query);
			
		)
		{		

			boolean complete = false;
			do {
				
				try {
					int inputId = InputHelper.getIntegerInput("Enter a character ID: ");
					String inputFname = InputHelper.getStringInput("Enter a first name: ");
					String inputLname = InputHelper.getStringInput("Enter a last name: ");
					int inputLevel = InputHelper.getIntegerInput("Enter a level: ");
					int inputExperience = InputHelper.getIntegerInput("Enter an experience: ");
					String inputRace = InputHelper.getStringInput("Enter a race: ");
					int inputClass = InputHelper.getIntegerInput("Enter a Class ID: ");					
					String inputBirthdate = InputHelper.getStringInput("Enter a birth date: ");				
					
					stm.setInt(8, inputId);
					stm.setString(1, inputFname);
					stm.setString(2, inputLname);
					stm.setInt(3, inputLevel);
					stm.setInt(4, inputExperience);
					stm.setString(5, inputRace);
					stm.setInt(6, inputClass);
					stm.setString(7, inputBirthdate);
			
					stm.executeUpdate();
					
					System.out.println("Row " + inputId + " is updated!");			
					complete = true;
					
				} catch (Exception e) {
					System.err.println(e.getMessage() + "\n");
				}
				
			} while (!complete);
			
		} 
		catch (SQLException e) {			
			System.err.println(e.getMessage());
		}
		return true;
	}	
}	
	
