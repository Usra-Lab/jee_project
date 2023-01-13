package com.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.beans.RegisterBean;
import com.dao.OperationsImp;


public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegisterController() {
        super();
    }
    
    RequestDispatcher dispatcher;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dispatcher=request.getRequestDispatcher("/WEB-INF/Views/Register.jsp");
		dispatcher.forward(request, response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String firtsName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String password=request.getParameter("password");
		String re_password=request.getParameter("re_password");
		String email=request.getParameter("email");
		String subject=request.getParameter("subject");
		
		RegisterBean membre=new RegisterBean(firtsName,lastName,password,email,subject);
		OperationsImp  metier=new OperationsImp();
		if(password.equals(re_password)) {metier.insertTeacher(membre);}
		dispatcher=request.getRequestDispatcher("/WEB-INF/Views/Login.jsp");
		dispatcher.forward(request, response);
		
  
   }
	
}