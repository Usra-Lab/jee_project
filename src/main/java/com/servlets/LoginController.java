package com.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.dao.OperationsImp;


public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginController() {
        super();
    }
    
    RequestDispatcher dispatcher;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dispatcher=request.getRequestDispatcher("/WEB-INF/Views/Login.jsp");
		dispatcher.forward(request, response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
		String email=request.getParameter("username");
		String password=request.getParameter("password");
		
		if(email.equals("admin@gmail.com") && password.equals("admin")) {
			OperationsImp metier =new OperationsImp();
			try {
				int StudentCounter=metier.StudentsNumer();
				int TeacherCounter=metier.TeacherNumber();
				double jeeFisrtMark=metier.jeeFirstMark();
				double jeeLastMark=metier.jeeLaststMark();
				double frameworksFirstMark=metier.frameworksFirstMark();
				double frameworksLastMark=metier.frameworksLaststMark();
				double csFirstMark=metier.csFirstMark();
				double csLastMark=metier.csLaststMark();
				
				dispatcher=request.getRequestDispatcher("/WEB-INF/SMViews/Home.jsp");
				
				request.setAttribute("StudentCounter", StudentCounter);
				request.setAttribute("TeacherCounter", TeacherCounter);
				request.setAttribute("jeeFisrtMark", jeeFisrtMark);
				request.setAttribute("jeeLastMark", jeeLastMark);
				request.setAttribute("frameworksFirstMark", frameworksFirstMark);
				request.setAttribute("frameworksLastMark", frameworksLastMark);
				request.setAttribute("csFirstMark", csFirstMark);
				request.setAttribute("csLastMark", csLastMark);
				
				dispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			
		}
		
		else {
			
			HttpSession session= request.getSession();
			session.setAttribute("email", email);
			
			OperationsImp metier =new OperationsImp();
			
			try {
				ServletContext context = this.getServletContext();
	
				String subject=metier.getSubject(email);
				context.setAttribute("subject", subject);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			boolean result=metier.checkIfExistsUser(email,password);
	
			
			if(result) {
				dispatcher=request.getRequestDispatcher("StudentsMarksController");
				session.setAttribute("email", email);
				dispatcher.forward(request, response);
			}
		}
		
	}
}