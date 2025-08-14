package section06;

public class ShopServiceExamRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShopServiceExam shop1 = ShopServiceExam.getInstance();
		ShopServiceExam shop2 = ShopServiceExam.getInstance();
		if(shop1 != shop2) {
			System.out.println("서로 다른 객체를 참조합니다.");
		} else {
			System.out.println("서로 동일한 객체를 참조합니다.");
		}
	}

}
