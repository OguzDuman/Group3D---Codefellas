package com.example.pandemikent.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pandemikent.Service.SeleniumService;

@RestController
public class SeleniumController {
	
	@Autowired
	SeleniumService seleniumService;

	@GetMapping("/seleniumTest")
	   public @ResponseBody String getRiskStatus(@RequestHeader String tc, @RequestHeader String passw, @RequestHeader String hes) throws IOException {
	 	  return seleniumService.getRiskStatus(tc, passw, hes);
	   }
}
