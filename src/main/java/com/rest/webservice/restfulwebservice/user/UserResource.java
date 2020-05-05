package com.rest.webservice.restfulwebservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService userDoaService;

    //GET /users
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userDoaService.findAll();
    }

    @GetMapping("/users/{id}")
    public  Resource<User>  retrieveUsers(@PathVariable int id){

        User user=userDoaService.findOne(id);
        if(user==null){
            throw new UserNotFoundException("id- " +id);
        }

        //HATEOAS
        Resource<User> resource=new Resource<User>(user);
        ControllerLinkBuilder linkTo=linkTo(methodOn(this.getClass()).retrieveAllUsers());
        resource.add(linkTo.withRel("all-users"));
        return resource;

    }
    //POST /users
    // CREATED
    //input details of user
    //output CREATED & return code
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody  User user){
        User savedUser=userDoaService.save(user);

        URI location= ServletUriComponentsBuilder.fromCurrentRequest().
            path("/{id}").buildAndExpand(savedUser.getId()).toUri();

       return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUsers(@PathVariable int id){

        User user=userDoaService.deleteById(id);
        if(user==null){
            throw new UserNotFoundException("id- " +id);
        }
    }
}
