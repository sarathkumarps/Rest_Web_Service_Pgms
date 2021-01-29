package com.sarath.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	//f1,f2
	@GetMapping("/filtering")
	public MappingJacksonValue retrieveSomeBean()
	{
		SomeBean s1=new SomeBean("Emp1","Naveen","Password1");
		

		SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("name1","name2");
		FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		MappingJacksonValue mapping=new MappingJacksonValue(s1);
		mapping.setFilters(filters);
		return mapping;
	}
	
	//f2,f3
	@GetMapping("/filtering-list")
	public MappingJacksonValue retrieveListSomeBean()
	{
		List <SomeBean> list= Arrays.asList(new SomeBean("Emp1","Naveen","Password1"),new SomeBean("Emp2","Sarath","Password2"));
		SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("name1","name2");
		FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		MappingJacksonValue mapping=new MappingJacksonValue(list);
		mapping.setFilters(filters);
		return mapping ;
	}


}
