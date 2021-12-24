package javacore.hello;

// We have furniture store, their customers want to select tables and chairs, tablecloths, ... for their new house
// In our store, we can separate product into collection: classical vs modern
// When user select a classical chair, we should only suggest the tables that belongs to classical collection

public class AbstractFactory {
	public static void demo() {
		System.out.println("Demo of Abstract Factory Pattern");
		FurnitureCollection c = new ModernFurnitureCollection();
		Product chair = c.getRandomChair();
		System.out.println(chair.getName() + chair.getPrice() + chair.getProductId());
		
		FurnitureCollection cc = new ClassicalFurnitureCollection();
		Product cChair = cc.getRandomChair();
		System.out.println(cChair.getName() + cChair.getPrice() + cChair.getProductId());		
	}
}

enum Collection {
	Classical,
	Modern
};

interface Product {
	public String getName();
	public String getProductId();
	public String getPrice();
	public String getCollection();
}

abstract class Chair implements Product{
	protected String productId;
	protected String name;
	protected int price;
	protected Collection collection;
	public Chair(String productId, String name, int price, Collection collection ) {
		this.productId = productId;
		this.name = name;
		this.price = price;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public String getProductId() {
		// TODO Auto-generated method stub
		return this.productId;
	}

	@Override
	public String getPrice() {
		// TODO Auto-generated method stub
		return String.valueOf(this.price) + " VND";
	}

	@Override
	public String getCollection() {
		// TODO Auto-generated method stub
		if (this.collection == Collection.Classical) {
			return "Classical";
		}
		if (this.collection == Collection.Modern) {
			return "Modern";
		}
		return "";
	}	
}

class ModernChair extends Chair{

	public ModernChair(String productId, String name, int price) {
		super(productId, name, price, Collection.Modern);
		// TODO Auto-generated constructor stub
	}	
}

class ClassicalChair extends Chair{

	public ClassicalChair(String productId, String name, int price) {
		super(productId, name, price, Collection.Classical);
		// TODO Auto-generated constructor stub
	}	
}


interface FurnitureCollection {
	public Product getRandomChair();
}

class ModernFurnitureCollection implements FurnitureCollection{

	@Override
	public Product getRandomChair() {
		// TODO Auto-generated method stub
		return new ModernChair("CHAIR001-Modern", "Chair 001", 1000000);
	}
	
}

class ClassicalFurnitureCollection implements FurnitureCollection{

	@Override
	public Product getRandomChair() {
		// TODO Auto-generated method stub
		return new ClassicalChair("CHAIR002-Classical", "Chair 002", 2000000);
	}
	
}
