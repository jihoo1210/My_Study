package section06;

public class MemberExam {

	String name;
	String id;
	String pass;
	int age;
	
	public MemberExam(String name, String id, String pass, int age) {
		this.name = name;
		this.id = id;
		this.pass = pass;
		this.age = age;
	}
	
	public MemberExam(String name, String id) {
		this(name, id, "", 0);
	}
	
	boolean login(String name, String pass) {
		if(name.equals("hong") && pass.equals("12345")) {
			System.out.println("�α��� �Ǿ����ϴ�.");
			return true;
		} else {
			System.out.println("�α��ο� �����Ͽ����ϴ�.");
			return false;
		}
	}
	
	void logout (String id) {
		System.out.println(id + "���� �α׾ƿ� �Ǿ����ϴ�.");
	}
}
