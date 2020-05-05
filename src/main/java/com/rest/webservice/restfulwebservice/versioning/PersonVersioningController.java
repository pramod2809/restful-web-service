package com.rest.webservice.restfulwebservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    //versioning with request params
    @GetMapping("v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Pramod");

    }

    @GetMapping("v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Pramod","Narnaware"));

    }


    //versioning with Param
    @GetMapping(value="person/param",params ="version=1")
    public PersonV1 paramV1(){
        return new PersonV1("Pramod");

    }

    @GetMapping(value="/person/param",params ="version=2")
    public PersonV2 paramV2(){
        return new PersonV2(new Name("Pramod","Narnaware"));

    }

    //versioning with Headers
    @GetMapping(value="person/h",headers ="X-API-VERSION=1")
    public PersonV1 headersV1(){
        return new PersonV1("Pramod");

    }

    @GetMapping(value="/person/h1",headers ="X-API-VERSION=2")
    public PersonV2 headersV2(){
        return new PersonV2(new Name("Pramod","Narnaware"));

    }

    //versioning with Headers
    @GetMapping(value="person/produce",produces ="application/vnd.company.app-v1+json")
    public PersonV1 producesV1(){
        return new PersonV1("Pramod");

    }

    @GetMapping(value="/person/produce",produces ="application/vnd.company.app-v2+json")
    public PersonV2 producesV2(){
        return new PersonV2(new Name("Pramod","Narnaware"));

    }
}
