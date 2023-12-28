package com.test.microservices.department.repository;

import com.test.microservices.department.entity.DepartmentEntity;
import jakarta.websocket.server.PathParam;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface DepartmentRepository extends MongoRepository<DepartmentEntity,Long> {

    @Query("{departmentId : ?0}")
    public DepartmentEntity getDepartmentById(Long deptId);
}
