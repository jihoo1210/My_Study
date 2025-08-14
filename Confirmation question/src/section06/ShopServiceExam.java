package section06;

public class ShopServiceExam {
	private static ShopServiceExam shop = new ShopServiceExam();
	
	private ShopServiceExam() {};
	
	public static ShopServiceExam getInstance() {
		return shop;
	}
}
