package com.org.StudentDataManagementSystem.DaoService;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.org.StudentDataManagementSystem.Dao.StudentDao;
import com.org.StudentDataManagementSystem.Entity.StudentEntity;
import com.org.StudentDataManagementSystem.Repository.StudentRepository;
import com.org.StudentDataManagementSystem.ResponseStructure.ResponseStructure;
import com.org.StudentDataManagementSystem.UtilExcpeionHandler.NoDataFoundException;



@Service
public class DaoService {
	@Autowired
	private StudentRepository re;
	 
	public ResponseStructure<StudentDao> saveUserDls(StudentDao dao) {
		StudentEntity st=new StudentEntity(dao);
		StudentEntity data = re.saveStudentData(st);
		StudentDao o=new  StudentDao(data);
		if(o !=null) {
			ResponseStructure<StudentDao> rs=new ResponseStructure<>();
			rs.setStatusCode(HttpStatus.OK.value());
			rs.setData(o);
			rs.setMessage("you are data was saved");
			return rs;
		}
		throw new NoDataFoundException();
		
	}
	public ResponseStructure<List<StudentDao>> All(){
		List<StudentEntity> list = re.fetchAllStudentData();
		List<StudentDao> l1=new ArrayList<>();
		for(StudentEntity s:list) {
			StudentDao sd=new StudentDao(s);
			l1.add(sd);
		}
		if(l1.size()!=0) {
			ResponseStructure <List<StudentDao>> rs=new ResponseStructure<>();
			rs.setStatusCode(HttpStatus.OK.value());
			rs.setData(l1);
			rs.setMessage("ALl the students data");
			return rs;
			
		}
		throw new NoDataFoundException();
		
	}
	public ResponseStructure<StudentDao> getById(int id) {
		StudentEntity byId = re.getById(id);
		StudentDao o=new  StudentDao(byId);
		if(o !=null) {
			if(o.getName().equals("NOT_FOUND")) {
				throw new NoDataFoundException();
			}
			ResponseStructure<StudentDao> rs=new ResponseStructure<>();
			rs.setStatusCode(HttpStatus.OK.value());
			rs.setData(o);
			rs.setMessage("Here it is the data based on id");
			return rs;
		}
		throw new NoDataFoundException();
		
	}
	public ResponseStructure<List<StudentDao>> getByname(String name){
		List<StudentEntity> byName = re.getByName(name);
		List<StudentDao> l1=new ArrayList<>();
		for(StudentEntity s:byName) {
			StudentDao sd=new StudentDao(s);
			l1.add(sd);
		}
		if(l1.size()!=0) {
			ResponseStructure <List<StudentDao>> rs=new ResponseStructure<>();
			rs.setStatusCode(HttpStatus.OK.value());
			rs.setData(l1);
			if(l1.size()==1) rs.setMessage("Only one data is available based on this name : "+name);
			else rs.setMessage("Here all students detials based on name : "+ name);
			return rs;
		}
		throw new NoDataFoundException();

		
	}
	public ResponseStructure<StudentDao> getByNUm(String num) {
		StudentEntity byId= re.getByPH(num);
		StudentDao o=new  StudentDao(byId);
		if(o !=null) {
			ResponseStructure<StudentDao> rs=new ResponseStructure<>();
			rs.setStatusCode(HttpStatus.OK.value());
			rs.setData(o);
			rs.setMessage("Here it is the data based on phone number : "+ num);
			return rs;
		}
		throw new NoDataFoundException();
	}
	public ResponseStructure<StudentDao> deleteById(int id) {
		ResponseStructure<StudentDao> byId = getById(id);
		byId.setMessage(id+" : This id data was deleted");
		re.deleteById(id);
		if(byId !=null) {
			return byId;
		}
		throw new NoDataFoundException();
		
	}

	

}
