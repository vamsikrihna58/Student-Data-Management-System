package com.org.StudentDataManagementSystem.Entity;

import java.io.Serializable;

import org.hibernate.annotations.GenericGenerator;

import com.org.StudentDataManagementSystem.Dao.StudentDao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Table(name="student_data")
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity implements Serializable {
	@Id
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
	public StudentEntity(StudentDao dao) {
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
