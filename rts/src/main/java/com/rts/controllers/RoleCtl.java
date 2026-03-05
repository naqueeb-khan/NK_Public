package com.rts.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.rts.pojo.Role;
import com.rts.service.RoleService;
import com.rts.utility.Constant;
import com.rts.utility.ResponseData;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = Constant.ROLECTL)
public class RoleCtl extends BaseCtl {
    @Autowired
    private RoleService service;

    @GetMapping("/getRole")
    public ResponseData<Role> getMethod(@RequestParam(required = false, defaultValue = "0") String id) {
        ResponseData<Role> response = new ResponseData<>();

        int roleId = Integer.parseInt(id);
        if (roleId > 0) {
            Role role = new Role();
            role.setId(roleId);
            role = service.findById(role);
            if (role != null) {
                response.setMsg(Constant.SUCCESS);
                response.setData(role);
                return response;
            }
        } else {
            List<Role> list = service.findAll();
            if (list.size() > 0) {
                response.setMsg(Constant.SUCCESS);
                response.setList(list);
                return response;
            }
        }
        return response;
    }

    @PostMapping("/postRole")
    public ResponseData<Role> postMethod(@Valid @RequestBody Role role, BindingResult inputErrors) {
        ResponseData<Role> response = new ResponseData<>();
// Input Validations
        if(inputErrors.hasErrors()){
           Map<String, String> errors = new HashMap<>();
            inputErrors.getFieldErrors().forEach(error ->
                    errors.put(error.getField(), error.getDefaultMessage())
            );
            response.setInputErrors(errors);
            response.setMsg(Constant.INPUTERRORS);
            return response;
        }

        if (role != null) {
            if (role.getCommand().equalsIgnoreCase(Constant.ADD)
                    || role.getCommand().equalsIgnoreCase(Constant.UPDATE)) {
                role = service.saveOrUpdate(role);
                if (role.getId() > 0) {
                    response.setMsg(Constant.SUCCESS);
                    response.setData(role);
                    return response;
                }
            } else if (role.getCommand().equalsIgnoreCase(Constant.DELETE)) { 
                if (service.delete(role)) {
                    response.setMsg(Constant.SUCCESS);
                }
            }
        }
        return response;
    }
}
