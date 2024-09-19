package practice.practice_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!!");
        return "hello"; // hello.html을 찾아서 실행시켜라
    }
    // 컨트롤러에서 리턴 값을 문자를 반환하면 viewResolver가 화면을 찾아서 처리
    // (resource:templates/ + (ViewName) + .html
    // 그러면 hello.html 에서 여기 있는 data-hello!!! 값을 가져다 넣음
    // "hello" url에 매칭이 됨 (http://localhost:8080/hello)

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }
    // http://localhost:8080/hello-mvc?name=홍길동
    // hello 홍길동 <- 출력됨

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name, Model model){
        return "hello " + name;
    }
    // @ResponseBody =  body 부분에 이 데이터를 내가 직접 넣어주겠다
    // html 파일 필요 없이 직접 됨
    // http://localhost:8080/hello-mvc?name=홍길동
    // hello 홍길동 <- 출력됨
    // 그대로 body에 넣어지는 것

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    // Ctrl + shift + Enter 로 자동 완성 가능
    // API 방식
    // http://localhost:8080/hello-api?name=Spring!!
    // JSON 방식으로 표시됨 -> {"name":"Spring!!"}
    // @ResponseBody 사용시 기본적으로 JSON으로 반환됨

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        // Getter Setter
        // private으로 못 꺼내게 해놓고 클래스를 이용하여 꺼낸다
        // = property 접근 방식

    }
    // Alt+insert 단축키로 생성 --> Getter and Setter 생성
}

