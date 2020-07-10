
public class Color<R, G, B> {
	R red;
	G green;
	B blue;
	public Color() {
	}
	public Color(R red, G green, B blue) {
		this.red=red;
		this.green=green;
		this.blue=blue;
	}
	R getR(){
		return red;
	}
	
	G getG(){
		return green;
	}
	
	B getB(){
		return blue;
	}
}
