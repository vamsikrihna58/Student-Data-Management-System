package com.org.StudentDataManagementSystem.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.org.StudentDataManagementSystem.Entity.StudentEntity;
@Repository
public class StudentRepository {
	@Autowired
	private DataRepository dr;
	
	
	public StudentEntity saveStudentData(StudentEntity se) {
		 return dr.save(se);
	}
	
	public StudentEntity getById(int id) {
		return dr.findById(id).orElse(new StudentEntity(HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND.name(),HttpStatus.NOT_FOUND.name(),
				HttpStatus.NOT_FOUND.name(),HttpStatus.NOT_FOUND.name(),HttpStatus.NOT_FOUND.name(),HttpStatus.NOT_FOUND.name(),HttpStatus.NOT_FOUND.name()));
	}
	public List<StudentEntity> getByName(String name) {
		return  dr.findByName(name);
	}
	public StudentEntity getByPH(String ph) {
		return dr.findByPh(ph);
	}
	public List<StudentEntity> fetchAllStudentData() {
		return dr.findAll();
	}
	
	public void deleteById(int id) {
		dr.deleteById(id);
	}

}
