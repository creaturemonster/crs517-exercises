package rain;

public class Category {
	private int id;
	private String category;
	
	
	public void setName(String name){
		category = name;
	}
	
	public String getName(){
		return category;
	}
	
	/**
	 * @return Returns the category.
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category The category to set.
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return Returns the id.
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id The id to set.
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	public String toString(){
		return category;
	}
	
	
}
