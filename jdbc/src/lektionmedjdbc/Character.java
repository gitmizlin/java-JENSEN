package lektionmedjdbc;

// Övning 7
// Skriv en JavaBean-klass Character som ska motsvara en rad i characters-tabellen.

public class Character {
	private int id;
	private String fname;
	private String lname;
	private String race;
	private String birthDate;	
	private int level;
	private int experience;
	private int classId;

	Character() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	@Override
	public String toString() {
		return "Character [id=" + id + ", fname=" + fname + ", lname=" + lname + ", race=" + race + ", birthDate="
				+ birthDate + ", level=" + level + ", experience=" + experience + ", classId=" + classId + "]";
	}	
}
