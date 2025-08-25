package collection.collection_c;

public class Student implements Comparable<Student>{
    String id;
    int score;

    public Student(String id, int score) {
        super();
        this.id = id;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        int score = o.score;
        if(score > this.score){return -1;}
        else if(score == this.score) {return 0;}
        else return 1;
    }
}
