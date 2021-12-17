package javacore.hello;

import java.util.HashMap;

import javacore.hello.LocalizerFactory.SupportLanguage;
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
		Localizer enLoc = LocalizerFactory.createLocalizer(SupportLanguage.English);
		System.out.printf("%s is %s", "patterns/factoryMethod/name\n", enLoc.localize("patterns/factoryMethod/name"));
		System.out.printf("%s is %s", "patterns/factoryMethod/description\n", enLoc.localize("patterns/factoryMethod/description"));
		Localizer vnLoc = LocalizerFactory.createLocalizer(SupportLanguage.Vietnamese);
		System.out.printf("%s is %s", "patterns/factoryMethod/name\n", vnLoc.localize("patterns/factoryMethod/name"));
		System.out.printf("%s is %s", "patterns/factoryMethod/description\n", vnLoc.localize("patterns/factoryMethod/description"));
	}
}

// Interface
interface Localizer{
	public String localize(String key);
}

// Concrete A
class VietnameseLocalizer implements Localizer{
	HashMap<String, String> translations = new HashMap<String, String>();
	public VietnameseLocalizer() {
		this.translations.put("patterns/factoryMethod/name", "Factory(VN)");
		this.translations.put("patterns/factoryMethod/description", 
				"Là giải pháp cho phép client sử dụng 1 interface/abstract class tạo ra các phiên bản khác nhau của subclass");
	}
	public String localize(String key){
		return this.translations.get(key);
	}
}

//Concrete B
class EnglishLocalizer implements Localizer{
	HashMap<String, String> translations = new HashMap<String, String>();
	public EnglishLocalizer() {
		this.translations.put("patterns/factoryMethod/name", "Factory(EN)");
		this.translations.put("patterns/factoryMethod/description", 
				"A solution to allow client can use an interface/abstract to create different version of subclass");
	}
	public String localize(String key){
		return this.translations.get(key);
	}
}

// Creator
abstract class LocalizerFactory{
	enum SupportLanguage {
			Vietnamese,
			English
	};
	public static Localizer createLocalizer(SupportLanguage language) {
		if(language == SupportLanguage.English) {
			return new EnglishLocalizer();
		}
		// default language is Vietnamese
		return new VietnameseLocalizer();
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
