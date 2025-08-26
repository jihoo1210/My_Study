package lambda_expressions.lambda_e;

public class Example {
    private static Student[] students = {
        new Student("홍길동", 90, 96),
        new Student("박지후", 95, 93)
    };

    public static double avg(Function<Student> fun) {
        double sum = 0;
        for(Student item : students) {
            sum += fun.apply(item);
        }
        return sum / students.length;
    }
    public static void main(String[] args) {
        double engAvg = avg( Student :: getEngScore );
        System.out.println("평균 영어 점수: " + engAvg);

        
        double mathAvg = avg( Student :: getMathScore );
        System.out.println("평균 수학 점수: " + mathAvg);
    }
}
