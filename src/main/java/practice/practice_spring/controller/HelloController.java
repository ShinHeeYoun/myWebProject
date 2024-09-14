package practice.practice_spring.controller;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!!");
        return "hello"; // hello.html을 찾아서 실행시켜라
        // 컨트롤러에서 리턴 값을 문자를 반환하면 viewResolver가 화면을 찾아서 처리
        // (resource:templates/ + (ViewName) + .html
        // 그러면 hello.html 에서 여기 있는 data-hello!!! 값을 가져다 넣음
        
        // "hello" url에 매칭이 됨 (http://localhost:8080/hello)


    }
}
