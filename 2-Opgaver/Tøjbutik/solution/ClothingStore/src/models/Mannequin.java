package models;

public class Mannequin {
	
	private int id;
	private boolean isFemale;
	private Clothing[] clothes;
	
	public Mannequin(int id, boolean isFemale) {
		this.id = id;
		this.isFemale = isFemale;
		clothes = new Clothing[0];
	}
	
	public Mannequin(int id, boolean isFemale, Clothing[] clothes) {
		this.id = id;
		this.isFemale = isFemale;
		this.clothes = clothes;
	}
	
	public boolean isFemale() {
		return isFemale;
	}
	
	public void setIsFemale(boolean isFemale) {
		this.isFemale = isFemale;
	}

	public Clothing[] getClothes() {
		return clothes;
	}
	
	public void addWear(Clothing wear) {
		Clothing[] temp = new Clothing[clothes.length + 1];
		
		for (int i = 0; i < clothes.length; i++)
			temp[i] = clothes[i];
		
		temp[temp.length-1] = wear;
		clothes = temp;
	}
	
	public void removeWear(Clothing ware) {
		Clothing[] temp = new Clothing[clothes.length - 1];
		boolean hasFoundWear = false;
		
		for (int i = 0; i < temp.length; i++) {
			if (!clothes[i].equals(ware)) {
				temp[hasFoundWear ? i - 1 : i] = clothes[i];
			} else {
				hasFoundWear = true;
			}
		}
		
		clothes = temp;
	}

	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		String display = "";
		
		for (Clothing wear : clothes)
			display += "\n" + wear;
		
		return (isFemale ? "Female" : "Male") + " Mannequin with id " + id + ", has the following wears:\n" + display;
	}
}