package com.fixingsolutions.userDetails;

import com.fixingsolutions.employee.entity.Employee;
import com.fixingsolutions.userDetails.entity.UserDetailsImpl;

public class UserDetailsMapper {

    public static UserDetailsImpl buildUserDetailsImpl(Employee employee) {
        return UserDetailsImpl.builder()
                .employee(employee)
                .build();
    }

}
