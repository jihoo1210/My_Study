package stream.stream_a;

import java.util.Arrays;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        // 불변 List 생성
        List<String> list = Arrays.asList(
            "this is a java book",
            "Lambda Expressions",
            "Java8 support lambda expressions"
        );
        list.stream()
        .filter(s -> { return s.toLowerCase().indexOf("java") > -1;})
        // 최종 처리 메소드: 각 요소에 람다식 적용
        .forEach(s -> System.out.println(s));
    }
}
