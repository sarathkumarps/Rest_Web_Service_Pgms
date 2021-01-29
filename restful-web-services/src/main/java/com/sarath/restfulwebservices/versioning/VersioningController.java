package com.sarath.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {


	@GetMapping(value="v1/person")
	public PersonV1 personV1()
	{
		return new PersonV1("Sarath Kumar");
	}

	@GetMapping(value="v2/person")
	public PersonV2 personV2()
	{
		return new PersonV2(new Name("Sarath", "Kumar"));
	}
	
	
	
	@GetMapping(value="person/param",params="version=1")
	public PersonV1 paramV1()
	{
		return new PersonV1("Sarath Kumar");
	}

	@GetMapping(value="person/param",params="version=2")
	public PersonV2 paramV2()
	{
		return new PersonV2(new Name("Sarath", "Kumar"));
	}
	
	
	@GetMapping(value="person/headers",headers="X-API-VERSION=1")
	public PersonV1 headerV1()
	{
		return new PersonV1("Sarath Kumar");
	}

	@GetMapping(value="person/headers",headers="X-API-VERSION=2")
	public PersonV2 headerV2()
	{
		return new PersonV2(new Name("Sarath", "Kumar"));
	}

}
