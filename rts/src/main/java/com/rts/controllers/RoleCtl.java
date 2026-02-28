package com.rts.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.rts.pojo.Role;
import com.rts.utility.Constant;
import com.rts.utility.ResponseData;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping(path = Constant.ROLECTL)
public class RoleCtl extends BaseCtl {

    @GetMapping("/getRole")
    public ResponseData<Role> getMethodName(@RequestParam String param) {

        return new ResponseData<>();
    }
    

}
