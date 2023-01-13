package com.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public HomeController() {
        super();
    }
    
    
    RequestDispatcher dispatcher;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		dispatcher=request.getRequestDispatcher("/WEB-INF/Views/Home.jsp");
		dispatcher.forward(request, response);


	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
