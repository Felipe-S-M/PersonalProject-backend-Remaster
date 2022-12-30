package com.fixingsolutions.serviceType.controller;

import com.fixingsolutions.serviceOrder.dto.request.UpdateSORequest;
import com.fixingsolutions.serviceOrder.dto.response.ServiceOrderResponse;
import com.fixingsolutions.serviceType.dto.request.CreateServiceTypeRequest;
import com.fixingsolutions.serviceType.dto.request.UpdateServiceTypeRequest;
import com.fixingsolutions.serviceType.dto.response.ServiceTypeResponse;
import com.fixingsolutions.serviceType.entity.ServiceType;
import com.fixingsolutions.serviceType.service.ServiceTypeService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/serviceType")
@Secured("ROLE_ADMIN")
public class ServiceTypeController {
    private ServiceTypeService serviceTypeService;

    @GetMapping("/findAll")
    public List<ServiceType> findAll() {
        return serviceTypeService.findAll();
    }

    @PostMapping("/create")
    public ServiceTypeResponse create(
            @Valid @RequestBody CreateServiceTypeRequest request) {
        return serviceTypeService.createServiceType(request);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        serviceTypeService.delete(id);
    }

    @PostMapping("/edit")
    public ServiceTypeResponse edit(
            @Valid @RequestBody UpdateServiceTypeRequest request) throws Exception {
        return serviceTypeService.update(request);
    }
}
