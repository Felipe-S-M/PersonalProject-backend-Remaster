package com.fixingsolutions.authority.controller;

import com.fixingsolutions.authority.dtos.request.CreateAuthorityRequest;
import com.fixingsolutions.authority.dtos.request.UpdateAuthorityRequest;
import com.fixingsolutions.authority.entity.Authority;
import com.fixingsolutions.authority.service.AuthorityService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/authority")
@Secured("ROLE_ADMIN")
public class AuthorityController {

    private AuthorityService authorityService;

    @GetMapping("/findAll")
    public List<Authority> findAll() {
        return authorityService.findAll();
    }

    @PostMapping("/createEmployee")
    public Authority createEmployee(@Valid @RequestBody CreateAuthorityRequest request) {
        return authorityService.createAuthority(request.getRole());
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        authorityService.delete(id);
    }

    @PostMapping("/editEmployee")
    public Authority updateEmployee(@Valid @RequestBody UpdateAuthorityRequest request) {
        return authorityService.updateAuthority(request.getRole(), request.getId());
    }
}
