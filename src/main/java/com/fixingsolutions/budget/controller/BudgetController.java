package com.fixingsolutions.budget.controller;

import com.fixingsolutions.budget.dtos.request.CreateBudgetRequest;
import com.fixingsolutions.budget.dtos.request.UpdateBudgetRequest;
import com.fixingsolutions.budget.dtos.response.BudgetResponse;
import com.fixingsolutions.budget.service.BudgetService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Secured("ROLE_ADMIN")
@RequestMapping("/budget")
@RestController
public class BudgetController {
    private BudgetService budgetService;

    @GetMapping("/findAll")
    public List<BudgetResponse> findAll() {
        return budgetService.findAll();
    }

    @PostMapping("/create")
    public BudgetResponse create(
            @RequestBody CreateBudgetRequest request,
            @RequestHeader("authorization") String authToken
    ) throws Exception {
        return budgetService.create(request, authToken);
    }

    @PostMapping("/update")
    public BudgetResponse update(@RequestBody UpdateBudgetRequest request) throws Exception {
        return budgetService.update(request);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        budgetService.delete(id);
    }
}
