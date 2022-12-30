package com.fixingsolutions.serviceOrder.controller;

import com.fixingsolutions.serviceOrder.dto.request.CreateSORequest;
import com.fixingsolutions.serviceOrder.dto.request.UpdateSORequest;
import com.fixingsolutions.serviceOrder.dto.response.ServiceOrderResponse;
import com.fixingsolutions.serviceOrder.entity.ServiceOrder;
import com.fixingsolutions.serviceOrder.service.ServiceOrderService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/serviceOrder")
@Secured("ROLE_ADMIN")
public class ServiceOrderController {
    private ServiceOrderService serviceOrderService;

    @GetMapping("/findAll")
    public List<ServiceOrder> findAll() {
        return serviceOrderService.findAll();
    }

    @PostMapping("/create")
    public ServiceOrderResponse create(@Valid @RequestBody CreateSORequest request) throws Exception {
        return serviceOrderService.createServiceOrder(request);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        serviceOrderService.deleteServiceOrder(id);
    }

    @PostMapping("/edit")
    public ServiceOrderResponse edit(@Valid @RequestBody UpdateSORequest request) throws Exception {
        return serviceOrderService.update(request);
    }
}
