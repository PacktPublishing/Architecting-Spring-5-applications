
public class Rider {
	Bike b;
	public void setBike(Bike b) {
		this.b = b;
	}
	void ride(){
		b.start();
	}
}
