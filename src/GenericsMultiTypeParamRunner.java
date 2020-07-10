
public class GenericsMultiTypeParamRunner {
	public static void main(String[] args) {
		System.out.println("Generics Tutorial");
		Juice juice=new Juice();
		Glass<Juice> glassOfJuice= new Glass<>(juice);
		Tray<Juice> tray=new Tray<>();
		tray.add(glassOfJuice);
		tray.add(new Glass<Water>(new Water()));
		Red red=new Red();
		Green green=new Green();
		Blue blue=new Blue();
		Color<Red,Green,Blue> color=new Color<>(red,green,blue);
		color.getR().show();
		color.getG().show();
		color.getB().show();	
	}
}
