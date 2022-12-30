package com.fixingsolutions.serviceOrder.dto.request;

import com.fixingsolutions.serviceOrder.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateSORequest {
    @NotNull(message = "Id cannot be null")
    private Integer id;
    @NotNull(message = "Budget cannot be null")
    private Integer budgetId;
    @NotNull(message = "Name cannot be null")
    private String name;
    @NotNull(message = "Status cannot be null")
    private Status status;
}
