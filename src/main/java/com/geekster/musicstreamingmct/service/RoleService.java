package com.geekster.musicstreamingmct.service;


import com.geekster.musicstreamingmct.model.Role;
import com.geekster.musicstreamingmct.repo.IRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RoleService {

    @Autowired
    IRoleRepo roleRepo;

    @Autowired
    HeadAdminService headAdminService;
    public String addRole(Role role, String email) {
        if(headAdminService.isValidEmail(email)){
            roleRepo.save(role);
            return "Role added successfully";
        }else{
            return "You don't have access to add roles";
        }
    }

    public boolean validateUserRole(String email, Role role) {
        if((role.getRoleId()==1)){
            Pattern p = Pattern.compile("^.*@admin\\.com$");
            Matcher m = p.matcher(email);
            if( (m.find() && m.group().equals(email))){

                    return true;

            }else{
                return false;
            }
        }else{
                if(role.getRoleId()==2){
                    return true;
                }else{
                    return false;
                }
        }

    }

    public String getRole(String email) {
        if(headAdminService.isValidEmail(email)){
            roleRepo.findAll();
            return "Role added successfully";
        }else{
            return "You don't have access to add roles";
        }
    }
}
