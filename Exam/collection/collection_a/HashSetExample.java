package collection.collection_a;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {

    public static void main(String[] args) {
        Set<Student> set = new HashSet<>();

        set.add(new Student(1, "홍길동1"));
        set.add(new Student(2, "홍길동2"));
        set.add(new Student(1, "홍길동3"));

        System.out.println("저장된 객체 수: " + set.size());
        for(Student s : set) {
            System.out.println(s.StudentNum + ":" + s.name);
        }
    }
}