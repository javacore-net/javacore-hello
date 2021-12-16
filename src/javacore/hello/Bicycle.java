package javacore.hello;

interface Bike {
	void changeCadence(int newValue);
	void changeModel(String modelName);
}

public class Bicycle implements Bike{
	int cadence = 0;
	int speed = 0;
	int gear = 1;
	
	
	public void changeCadence(int newValue) {
		this.cadence = newValue;
	}
	
	void changeGear(int newValue) {
		this.gear = newValue;
	}
	
	void speedUp(int increment) {
		this.speed += increment;
	}
	
	void applyBrakes(int decrement) {
		this.speed -= decrement;
	}
	
	void printStates() {
		System.out.printf("Cadence: %d, Gear: %d, Speed: %d\n", this.cadence, this.gear, this.speed);
	}

	@Override
	public void changeModel(String modelName) {
		// TODO Auto-generated method stub
		
	}
}
