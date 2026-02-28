package com.rts.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.rts.pojo.User;
import com.rts.utility.Constant;
import com.rts.utility.ResponseData;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping(path = Constant.USERCTL)
public class UserCtl extends BaseCtl {
    @GetMapping("/getUser")
    @ResponseBody
    public ResponseEntity<ResponseData<User>> getMethodName() {
        System.out.println("user controller");
        User user=new User();
        ResponseData<User> response = new ResponseData<>();
        response.setData(user);
        response.setMsg(Constant.SUCCESS);
        response.setList(null);  
        return  ResponseEntity.ok(response);
    }
    @PostMapping("/addOrUpdateUser")
    public ResponseData<User> postMethodName(@RequestBody ResponseData<User> req) {
        
        System.out.println("user controller");
        return req;
    }
    
    

}
