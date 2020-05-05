package com.rest.webservice.restfulwebservice.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@RestController
public class HelloWordController {

    @Autowired
    private MessageSource messageSource;
    //GET
    //POST
    //method Hello word
   // @RequestMapping(Method= RequestMethod.GET,path="/hello-world")

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

//    @GetMapping("/hello-world-internationalized")
//    public HelloWorldBean in18(@RequestHeader(name="Accept-Language",required=false) Locale locale){
//
//        return new HelloWorldBean(messageSource.getMessage("good.morning.message",null,locale));
//    }
//Above one also working be below one simple way to doing
    @GetMapping("/hello-world-internationalized")
    public HelloWorldBean in18(Locale locale){
        return new HelloWorldBean(messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale()));
    }


    @GetMapping("/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World %s",name));
    }

}
