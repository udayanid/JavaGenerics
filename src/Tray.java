
public class Tray <T> {
	public  void add(Glass<?> juice){
		System.out.println(juice.liquid.getClass().getName());
	}
}
