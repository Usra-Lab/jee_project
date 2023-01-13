package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.beans.RegisterBean;
import com.beans.StudentsBean;
import com.beans.SubjectsBean;

public interface IOperations {
	
	public boolean checkIfExistsUser(String username,String password);
	public void insertTeacher (RegisterBean teacher);
	public void SMinsertStudent(int apogee,String firstName,String lastName,String email);
	public void deleteStudent(int apogee)throws SQLException;
	public void updateStudentData(int apogee,StudentsBean student)throws SQLException;
	public List <StudentsBean> SMgetStudentsMarks()throws SQLException;
	public List <StudentsBean> getStudentdata()throws SQLException;
	public List <StudentsBean> getStudentmark(String code)throws SQLException;
	public void updateStudentMark(StudentsBean student,int apogee,String code)throws SQLException;
	public List <StudentsBean> getStudentByfirstName(String firstName ) throws SQLException;
	public List <StudentsBean> getTop10Student(String code) throws SQLException;
	public List <StudentsBean> getValidations(String code) throws SQLException;
	public List <StudentsBean> getCatchingUp(String code) throws SQLException;
	public StudentsBean getStudentsByApogee(int apogee) throws SQLException;
	public String getSubject(String email) throws SQLException;
	public int StudentsNumer() throws SQLException;
	public int TeacherNumber() throws SQLException;
	public double jeeFirstMark() throws SQLException;
	public double jeeLaststMark() throws SQLException;
	public double frameworksFirstMark() throws SQLException;
	public double frameworksLaststMark() throws SQLException;
	public double mathsFirstMark() throws SQLException;
	public double mathsLaststMark() throws SQLException;
	public double administationSystemFirstMark() throws SQLException;
	public double administrationSystemLaststMark() throws SQLException;
	public double mobileDevFirstMark() throws SQLException;
	public double mobileDevLaststMark() throws SQLException;
	public double csFirstMark() throws SQLException;
	public double csLaststMark() throws SQLException;
	public List <RegisterBean> getTeacherData() throws SQLException;


	
}
