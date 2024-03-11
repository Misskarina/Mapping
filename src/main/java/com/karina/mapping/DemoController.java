package com.karina.mapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services")
public class DemoController {
	
	@Autowired
	DemoRepository drepo;
	
	@RequestMapping("/loan")
	public String use()
	{
		return"data loan";
	}
	
	@RequestMapping("/emi")
	public String show()
	{
		return"data emi";
	}
	
	@RequestMapping("/payment")
	public String useby()
	{
		return"data payment";
	}
	
	 @RequestMapping("/save")
	 public String save()
	 {
		 Demo d=new Demo();
		 d.setName("karina");
		 d.setUsername("miss");
		 
		 BCryptPasswordEncoder p = new BCryptPasswordEncoder();
		 String message=p.encode("hello password");
		 d.setPassword(message);
		 
		 drepo.save(d);
		 return"data is save";
	 }
	 
	 @RequestMapping("/all")
	 public List<Demo> all()
	 {
		 return drepo.findAll();
	 }
			
			
}
