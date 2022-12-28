package com.fixingsolutions.serviceOrder.controller;

import com.fixingsolutions.employee.dto.request.CreateEmployeeRequest;
import com.fixingsolutions.employee.dto.request.UpdateEmployeeRequest;
import com.fixingsolutions.employee.dto.response.EmployeeResponse;
import com.fixingsolutions.employee.entity.Employee;
import com.fixingsolutions.employee.service.EmployeeService;
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

    @PostMapping("/createServiceOrder")
    public ServiceOrderResponse createServiceOrder(@Valid @RequestBody CreateSORequest request) throws Exception {
        return serviceOrderService.createServiceOrder(request);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        serviceOrderService.deleteServiceOrder(id);
    }

    @PostMapping("/editServiceOrder")
    public ServiceOrderResponse editServiceOrder(@Valid @RequestBody UpdateSORequest request) throws Exception {
        return serviceOrderService.update(request);
    }
}
