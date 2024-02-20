package hello.hellospring.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class PortfolioController {
    @GetMapping("portfolio")
    public String portfolio(){
        return "portfolio";
    }
}
