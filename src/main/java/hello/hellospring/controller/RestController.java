package hello.hellospring.controller;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;
@org.springframework.web.bind.annotation.RestController
public class RestController {
    @GetMapping("/showMe")
    public List<String> hello() {
        return Arrays.asList("첫번째 인사", "두번째 인사");
    }

}
