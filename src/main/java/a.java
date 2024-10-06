
public class CarInfo {
	private String id;
	private boolean privateCar;
	private int speed;
	
	public boolean illegal(int maxSpeed) {
		if (this.privateCar == true)
			return true;
		if (this.speed> maxSpeed)
			return true;
		else
			return false;
	}

}


class CameraInfo {
	private int city;
	private int maxSpeed;
	private CarInfo [] cars;
	
	public boolean allGood(){
		for (int i =0; i<cars.length;i++){
			if (cars[i].illegal(maxSpeed)==true)
				return false;	
		}
		return true;
	}
}



public class Main {
	public int legalCities(CameraInfo [] cameras) {
		for (int i=0;i<cameras.length;i++) {
			for (int j=i;j<cameras.length;j++) {
			}
		}
	}
}



