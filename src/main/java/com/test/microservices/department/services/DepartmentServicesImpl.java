package com.test.microservices.department.services;

import com.test.microservices.department.dto.DepartmentDTO;
import com.test.microservices.department.entity.DepartmentEntity;
import com.test.microservices.department.repository.DepartmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class DepartmentServicesImpl implements DepartmentService{

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public DepartmentDTO saveDeprtment(DepartmentDTO departmentDTO) {

        DepartmentEntity departmentEntity=new DepartmentEntity();
        BeanUtils.copyProperties(departmentDTO,departmentEntity);
        departmentEntity=departmentRepository.save(departmentEntity);
        return departmentDTO;
    }

    @Override
    public DepartmentDTO getDepartmentByID(Long deptId) {

        DepartmentDTO departmentDTO = new DepartmentDTO();
        DepartmentEntity departmentEntity = departmentRepository.getDepartmentById(deptId);
        if(null!=departmentEntity) {
            BeanUtils.copyProperties(departmentEntity, departmentDTO);
        }
        return departmentDTO;
    }

    @Override
    public List<DepartmentDTO> getAllDepartment() {

        List<DepartmentDTO> departmentDTOList=new ArrayList<>();

        List<DepartmentEntity> departmentEntityList= departmentRepository.findAll();

        for (DepartmentEntity departmentEntity:departmentEntityList){
            DepartmentDTO departmentDTO = new DepartmentDTO();
            BeanUtils.copyProperties(departmentEntity, departmentDTO);
            departmentDTOList.add(departmentDTO);
        }
        return departmentDTOList;
    }
}
