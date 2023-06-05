package com.org.StudentDataManagementSystem.Repository;

import java.util.List;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import com.org.StudentDataManagementSystem.Entity.StudentEntity;

public interface DataRepository extends JpaRepository<StudentEntity, Integer> {
	List<StudentEntity> findByName(String name);
	StudentEntity findByPh(String ph);

}
