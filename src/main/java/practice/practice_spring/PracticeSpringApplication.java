package practice.practice_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticeSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeSpringApplication.class, args);
	}

}

/*
 (1) 기타 정보
 resource/static/index.html이 기본 홈페이지로 설정됨
 https://docs.spring.io/spring-boot/index.html 여기서 검색을 할 줄 알아야 함

 (2) PowerShell 에서 ./gradelw build
 -> P:\CODE\spring practice\practice-spring\build\libs> java -jar .\practice-spring-0.0.1-SNAPSHOT.jar
 으로 실행 가능

 (3) 웹 개발 3가지 방법
 - 정적 컨텐츠
 - MVC + 템플릿 엔진
 - API


*/