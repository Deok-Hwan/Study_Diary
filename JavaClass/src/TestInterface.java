/**
 * 
 * Ambiguous 애매모호한 에러
 *
 */
public class TestInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
interface ProductInterface{
	public abstract void displayProductInfo();
}
class Product
{
	String company;
	String name;
	int price;
	public Product(String company, String name, int price) {
		super();
		this.company = company;
		this.name = name;
		this.price = price;
	}
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	void displayProductInfo(){
		
	}
}
class Television extends Product
{
	int inchSize;
	public Television() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Television(String company, String name, int price, int inchSize) {
		super(company, name, price);
		this.inchSize = inchSize;
	}
	@Override
	void displayProductInfo(){
		
	}
}

class Computer extends Product
{
	int hddSize;
	int memorySize;
	public Computer(int hddSize, int memorySize) {
		super();
		this.hddSize = hddSize;
		this.memorySize = memorySize;
	}
	public Computer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	void displayProductInfo(){
		
	}
	
}