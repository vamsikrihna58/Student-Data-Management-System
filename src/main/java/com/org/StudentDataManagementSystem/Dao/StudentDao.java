package com.org.StudentDataManagementSystem.Dao;

import org.hibernate.annotations.GenericGenerator;

import com.org.StudentDataManagementSystem.Entity.StudentEntity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDao {
	
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	private Integer id;
	private String name;
	private String ph;
	private String degree;
	private String branch;
	private String yearOfPassOut;
	private String percentage;
	private String course;
	@Override
	public String toString() {
		return "StudentDao [id=" + id + ", name=" + name + ", pH=" + ph + ", degree=" + degree + ", branch=" + branch
				+ ", yearOfPassOut=" + yearOfPassOut + ", percentage=" + percentage + ", course=" + course + "]";
	}
	public StudentDao(StudentEntity dao) {
		this.id=dao.getId();
		this.name=dao.getName();
		this.ph=dao.getPh();
		this.degree=dao.getDegree();
		this.branch=dao.getBranch();
		this.yearOfPassOut=dao.getYearOfPassOut();
		this.percentage=dao.getPercentage();
		this.course=dao.getCourse();
	}
	
	

}
