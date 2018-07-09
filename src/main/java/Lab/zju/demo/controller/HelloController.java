package Lab.zju.demo.controller;

import Lab.zju.demo.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController
{
    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "/hello/{id}", method = RequestMethod.GET)
    public String say(@PathVariable("id") Integer myId){
        return "id: " + myId;
    }
    @PostMapping(value = "/hello")
    public String response(){
        return "post OK!";
    }
}
