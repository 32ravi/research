package reflection;

public class RentCar {

	private int rate;
	private String carType;
	public int price;

	public RentCar(int length) {
		if (length < 455) {
			carType = "small";
			rate = 35;
		} else if ((length >= 455) && (length < 495)) {
			carType = "mid-sized";
			rate = 45;
		} else if (length >= 495) {
			carType = "large";
			rate = 55;
		}
	}


	public int getRate() {
		return rate;
	}

	public String getType() {
		return carType;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public void setType(String type) {
		this.carType = type;
	}

	public void computeRentalCost(int numDays) {
		price = numDays * rate;
		System.out
				.println("The cost of your rental car is " + price + " euros");
	}
}