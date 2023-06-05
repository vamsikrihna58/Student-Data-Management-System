package com.org.StudentDataManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.StudentDataManagementSystem.Dao.StudentDao;
import com.org.StudentDataManagementSystem.DaoService.DaoService;
import com.org.StudentDataManagementSystem.Entity.StudentEntity;
import com.org.StudentDataManagementSystem.ResponseStructure.ResponseStructure;

@RestController
public class TestController {
	@Autowired
	private DaoService ds;
	
	@PostMapping("/save")
	public ResponseStructure<StudentDao> save(@RequestBody StudentDao da) {
		System.out.println(da);
		return ds.saveUserDls(da);
	}
	@GetMapping("/get")
	public ResponseStructure<List<StudentDao>> GetAllStudents() {
		return ds.All();
	}
	@GetMapping("/getById/{id}")
	public ResponseStructure<StudentDao> getById(@PathVariable("id") int id) {
		return ds.getById(id);
	}
	@GetMapping("/getByName/{name}")
	public ResponseStructure<List<StudentDao>> getByname(@PathVariable("name") String name) {
		return ds.getByname(name);
	}
	@GetMapping("/getByNum/{num}")
	public ResponseStructure<StudentDao> getByNum(@PathVariable("num") String num) {
		return ds.getByNUm(num);
	}
	@DeleteMapping("/deleteById/{id}")
	public ResponseStructure<StudentDao> deleteById(@PathVariable("id") int id) {
		 return ds.deleteById(id);
	}
	
}
