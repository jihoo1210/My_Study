package section06;

public class ShopServiceExamRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShopServiceExam shop1 = ShopServiceExam.getInstance();
		ShopServiceExam shop2 = ShopServiceExam.getInstance();
		if(shop1 != shop2) {
			System.out.println("���� �ٸ� ��ü�� �����մϴ�.");
		} else {
			System.out.println("���� ������ ��ü�� �����մϴ�.");
		}
	}

}
