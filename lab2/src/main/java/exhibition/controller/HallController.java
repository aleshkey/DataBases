package exhibition.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/halls")
public class HallController {
    @GetMapping()
    public String index(){
        return "index";
    }
}