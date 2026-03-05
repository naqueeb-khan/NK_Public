package com.rts.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.rts.pojo.User;
import com.rts.service.UserService;
import com.rts.utility.Constant;
import com.rts.utility.ResponseData;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = Constant.USERCTL)
public class UserCtl extends BaseCtl {
    @Autowired
    private UserService uService;

    @GetMapping("/getUser")
    public ResponseData<User> getMethod(@RequestParam(required = false, defaultValue = "0") String id) {
        ResponseData<User> response = new ResponseData<>();
        response.setMsg("Success");
        User user = new User();
        user.setId(Integer.parseInt(id));
     List<User> list= uService.findAll(user);
     response.setList(list);
     response.setData(user);
      response.setMsg("Success");  
        return response;
    }

    @PostMapping("/postUser")
    public ResponseData<User> postMethod(@RequestBody User user) {
        ResponseData<User> response = new ResponseData<>();

        return response;
    }

}
