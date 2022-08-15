package com.fixingsolutions.serviceOrder.dto.request;

import com.fixingsolutions.serviceOrder.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateSORequest {
    private Long id;
    private Long budgetId;
    private String name;
    private Status status;
}
