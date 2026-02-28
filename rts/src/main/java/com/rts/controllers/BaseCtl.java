package com.rts.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

import com.rts.utility.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller // do not use restController here otherwise it will return response
@RequestMapping(path = Constant.BASECTL)
public class BaseCtl {
   @GetMapping
   public String handleGetMethods(@RequestHeader("X-Target-Resource") String target) {
    if(!target.isEmpty() || target.length()>0){
        System.out.println("url=======> "+target);
       return "forward:"+target; 
    }
       return "";
   }
  
    @PostMapping
    public String handlePostMethods(@RequestHeader("X-Target-Resource") String target){     
      if(!target.isEmpty() || target.length()>0){
        System.out.println("url=======> "+target);
       return "forward:"+target; 
    }
       return "";
    }


}
