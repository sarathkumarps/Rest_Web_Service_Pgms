package com.sarath.restfulwebservices.user;

import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

 

@RestController
public class UserResources  {
	
	
	@Autowired
	private UserDaoService service;
	
	//GET /users
	//retrieveAllUsers
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers()
	{
		return service.findAll();
	}
	
	//GET /users/{id}
	//retrieveUser
	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id)
	{
		User user=service.findOne(id);
		
		
		//HATEAOS
//		Resource<User> resource=new Resource<User>(user);
//		ControllerLinkBuilder linkTo=(methodOn());
				
//				resource.add(linkTo.withRel("all-users"));
		if(user==null)
			throw new UserNotFoundException("id-"+id); 
		return user;
	}
	
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id)
	{
		User user=service.deleteById(id);
		if(user==null)
			throw new UserNotFoundException("id-"+id); 
	
	}
	
	//CREATED
	//input -details
	//output -Created & Return URI
	
	@PostMapping("/users")
	public ResponseEntity createUser(@Valid @RequestBody User user)
	{
		User savedUser=service.save(user);
		//RETURN 
		//CREATED
		
		// user/ {id} savedUser.getId()
		URI location=ServletUriComponentsBuilder
			.fromCurrentRequest() //get current uri
			.path("/{id}") //appending
			.buildAndExpand(savedUser.getId()).toUri(); //replacing
		
	
		
		return ResponseEntity.created(location).build();
	}

}
