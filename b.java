public class CarInfo {
	private String id;
	private boolean privateCar;
	private int speed;
	
	public boolean illegal(int maxSpeed) {
		if (this.speed> maxSpeed)
			return true;
		if (this.privateCar)
			return true;
		else
			return false;
	}
	
	public CarInfo(String id, boolean privateCar, int speed) {
		this.id = id;
		this.privateCar = privateCar;
		this.speed = speed;
	}
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public String getId() {
		return id;
	}
	public boolean isPrivateCar() {
		return privateCar;
	}

}


public class CameraInfo {
	private int city;
	private int maxSpeed;
	private CarInfo [] cars;
	

	
	public CameraInfo(int city, int maxSpeed, CarInfo[] cars) {
		this.city = city;
		this.maxSpeed = maxSpeed;
		this.cars = cars;
	}
	
	public boolean allGood(){
		for (int i =0; i<cars.length;i++){
			if (cars[i].illegal(maxSpeed))
				return false;	
		}
		return true;
	}
	public int getCity() {
		return city;
	}
	
	public int getMaxSpeed() {
		return maxSpeed;
	}	
}


class Main {
	public static int legalCities(CameraInfo[] cameras) {
		int count = 0;
		for (int i = 0; i < cameras.length; i++) {
			if (cameras[i] != null && cameras[i].allGood()) {
				for (int j = i + 1; j < cameras.length; j++) {
					if (cameras[j] != null && cameras[j].allGood() && cameras[i].getCity() != cameras[j].getCity()) {
						count++;
					}
				}
			}
		}
		return count;

	}

	public static void main(String[] args) {
		CarInfo[] cars1 = new CarInfo[2];
		cars1[0] = new CarInfo("c10", true, 90);
		cars1[1] = new CarInfo("c11", false, 120);

		CarInfo[] cars2 = new CarInfo[2];
		cars2[0] = new CarInfo("c20", false, 45);
		cars2[1] = new CarInfo("c21", false, 50);

		CameraInfo[] cameras = new CameraInfo[200];
		cameras[0] = new CameraInfo(12, 110, cars1);
		cameras[1] = new CameraInfo(12, 50, cars2);

		int good = legalCities(cameras);
		System.out.println(good);
	}

}

