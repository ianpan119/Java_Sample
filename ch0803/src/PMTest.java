
public class PMTest {
	public static void main(String[] args) {		
	   System.out.println("�b�|5.0���ض�Φa�`��="+LandTrade.getTotPrice(1000, new Circle(5.0)));
	   System.out.println("���5.0���إ���Φa�`��="+LandTrade.getTotPrice(1000, new Square(5.0)));
	}
}
class Shape{
	public double getArea(){
		return 0.0;
	}
}
class Circle extends Shape{
	private double r;
	public Circle(double r){
		this.r = r;
	}
	public double getArea(){
		return 3.14*r*r;
	}
}
class Square extends Shape{
	private double s;
	public Square(double s){
		this.s = s;
	}
	public double getArea(){
		return s*s;
	}
}
class LandTrade{
	public static double getTotPrice(double unitPrice, Shape s){
		return unitPrice * s.getArea();
	}
}



