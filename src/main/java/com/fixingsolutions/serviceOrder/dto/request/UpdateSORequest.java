package com.fixingsolutions.serviceOrder.dto.request;

import com.fixingsolutions.serviceOrder.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateSORequest {
    private Integer id;
    private Integer budgetId;
    private String name;
    private Status status;
}
