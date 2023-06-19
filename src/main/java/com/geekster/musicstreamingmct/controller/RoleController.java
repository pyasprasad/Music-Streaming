package com.geekster.musicstreamingmct.controller;


import com.geekster.musicstreamingmct.dto.PlayListOutput;
import com.geekster.musicstreamingmct.model.Role;
import com.geekster.musicstreamingmct.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping("/{email}")
    public String addRole(@PathVariable String email , @RequestBody Role role){

        return roleService.addRole(role , email);
    }

}
