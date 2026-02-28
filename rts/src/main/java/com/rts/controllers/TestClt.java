package com.rts.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rts.service.TestService;


@RestController
@RequestMapping("/testCtl")
@CrossOrigin(origins = "http://localhost:4200/RTS")
public class TestClt { 
    @Autowired
  private TestService service;
    @GetMapping("/test")
    public Map<String,String> get(){
        
        return  Map.of("message", "RTSBackend");
    }
        @GetMapping("/getAll")
    public List<Map<String,Object>> getAll(){
       List<Map<String,Object>> l= service.getAllUsers();
        return l;
    }
   @PostMapping("")
public String post(@RequestParam String name ){
    return name;
}
}
