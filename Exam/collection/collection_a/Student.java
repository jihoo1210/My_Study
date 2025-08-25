package collection.collection_a;

public class Student {

    public int StudentNum;
    public String name;

    public Student(int StudentNum, String name) {
        super();
        this.StudentNum = StudentNum;
        this.name = name;
    }

    @Override
    public int hashCode() {
    return StudentNum;
    }

    @Override
    public boolean equals(Object name) {
        // Student 또는 Student의 자식 클래스로 생성된 객체가 아니면 false
        if(!(name instanceof Student)) {return false;};
        // Object로 자동 타입 변환된 name을 다시 Student 타입으로 강제 변환
        // StudentNum을 사용하기 위해서
        Student student = (Student) name;
        // StudentNum이 다르다면 false
        if(student.StudentNum != this.StudentNum) {return false;}
        // Student 객체이고 StudentNum이 같다면 true
        return true;
    }
}