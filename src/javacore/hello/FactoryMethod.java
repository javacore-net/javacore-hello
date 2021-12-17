package javacore.hello;

import javacore.hello.Subscription.SubscriptionType;

public class FactoryMethod {
	public static void example() {
		System.out.println("Factory Method Demo!");
		Subscription sub1 = Subscription.SubscriptionFactory(SubscriptionType.PERSONAL);
		Subscription sub2 = Subscription.SubscriptionFactory(SubscriptionType.BUSINESS);
		Subscription sub3 = Subscription.SubscriptionFactory(SubscriptionType.ENTERPRISE);
		// total price
		double totalPrice = sub1.getPrice() + sub2.getPrice() +sub3.getPrice();
		System.out.printf("Total price: %1.2f\n", totalPrice);
	}
}

abstract class Subscription
{
	protected String currency = "USD";
	public abstract double getPrice();
	
	public enum SubscriptionType {
		PERSONAL,
		BUSINESS,
		ENTERPRISE
	}
	
	public static Subscription SubscriptionFactory(SubscriptionType type) {
		if(type == SubscriptionType.PERSONAL) {
			return new Personal();
		}
		if(type == SubscriptionType.BUSINESS) {
			return new Business();
		}
		if(type == SubscriptionType.ENTERPRISE) {
			return new Enterprise();
		}		
		
		return null;
	}
}

class Personal extends Subscription{
	private double price = 10.5; // USD
	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return this.price;
	}
}

class Business extends Subscription{
	private double price = 21.0; //USD
	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return this.price;
	}
}

class Enterprise extends Subscription{
	private double price = 42.0; //USD
	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return this.price;
	}
}
