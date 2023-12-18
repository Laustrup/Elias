package models;

public class Store {

	private Mannequin[] mannequins;
	
	private static Store store;
	
	public static Store getInstance() {
		if (store == null)
			store = new Store();
		
		return store;
	}
	
	private Store() {
		mannequins = new Mannequin[0];
	}
	
	public void addMannequin(Mannequin mannequin) {
		Mannequin[] temp = new Mannequin[this.mannequins.length + 1];
		
		for (int i = 0; i < this.mannequins.length; i++)
			temp[i] = this.mannequins[i];
		
		temp[temp.length-1] = mannequin;
		this.mannequins = temp;
	}
	
	public void removeMannequin(int id) {
		Mannequin[] temp = new Mannequin[this.mannequins.length - 1];
		boolean hasFoundWear = false;
		
		for (int i = 0; i < temp.length; i++) {
			if (this.mannequins[i].getId() != id) {
				temp[hasFoundWear ? i - 1 : i] = this.mannequins[i];
			} else {
				hasFoundWear = true;
			}
		}
		
		this.mannequins = temp;
	}
	
	public Mannequin getMannequin(int index) {
		return this.mannequins[index];
	}
	
	public Mannequin[] getMannequns() {
		return this.mannequins;
	}
	
	public int getAmountOfMannequins() {
		return mannequins.length;
	}
}
