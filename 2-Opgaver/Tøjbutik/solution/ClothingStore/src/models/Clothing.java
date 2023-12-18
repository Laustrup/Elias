package models;

public class Clothing {

	private Type type;
	private Material material;
	private String brand,
		model;
	
	public Clothing(Type type, Material material, String brand, String model) {
		super();
		this.type = type;
		this.material = material;
		this.brand = brand;
		this.model = model;
	}

	public Type getType() {
		return type;
	}

	public Material getMaterial() {
		return material;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public enum Material {
		LEATHER,
		RUBBER,
		POLYESTER,
		DENIM
	}
	
	public enum Type {
		HEAD_WEAR,
		TOP,
		PANTS
	}
	
	@Override
	public String toString() {
		return brand + " - " + model;
	}
}
