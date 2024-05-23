package com.ivoronline.springboot_database_namedparameterjdbctemplate_mix.controllers;

import com.ivoronline.springboot_database_namedparameterjdbctemplate_mix.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  //PROPERTIES
  @Autowired private MyService myService;

  //=========================================================================================================
  // MIX STATEMENTS
  //=========================================================================================================
  @ResponseBody
  @GetMapping("/mixedStatements")
  public int mixedStatements() {
    int    success = myService.mixedStatements("Jill", 40, "John New", "John");
    return success;
  }

}

