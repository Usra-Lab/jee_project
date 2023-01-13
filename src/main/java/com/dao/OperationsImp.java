package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.beans.SingletonConnection;
import com.beans.StudentsBean;
import com.beans.SubjectsBean;
import com.beans.RegisterBean;

public class OperationsImp implements IOperations {
	
	Connection con=SingletonConnection.getConnection();

	/********************************************************/
    public boolean checkIfExistsUser(String email,String password) {
		
		boolean result =false;
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from teacher where email = ? and password=?");
			
			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
			    result=true;
			}
			else {
				result=false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
    	
	/********************************************************/

	public void insertTeacher (RegisterBean teacher) {
		try {
			
			PreparedStatement ps = con.prepareStatement("insert into teacher(firstName,lastName,password,email,subject) values (?,?,?,?,?)");
			
			ps.setString(1, teacher.getFirstName());
			ps.setString(2, teacher.getLastName());
			ps.setString(3, teacher.getPassword());
			ps.setString(4, teacher.getEmail());
			ps.setString(5, teacher.getSubject());
			
			ps.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	/********************************************************/
	
	public void SMinsertStudent(int apogee,String firstName,String lastName,String email) {
		
	try {
			
			PreparedStatement ps1 = con.prepareStatement("insert into student_list (apogee,firstName,lastName,email) values (?,?,?,?)");
			PreparedStatement ps2 = con.prepareStatement("insert into jee_subject (fk_apogee,jee_mark) values (?,?)");
			PreparedStatement ps3 = con.prepareStatement("insert into cs_subject (fk_apogee,cs_mark) values (?,?)");
			PreparedStatement ps4 = con.prepareStatement("insert into frameworks_subject (fk_apogee,frameworks_mark) values (?,?)");
			PreparedStatement ps5 = con.prepareStatement("insert into mobile_dev_subject (fk_apogee,mobile_dev_mark) values (?,?)");
			PreparedStatement ps6 = con.prepareStatement("insert into administration_system_subject (fk_apogee,administration_system_mark) values (?,?)");
			PreparedStatement ps7= con.prepareStatement("insert into maths_subject (fk_apogee,maths_mark) values (?,?)");

	
			ps1.setInt(1,apogee );
			ps1.setString(2,firstName );
			ps1.setString(3,lastName );
			ps1.setString(4,email );
			ps1.executeUpdate();

			ps2.setInt(1, apogee);
			ps2.setDouble(2, 0.0);
			ps2.executeUpdate();
			
			ps3.setInt(1, apogee);
			ps3.setDouble(2, 0.0);
			ps3.executeUpdate();

			ps4.setInt(1, apogee);
			ps4.setDouble(2, 0.0);
			ps4.executeUpdate();

			ps5.setInt(1, apogee);
			ps5.setDouble(2, 0.0);
			ps5.executeUpdate();
			
			ps6.setInt(1, apogee);
			ps6.setDouble(2, 0.0);
			ps6.executeUpdate();
			
			ps7.setInt(1, apogee);
			ps7.setDouble(2, 0.0);
			ps7.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
/*==================================================================================*/
	
	public void deleteStudent(int apogee)throws SQLException{
		
		PreparedStatement ps1 = con.prepareStatement("delete  from jee_subject  where fk_apogee = ?");
		ps1.setInt(1, apogee);
		ps1.executeUpdate();
		
        PreparedStatement ps2 = con.prepareStatement("delete  from cs_subject  where fk_apogee = ?");
		ps2.setInt(1, apogee);
		ps2.executeUpdate();
		
        PreparedStatement ps3 = con.prepareStatement("delete  from frameworks_subject  where fk_apogee = ?");
		ps3.setInt(1, apogee);
		ps3.executeUpdate();
		
        PreparedStatement ps4 = con.prepareStatement("delete  from mobile_dev_subject  where fk_apogee = ?");
		ps4.setInt(1, apogee);
		ps4.executeUpdate();
		
        PreparedStatement ps5 = con.prepareStatement("delete  from administration_system_subject  where fk_apogee = ?");
		ps5.setInt(1, apogee);
		ps5.executeUpdate();
		
        PreparedStatement ps6 = con.prepareStatement("delete  from maths_subject  where fk_apogee = ?");
		ps6.setInt(1, apogee);
		ps6.executeUpdate();

        PreparedStatement ps7 = con.prepareStatement("delete  from student_list where apogee = ?");
		ps7.setInt(1, apogee);
		ps7.executeUpdate();

	}
	
	/********************************************************/
	public void updateStudentData(int apogee,StudentsBean student)throws SQLException{
		
		PreparedStatement ps = con.prepareStatement("update student_list set firstName=?,lastName=?,email=? where apogee=?");
		ps.setString(1, student.getFirstName());
		ps.setString(2, student.getLastName());
		ps.setString(3, student.getEmail());
		ps.setInt(4, apogee);
		ps.executeUpdate();
		ps.close();	
		
		
	}
	
	/********************************************************/
	
	  public List <StudentsBean> SMgetStudentsMarks()throws SQLException{
		
		List <StudentsBean> students=new ArrayList<>();
		PreparedStatement ps = con.prepareStatement("select *from student_list,cs_subject c,jee_subject j,mobile_dev_subject m,frameworks_subject f,maths_subject ms,administration_system_subject a where apogee=c.fk_apogee and apogee=j.fk_apogee and apogee=m.fk_apogee and apogee=f.fk_apogee and apogee=ms.fk_apogee and apogee=a.fk_apogee;");
		ResultSet rs=ps.executeQuery();

		while (rs.next()) {
			
			StudentsBean student = new StudentsBean();
			student.setApogee(rs.getInt("apogee"));
			student.setFirstName(rs.getString("firstName"));
			student.setLastName(rs.getString("lastName"));	        
	        student.setCs_mark(rs.getDouble("cs_mark"));
	        student.setJee_mark(rs.getDouble("jee_mark"));
	        student.setMobile_dev_mark(rs.getDouble("mobile_dev_mark"));
	        student.setFrameworks_mark(rs.getDouble("frameworks_mark"));
	        student.setMaths_mark(rs.getDouble("maths_mark"));
	        student.setAdministration_system_mark(rs.getDouble("administration_system_mark"));
			students.add(student);
		}
		
		 rs.close();
	     ps.close();  
	return students;
	}

		/********************************************************/

	public List <StudentsBean> getStudentdata()throws SQLException{
		
		List <StudentsBean> students=new ArrayList<>();
		PreparedStatement ps = con.prepareStatement("select * from student_list");
		ResultSet rs=ps.executeQuery();
	
		while (rs.next()) {
			StudentsBean student = new StudentsBean();
			student.setApogee(rs.getInt("apogee"));
			student.setFirstName(rs.getString("firstName"));
			student.setLastName(rs.getString("lastName"));
	        student.setEmail(rs.getString("email"));
			students.add(student);
		}
		
		 rs.close();
	     ps.close();
	         
	return students;	
	}

	/********************************************************/

	public List <StudentsBean> getStudentmark(String code)throws SQLException{
		
	List <StudentsBean> students=new ArrayList<>();
	
	 switch(code) {
	    
	    case "jee_code":
	    {
	    	PreparedStatement ps = con.prepareStatement("select apogee,firstName,lastName,email,jee_mark from student_list,jee_subject where apogee=fk_apogee ");
	    	ResultSet rs=ps.executeQuery();
	    	while (rs.next()) {
	    		StudentsBean student = new StudentsBean();
	    		student.setApogee(rs.getInt("apogee"));
	    		student.setJee_mark(rs.getDouble("jee_mark"));
	    		student.setFirstName(rs.getString("firstName"));
	    		student.setLastName(rs.getString("lastName"));
	    		student.setEmail(rs.getString("email"));

	    		students.add(student);
	    	}
	    	
	    	 rs.close();
	         ps.close();
	    	
	    }
	    break;
	 
	    case "framworks_code":
	    {
	    	PreparedStatement ps = con.prepareStatement("select apogee,firstName,lastName,email,frameworks_mark from student_list,frameworks_subject where apogee=fk_apogee");
	    	ResultSet rs=ps.executeQuery();
	    	while (rs.next()) {
	    		StudentsBean student = new StudentsBean();
	    		student.setApogee(rs.getInt("apogee"));
	    		student.setFrameworks_mark(rs.getDouble("frameworks_mark"));
	    		student.setFirstName(rs.getString("firstName"));
	    		student.setLastName(rs.getString("lastName"));
	    		student.setEmail(rs.getString("email"));

	    		students.add(student);
	    	}
	    	
	    	 rs.close();
	         ps.close();
	    	
	    }
	    break;
	    
	 case "maths_code":
	   {
	    	PreparedStatement ps = con.prepareStatement("select apogee,firstName,lastName,email,maths_mark from student_list,maths_subject where apogee=fk_apogee");
	    	ResultSet rs=ps.executeQuery();
	    	while (rs.next()) {
	    		StudentsBean student = new StudentsBean();
	    		student.setApogee(rs.getInt("apogee"));
	    		student.setMaths_mark(rs.getDouble("maths_mark"));
	    		student.setFirstName(rs.getString("firstName"));
	    		student.setLastName(rs.getString("lastName"));
	    		student.setEmail(rs.getString("email"));

	    		students.add(student);
	    	}
	    	
	    	 rs.close();
	         ps.close();
	    	
	    }
	 break;
	 
	 case "dev_mobile_code":
	   {
	 	PreparedStatement ps = con.prepareStatement("select apogee,firstName,lastName,email,mobile_dev_mark from student_list,mobile_dev_subject where apogee=fk_apogee");
	 	ResultSet rs=ps.executeQuery();
	 	while (rs.next()) {
	 		StudentsBean student = new StudentsBean();
	 		student.setApogee(rs.getInt("apogee"));
	 		student.setMobile_dev_mark(rs.getDouble("mobile_dev_mark"));
	 		student.setFirstName(rs.getString("firstName"));
	 		student.setLastName(rs.getString("lastName"));
	 		student.setEmail(rs.getString("email"));

	 		students.add(student);
	 	}
	 	
	 	  rs.close();
	      ps.close();
	 	
	 }
	  break;
	 
	 case "cs_code":
	    {
		 	PreparedStatement ps = con.prepareStatement("select apogee,firstName,lastName,email,cs_mark from student_list,cs_subject where apogee=fk_apogee");
		 	ResultSet rs=ps.executeQuery();
		 	while (rs.next()) {
		 		StudentsBean student = new StudentsBean();
		 		student.setApogee(rs.getInt("apogee"));
		 		student.setCs_mark(rs.getDouble("cs_mark"));
		 		student.setFirstName(rs.getString("firstName"));
		 		student.setLastName(rs.getString("lastName"));
		 		student.setEmail(rs.getString("email"));
		 		
		 		students.add(student);
		 	}
		 	
		 	  rs.close();
		      ps.close();
		 	
		 }
	     break;
	     
	 case "administration_system_code":
	     {
		 	PreparedStatement ps = con.prepareStatement("select apogee,firstName,lastName,email,administration_system_mark from student_list,administration_system_subject where apogee=fk_apogee ");
		 	ResultSet rs=ps.executeQuery();
		 	while (rs.next()) {
		 		StudentsBean student = new StudentsBean();
		 		student.setApogee(rs.getInt("apogee"));
		 		student.setAdministration_system_mark(rs.getDouble("administration_system_mark"));
		 		student.setFirstName(rs.getString("firstName"));
		 		student.setLastName(rs.getString("lastName"));
		 		student.setEmail(rs.getString("email"));

		 		students.add(student);
		 	}
		 	
		 	  rs.close();
		      ps.close();
		 	
		 }
	 
	    }
		
	return students;	
	
 }

    public StudentsBean getStudentsByApogee(int apogee,String code) throws SQLException{
    	
	StudentsBean student = new StudentsBean();

		 switch(code) {
		    
		    case "jee_code":
		       {
		    	PreparedStatement ps = con.prepareStatement("select apogee,jee_mark from student_list,jee_subject where apogee=fk_apogee and apogee=? ");
		    	ps.setInt(1,apogee);
		    	ResultSet rs=ps.executeQuery();
		    	while (rs.next()) {
		    		student.setApogee(rs.getInt("apogee"));
		            student.setJee_mark(rs.getDouble("jee_mark"));
		    	}
		    	 rs.close();
		         ps.close();
		    }
		    break;
		 
		    case "framworks_code":
		    
		    {
		    	PreparedStatement ps = con.prepareStatement("select apogee,frameworks_mark from student_list,frameworks_subject where apogee=fk_apogee and apogee=?");
		    	ps.setInt(1,apogee);
		    	ResultSet rs=ps.executeQuery();
		    	while (rs.next()) {
		    		student.setApogee(rs.getInt("apogee"));
		    		student.setFrameworks_mark(rs.getDouble("frameworks_mark"));
		    	}
		    	
		    	 rs.close();
		         ps.close();
		    	
		    }
		    break;
		    
		 case "maths_code":
		     {
		    	PreparedStatement ps = con.prepareStatement("select apogee,maths_mark from student_list,maths_subject where apogee=fk_apogee and apogee=?");
		    	ps.setInt(1,apogee);
		    	ResultSet rs=ps.executeQuery();
		    	while (rs.next()) {
		    		student.setApogee(rs.getInt("apogee"));
		    		student.setMaths_mark(rs.getDouble("maths_mark"));
		    	}
		    	 rs.close();
		         ps.close();
		    }
		 
		 case "dev_mobile_code":
		    {
		 	
		 	PreparedStatement ps = con.prepareStatement("select apogee,mobile_dev_mark from student_list,mobile_dev_subject where apogee=fk_apogee and apogee=?");
		 	ps.setInt(1,apogee);
	    	ResultSet rs=ps.executeQuery();
	    	while (rs.next()) {
	    		student.setApogee(rs.getInt("apogee"));
	    		student.setMobile_dev_mark(rs.getDouble("mobile_dev_mark"));
	    	}
	    	
	    	 rs.close();
	         ps.close();
		 	
		 }
		  break;
		 
		 case "cs_code":
		     {
			 	
			 	PreparedStatement ps = con.prepareStatement("select apogee,cs_mark from student_list,cs_subject where apogee=fk_apogee and apogee=?");
			 	ps.setInt(1,apogee);
		    	ResultSet rs=ps.executeQuery();
		    	while (rs.next()) {
		    		student.setApogee(rs.getInt("apogee"));
		    		student.setCs_mark(rs.getDouble("cs_mark"));
		    	}
		    	
		    	 rs.close();
		         ps.close();
			 	
			 }
		     break;
		     
		 case "administration_system_code":
		     {
			 	PreparedStatement ps = con.prepareStatement("select apogee,administration_system_mark from student_list,administration_system_subject where apogee=fk_apogee and apogee=?");
			 	ps.setInt(1,apogee);
		    	ResultSet rs=ps.executeQuery();
		    	while (rs.next()) {
		    		student.setApogee(rs.getInt("apogee"));
		    		student.setAdministration_system_mark(rs.getDouble("administration_system_mark"));
		    	}
		    	
		    	 rs.close();
		         ps.close();
			 	}
			 	
			 }  
			
		return student;	
	
}
	/********************************************************/

   public void updateStudentMark(StudentsBean student,int apogee,String code)throws SQLException {
	
	 switch(code) {
	    
	    case "jee_code":
	    {
	    	PreparedStatement ps = con.prepareStatement("update jee_subject set jee_mark=? where fk_apogee=?");
	    	ps.setDouble(1, student.getJee_mark());
	    	ps.setInt(2,apogee);
	    	ps.executeUpdate();
            ps.close();
	    	
	    }
	    break;
	 
	    case "framworks_code":
	    {
	    	PreparedStatement ps = con.prepareStatement("update frameworks_subject set frameworks_mark=? where fk_apogee=?");
	    	ps.setDouble(1, student.getFrameworks_mark());
	    	ps.setInt(2,apogee);
	    	ps.executeUpdate();
            ps.close();	    	
	    }
	    break;
	    
	 case "maths_code":
	     {
	    	PreparedStatement ps = con.prepareStatement("update maths_subject set maths_mark=? where fk_apogee=?");
	    	ps.setDouble(1, student.getMaths_mark());
	    	ps.setInt(2,apogee);
	    	ps.executeUpdate();
            ps.close();	
	    	
	    }
	    break;

	 
	 case "dev_mobile_code":
	    {
	 	PreparedStatement ps = con.prepareStatement("update mobile_dev_subject set mobile_dev_mark=? where fk_apogee=?");
	 	ps.setDouble(1, student.getMobile_dev_mark());
    	ps.setInt(2,apogee);
    	ps.executeUpdate();
        ps.close();	
	 }
	  break;
	 
	 case "cs_code":
	    {
		 	PreparedStatement ps = con.prepareStatement("update cs_subject set cs_mark=? where fk_apogee=?");
		 	ps.setDouble(1, student.getCs_mark());
	    	ps.setInt(2,apogee);
	    	ps.executeUpdate();
	        ps.close();	
		 }
	     break;
	     
	 case "administration_system_code":{
		 	
		 	PreparedStatement ps = con.prepareStatement("update administration_system_subject set administration_system_mark=? where fk_apogee=?");
			ps.setDouble(1, student.getAdministration_system_mark());
	    	ps.setInt(2,apogee);
	    	ps.executeUpdate();
	        ps.close();	
		 }
	 
	   }
		
  }

	/********************************************************/

	public List <StudentsBean> getStudentByfirstName(String firstName) throws SQLException {
	
	List <StudentsBean> students=new ArrayList<>();
	
	PreparedStatement ps = con.prepareStatement("SELECT * FROM student_list WHERE firstName like ?");
	ps.setString(1, firstName+'%');
	ResultSet rs=ps.executeQuery();
	while (rs.next()) {
		StudentsBean student = new StudentsBean();
		student.setApogee(rs.getInt("apogee"));
		student.setFirstName(rs.getString("firstName"));
		student.setLastName(rs.getString("lastName"));
		student.setEmail(rs.getString("email"));
		
		students.add(student);
	
	}

	 rs.close();
	 ps.close();
     

	return students;

	}
	
	/********************************************************/

	public List <StudentsBean> getTop10Student(String code) throws SQLException{
		
	List <StudentsBean> students=new ArrayList<>();
	
		 switch(code) {
		    
		    case "jee_code":
		    {
		    	PreparedStatement ps = con.prepareStatement("select *from student_list,jee_subject where apogee=fk_apogee order by jee_mark desc limit 10 ");
		    	ResultSet rs=ps.executeQuery();
	
		    	while (rs.next()) {
		    		StudentsBean student = new StudentsBean();
		    		student.setApogee(rs.getInt("apogee"));
		    		student.setJee_mark(rs.getDouble("jee_mark"));
		    		student.setFirstName(rs.getString("firstName"));
		    		student.setLastName(rs.getString("lastName"));
		    		student.setEmail(rs.getString("email"));
	
		    		students.add(student);
		    	}
		    	
		    	 rs.close();
		         ps.close();
		    	
		    }
		    break;
		 
		    case "framworks_code":{
		    	
		    	PreparedStatement ps = con.prepareStatement("select *from student_list,frameworks_subject where apogee=fk_apogee order by frameworks_mark desc limit 10  ");
		    	ResultSet rs=ps.executeQuery();
	
		    	while (rs.next()) {
		    		StudentsBean student = new StudentsBean();
		    		student.setApogee(rs.getInt("apogee"));
		    		student.setFrameworks_mark(rs.getDouble("frameworks_mark"));
		    		student.setFirstName(rs.getString("firstName"));
		    		student.setLastName(rs.getString("lastName"));
		    		student.setEmail(rs.getString("email"));
		    		
		    		students.add(student);
		    	}
		    	
		    	 rs.close();
		         ps.close();
		    	
		    }
		    break;
	
		    
		 case "maths_code":{
		    	
		    	PreparedStatement ps = con.prepareStatement("select *from student_list,maths_subject where apogee=fk_apogee order by maths_mark desc limit 10 ");
		    	ResultSet rs=ps.executeQuery();
	
		    	while (rs.next()) {
		    		StudentsBean student = new StudentsBean();
		    		student.setApogee(rs.getInt("apogee"));
		    		student.setMaths_mark(rs.getDouble("maths_mark"));
		    		student.setFirstName(rs.getString("firstName"));
		    		student.setLastName(rs.getString("lastName"));
		    		student.setEmail(rs.getString("email"));
	
		    		students.add(student);
		    	}
		    	
		    	 rs.close();
		         ps.close();
		    	
		    }
		    break;
	
		 
		 case "dev_mobile_code":{
		 	
		 	PreparedStatement ps = con.prepareStatement("select *from student_list,mobile_dev_subject where apogee=fk_apogee order by mobile_dev_mark desc limit 10 ");
		 	ResultSet rs=ps.executeQuery();
	
		 	while (rs.next()) {
		 		StudentsBean student = new StudentsBean();
		 		student.setApogee(rs.getInt("apogee"));
		 		student.setMobile_dev_mark(rs.getDouble("mobile_dev_mark"));
		 		student.setFirstName(rs.getString("firstName"));
		 		student.setLastName(rs.getString("lastName"));
		 		student.setEmail(rs.getString("email"));
		 		
		 		students.add(student);
		 	}
		 	
		 	  rs.close();
		      ps.close();
		 	
		 }
		  break;
		 
		 case "cs_code":{
			 	
			 	PreparedStatement ps = con.prepareStatement("select *from student_list,cs_subject where apogee=fk_apogee order by cs_mark desc limit 10 ");
			 	ResultSet rs=ps.executeQuery();
	
			 	while (rs.next()) {
			 		StudentsBean student = new StudentsBean();
			 		student.setApogee(rs.getInt("apogee"));
			 		student.setCs_mark(rs.getDouble("cs_mark"));
			 		student.setFirstName(rs.getString("firstName"));
			 		student.setLastName(rs.getString("lastName"));
			 		student.setEmail(rs.getString("email"));
	
			 		students.add(student);
			 	}
			 	
			 	  rs.close();
			      ps.close();
			 	
			 }
		     break;
		     
		 case "administration_system_code":{
			 	PreparedStatement ps = con.prepareStatement("select *from student_list,administration_system_subject where apogee=fk_apogee order by administration_system_mark desc limit 10 ");
			 	ResultSet rs=ps.executeQuery();
	
			 	while (rs.next()) {
			 		StudentsBean student = new StudentsBean();
			 		student.setApogee(rs.getInt("apogee"));
			 		student.setAdministration_system_mark(rs.getDouble("administration_system_mark"));
			 		student.setFirstName(rs.getString("firstName"));
			 		student.setLastName(rs.getString("lastName"));
			 		student.setEmail(rs.getString("email"));
			 		
			 		students.add(student);
			 	}
			 	
			 	  rs.close();
			      ps.close();
			 	
			 }
		 
		    }
			
		         
		return students;	
	}

	/********************************************************/
	public List <StudentsBean> getCatchingUp(String code) throws SQLException{
		
     List <StudentsBean> students=new ArrayList<>();
		
	    switch(code) {
	    
	    case "jee_code":
	    {
	    	PreparedStatement ps = con.prepareStatement("select *from student_list,jee_subject where apogee=fk_apogee and jee_mark<12 ");
	    	ResultSet rs=ps.executeQuery();
	
	    	while (rs.next()) {
	    		StudentsBean student = new StudentsBean();
	    		student.setApogee(rs.getInt("apogee"));
	    		student.setJee_mark(rs.getDouble("jee_mark"));
	    		student.setFirstName(rs.getString("firstName"));
	    		student.setLastName(rs.getString("lastName"));
	    		student.setEmail(rs.getString("email"));
	
	    		students.add(student);
	    	}
	    	
	    	 rs.close();
	         ps.close();
	    	
	    }
	    break;
	 
	    case "framworks_code":{
	    	
	    	PreparedStatement ps = con.prepareStatement("select *from student_list,frameworks_subject where apogee=fk_apogee and frameworks_mark<12 ");
	    	ResultSet rs=ps.executeQuery();
	
	    	while (rs.next()) {
	    		StudentsBean student = new StudentsBean();
	    		student.setApogee(rs.getInt("apogee"));
	    		student.setFrameworks_mark(rs.getDouble("frameworks_mark"));
	    		student.setFirstName(rs.getString("firstName"));
	    		student.setLastName(rs.getString("lastName"));
	    		student.setEmail(rs.getString("email"));
	    		
	    		students.add(student);
	    	}
	    	
	    	 rs.close();
	         ps.close();
	    	
	    }
	    break;
	    
	 case "maths_code":{
	    	
	    	PreparedStatement ps = con.prepareStatement("select *from student_list,maths_subject where apogee=fk_apogee and maths_mark<12 ");
	    	ResultSet rs=ps.executeQuery();
	
	    	while (rs.next()) {
	    		StudentsBean student = new StudentsBean();
	    		student.setApogee(rs.getInt("apogee"));
	    		student.setMaths_mark(rs.getDouble("maths_mark"));
	    		student.setFirstName(rs.getString("firstName"));
	    		student.setLastName(rs.getString("lastName"));
	    		student.setEmail(rs.getString("email"));
	
	    		students.add(student);
	    	}
	    	
	    	 rs.close();
	         ps.close();
	    	
	    }
	 break;
	
	 
	 case "dev_mobile_code":{
	 	
	 	PreparedStatement ps = con.prepareStatement("select *from student_list,mobile_dev_subject where apogee=fk_apogee and mobile_dev_mark < 12 ");
	 	ResultSet rs=ps.executeQuery();
	
	 	while (rs.next()) {
	 		StudentsBean student = new StudentsBean();
	 		student.setApogee(rs.getInt("apogee"));
	 		student.setMobile_dev_mark(rs.getDouble("mobile_dev_mark"));
	 		student.setFirstName(rs.getString("firstName"));
	 		student.setLastName(rs.getString("lastName"));
	 		student.setEmail(rs.getString("email"));
	
	 		students.add(student);
	 	}
	 	
	 	  rs.close();
	      ps.close();
	 	
	 }
	  break;
	 
	 case "cs_code":{
		 	
		 	PreparedStatement ps = con.prepareStatement("select *from student_list,cs_subject where apogee=fk_apogee and cs_mark <12 ");
		 	ResultSet rs=ps.executeQuery();
	
		 	while (rs.next()) {
		 		StudentsBean student = new StudentsBean();
		 		student.setApogee(rs.getInt("apogee"));
		 		student.setCs_mark(rs.getDouble("cs_mark"));
		 		student.setFirstName(rs.getString("firstName"));
		 		student.setLastName(rs.getString("lastName"));
		 		student.setEmail(rs.getString("email"));
		 		
		 		students.add(student);
		 	}
		 	
		 	  rs.close();
		      ps.close();
		 	
		 }
	     break;
	     
	 case "administration_system_code":{
		 	
		 	PreparedStatement ps = con.prepareStatement("select *from student_list,administration_system_subject where apogee=fk_apogee and administration_system_mark < 12 ");
		 	ResultSet rs=ps.executeQuery();
	
		 	while (rs.next()) {
		 		StudentsBean student = new StudentsBean();
		 		student.setApogee(rs.getInt("apogee"));
		 		student.setAdministration_system_mark(rs.getDouble("administration_system_mark"));
		 		student.setFirstName(rs.getString("firstName"));
		 		student.setLastName(rs.getString("lastName"));
		 		student.setEmail(rs.getString("email"));

		 		students.add(student);
		 	}
		 	
		 	  rs.close();
		      ps.close();
		 }
	 
	    }
	return students;
	}
	/********************************************************/

	
	public List <StudentsBean> getValidations(String code) throws SQLException{
	List <StudentsBean> students=new ArrayList<>();
		
	    switch(code) {
	    
	    case "jee_code":
	    {
	    	PreparedStatement ps = con.prepareStatement("select *from student_list,jee_subject where apogee=fk_apogee and jee_mark>=12 ");
	    	ResultSet rs=ps.executeQuery();
	
	    	while (rs.next()) {
	    		StudentsBean student = new StudentsBean();
	    		student.setApogee(rs.getInt("apogee"));
	    		student.setJee_mark(rs.getDouble("jee_mark"));
	    		student.setFirstName(rs.getString("firstName"));
	    		student.setLastName(rs.getString("lastName"));
	    		student.setEmail(rs.getString("email"));
	
	    		students.add(student);
	    	}
	    	
	    	 rs.close();
	         ps.close();
	    	
	    }
	    break;
	 
	    case "framworks_code":{
	    	
	    	PreparedStatement ps = con.prepareStatement("select *from student_list,frameworks_subject where apogee=fk_apogee and frameworks_mark>=12 ");
	    	ResultSet rs=ps.executeQuery();
	
	    	while (rs.next()) {
	    		StudentsBean student = new StudentsBean();
	    		student.setApogee(rs.getInt("apogee"));
	    		student.setFrameworks_mark(rs.getDouble("frameworks_mark"));
	    		student.setFirstName(rs.getString("firstName"));
	    		student.setLastName(rs.getString("lastName"));
	    		student.setEmail(rs.getString("email"));
	    		
	    		students.add(student);
	    	}
	    	
	    	 rs.close();
	         ps.close();
	    	
	    }
	    break;
	    
	 case "maths_code":{
	    	
	    	PreparedStatement ps = con.prepareStatement("select *from student_list,maths_subject where apogee=fk_apogee and maths_mark>=12 ");
	    	ResultSet rs=ps.executeQuery();
	
	    	while (rs.next()) {
	    		StudentsBean student = new StudentsBean();
	    		student.setApogee(rs.getInt("apogee"));
	    		student.setMaths_mark(rs.getDouble("maths_mark"));
	    		student.setFirstName(rs.getString("firstName"));
	    		student.setLastName(rs.getString("lastName"));
	    		student.setEmail(rs.getString("email"));
	
	    		students.add(student);
	    	}
	    	
	    	 rs.close();
	         ps.close();
	    	
	    }
	 break;
	
	 
	 case "dev_mobile_code":{
	 	
	 	PreparedStatement ps = con.prepareStatement("select *from student_list,mobile_dev_subject where apogee=fk_apogee and mobile_dev_mark >= 12 ");
	 	ResultSet rs=ps.executeQuery();
	
	 	while (rs.next()) {
	 		StudentsBean student = new StudentsBean();
	 		student.setApogee(rs.getInt("apogee"));
	 		student.setMobile_dev_mark(rs.getDouble("mobile_dev_mark"));
	 		student.setFirstName(rs.getString("firstName"));
	 		student.setLastName(rs.getString("lastName"));
	 		student.setEmail(rs.getString("email"));
	
	 		students.add(student);
	 	}
	 	
	 	  rs.close();
	      ps.close();
	 	
	 }
	  break;
	 
	 case "cs_code":{
		 	
		 	PreparedStatement ps = con.prepareStatement("select *from student_list,cs_subject where apogee=fk_apogee and cs_mark >= 12 ");
		 	ResultSet rs=ps.executeQuery();
	
		 	while (rs.next()) {
		 		StudentsBean student = new StudentsBean();
		 		student.setApogee(rs.getInt("apogee"));
		 		student.setCs_mark(rs.getDouble("cs_mark"));
		 		student.setFirstName(rs.getString("firstName"));
		 		student.setLastName(rs.getString("lastName"));
		 		student.setEmail(rs.getString("email"));
		 		
		 		students.add(student);
		 	}
		 	
		 	  rs.close();
		      ps.close();
		 	
		 }
	     break;
	     
	 case "administration_system_code":{
		 	
		 	PreparedStatement ps = con.prepareStatement("select *from student_list,administration_system_subject where apogee=fk_apogee and administration_system_mark >= 12 ");
		 	ResultSet rs=ps.executeQuery();
	
		 	while (rs.next()) {
		 		StudentsBean student = new StudentsBean();
		 		student.setApogee(rs.getInt("apogee"));
		 		student.setAdministration_system_mark(rs.getDouble("administration_system_mark"));
		 		student.setFirstName(rs.getString("firstName"));
		 		student.setLastName(rs.getString("lastName"));
		 		student.setEmail(rs.getString("email"));

		 		students.add(student);
		 	}
		 	
		 	  rs.close();
		      ps.close();
		 }
	 
	    }
	return students;
	}

	/********************************************************/
	
	public String getSubject(String email) throws SQLException {
		
		String subject="";
		PreparedStatement ps = con.prepareStatement("select subject from teacher where email = ?");
		ps.setString(1, email);
		ResultSet rs=ps.executeQuery();
		if (rs.next()) {
				subject=rs.getString("subject");
		}
		
	return subject;
			
	}

/********************************************************/
	public StudentsBean getStudentsByApogee(int apogee) throws SQLException{
		
		StudentsBean student =new StudentsBean();
		PreparedStatement ps = con.prepareStatement("select * from student_list  where apogee = ?");
		ps.setInt(1, apogee);
		ResultSet rs=ps.executeQuery();
	
		if (rs.next()) {
			student.setFirstName(rs.getString("firstName"));
			student.setLastName(rs.getString("lastName"));
			student.setEmail(rs.getString("email"));
		}
		
	return student;
	
	}
	/**
	 * @throws SQLException ******************************************************/
	public int StudentsNumer() throws SQLException {
		PreparedStatement ps = con.prepareStatement("select * from student_list");
		int count=0;
		ResultSet rs=ps.executeQuery();
		
		while (rs.next()) {
			count++;
		}
		return count;
	}

	/********************************************************/
	public int TeacherNumber()throws SQLException {
		PreparedStatement ps = con.prepareStatement("select * from teacher");
		int count=0;
		ResultSet rs=ps.executeQuery();
		
		while (rs.next()) {
			count++;
		}
		return count;
	}
	/**
	 * @throws SQLException ******************************************************/

	
	public double jeeFirstMark() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT MAX(jee_mark) FROM jee_subject");
        double mark=0;
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			mark=rs.getDouble("MAX(jee_mark)");

		}
		
		return mark;
		
	}
	/**
	 * @throws SQLException ******************************************************/

	public double  jeeLaststMark() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT MIN(jee_mark) FROM jee_subject");
        double mark=0;
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			mark=rs.getDouble("MIN(jee_mark)");
			
		}
		
		return mark ;

		
	}
	/**
	 * @throws SQLException ******************************************************/

	public double frameworksFirstMark() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT MAX(frameworks_mark) FROM frameworks_subject");
        double mark=0;
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			mark=rs.getDouble("MAX(frameworks_mark)");
			
		}
		
		return mark ;
		
	}
	/**
	 * @throws SQLException ******************************************************/

	public double frameworksLaststMark() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT MIN(frameworks_mark) FROM frameworks_subject");
        double mark=0;
		ResultSet rs=ps.executeQuery();

		while (rs.next()) {
			mark=rs.getDouble("MIN(frameworks_mark)");
		}
		return mark;
		
	}
	/**
	 * @throws SQLException ******************************************************/

	public double mathsFirstMark() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT MAX(maths_mark) FROM maths_subject");
        double mark=0;
		ResultSet rs=ps.executeQuery();

		while (rs.next()) {
			mark=rs.getDouble("MAX(maths_mark)");
		}
		return mark;
		
	}
	/**
	 * @throws SQLException ******************************************************/

	public double mathsLaststMark() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT MIN(maths_mark) FROM maths_subject");
        double mark=0;
		ResultSet rs=ps.executeQuery();
		
		while (rs.next()) {
			mark=rs.getDouble("MIN(maths_mark)");
		}
		return mark;
		
	}
	/**
	 * @throws SQLException ******************************************************/

	public double administationSystemFirstMark() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT MAX(administration_system_mark) FROM administration_system_subject");
        double mark=0;
		ResultSet rs=ps.executeQuery();
		
		while (rs.next()) {
			mark=rs.getDouble("MAX(administration_system_mark)");
		}
		return mark;
		
	}
	/**
	 * @throws SQLException ******************************************************/

	public double administrationSystemLaststMark() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT MIN(administration_system_mark) FROM administration_system_subject");
        double mark=0;
		ResultSet rs=ps.executeQuery();
		
		while (rs.next()) {
			mark=rs.getDouble("MIN(administration_system_mark)");
		}
		return mark;
		
	}
	/**
	 * @throws SQLException ******************************************************/

	public double mobileDevFirstMark() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT MAX(mobile_dev_mark) FROM mobile_dev_subject");
        double mark=0;
		ResultSet rs=ps.executeQuery();
		
		while (rs.next()) {
			mark=rs.getDouble("MAX(mobile_dev_mark");
		}
		return mark;
		
	}
	/**
	 * @throws SQLException ******************************************************/

	public double mobileDevLaststMark() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT MIN(mobile_dev_mark) FROM mobile_dev_subject");
        double mark=0;
		ResultSet rs=ps.executeQuery();
		
		while (rs.next()) {
			mark=rs.getDouble("MIN(mobile_dev_mark");
		}
		return mark;
		
	}
	/**
	 * @throws SQLException ******************************************************/

	public double csFirstMark() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT MAX(cs_mark) FROM cs_subject");
        double mark=0;
		ResultSet rs=ps.executeQuery();
		
		while (rs.next()) {
			mark=rs.getDouble("MAX(cs_mark)");
		}
		return mark;
		
	}
	/**
	 * @throws SQLException ******************************************************/

	public double csLaststMark() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT MIN(cs_mark) FROM cs_subject");
        double mark=0;
		ResultSet rs=ps.executeQuery();
		
		while (rs.next()) {
			mark=rs.getDouble("MIN(cs_mark)");
		}
		return mark;
		
	}
	/**
	 * @throws SQLException *****************************************************************************/
	
	public List <RegisterBean> getTeacherData() throws SQLException {
		
	List <RegisterBean> teachers=new ArrayList<>();
	    	PreparedStatement ps = con.prepareStatement("select *from teacher ");
	    	ResultSet rs=ps.executeQuery();
	    	while (rs.next()) {
	    		
	    		RegisterBean teacher = new RegisterBean();
	    		teacher.setFirstName(rs.getString("firstName"));
	    		teacher.setLastName(rs.getString("lastName"));
	    		teacher.setEmail(rs.getString("email"));

	    		teachers.add(teacher);
	    	}
	    	
	    	 rs.close();
	         ps.close();
	         
	         return teachers;
		
	}

	
 }


