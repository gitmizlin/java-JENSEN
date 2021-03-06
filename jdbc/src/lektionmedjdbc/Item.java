package lektionmedjdbc;

public class Item {
	private int id;
	private String name;
	private int owner;
	
	Item() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", owner=" + owner + "]";
	}	
}
