package com.test.microservices.department.services;

import com.test.microservices.department.dto.DepartmentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DepartmentService {


      public DepartmentDTO saveDeprtment(DepartmentDTO departmentDTO);
      public DepartmentDTO getDepartmentByID(Long deptId);
      public List<DepartmentDTO> getAllDepartment();

}
