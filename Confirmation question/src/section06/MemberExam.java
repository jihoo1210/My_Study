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
			System.out.println("로그인 되었습니다.");
			return true;
		} else {
			System.out.println("로그인에 실패하였습니다.");
			return false;
		}
	}
	
	void logout (String id) {
		System.out.println(id + "님이 로그아웃 되었습니다.");
	}
}
