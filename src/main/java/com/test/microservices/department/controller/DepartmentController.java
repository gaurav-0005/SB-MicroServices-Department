package com.test.microservices.department.controller;


import com.test.microservices.department.dto.DepartmentDTO;
import com.test.microservices.department.services.DepartmentService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {


    @Autowired
    DepartmentService departmentService;

    @PostMapping("/")
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDTO){

        departmentDTO=departmentService.saveDeprtment(departmentDTO);
        return new ResponseEntity<>(departmentDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{deptId}")
    public ResponseEntity<DepartmentDTO> getDeptById(@PathVariable("deptId") String deptId){

        DepartmentDTO departmentDTO=departmentService.getDepartmentByID(Long.parseLong(deptId));
        return new ResponseEntity<>(departmentDTO, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<DepartmentDTO>> getAllDept(){
        List<DepartmentDTO> departmentDTOList= departmentService.getAllDepartment();
        return new ResponseEntity<>(departmentDTOList,HttpStatus.OK);
    }


}
