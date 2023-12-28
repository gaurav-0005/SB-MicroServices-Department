package com.test.microservices.department.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Department")
@Builder
public class DepartmentEntity {


    public Long departmentId;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

}
