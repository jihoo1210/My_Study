package stream.stream_c;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example {
    public static void main(String[] args) {
        List<Member> list = Arrays.asList(
            new Member("홍길동", "개발자"),
            new Member("김나리", "디자이너"),
            new Member("박지후", "개발자")
        );
        List<Member> developers = list
        .stream()
        // 직업이 개발자인 객체만 리턴
        .filter(s -> {return s.getJob().equals("개발자");})
        // 리턴된 객체를 리스트에 저장
        .collect(Collectors.toList());

        developers
        .stream()
        .forEach(m -> System.out.println(m.getName()));
    }
}
