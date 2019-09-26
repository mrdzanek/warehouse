package pl.myro.warehouse.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public static String sayHi() {
        return "Hello world!";
    }

}
