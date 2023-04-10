package com.techpalle.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.dao.DataAccess;
import com.techpalle.model.Customer;
import com.techpalle.util.SuccessPage;


@WebServlet("/")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String path=request.getServletPath();
		switch(path) 
		{
		case"/logCustomer":
			validateCustomer(request,response);
			break;
		case"/log":
			getLoginPage(request,response);
			break;
		case"/regCustomer":
			insertCustomer(request,response);
			break;
		case"/reg":
			getRegistrationPage(request,response);
			break;
		default:
				getStartUpPage(request,response);
				break;
		}
	}

	
	private void validateCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
		//read email and password from jsp page
		String e=request.getParameter("tbEmailLog");
		String p=request.getParameter("tbPassLog");
		//call the method present in DAO
		boolean b=DataAccess.validateCustomer(e,p);
		// condition and redirect user to destination page(Success)
		if(b) {
			try {		
				RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
				
				//Store the SuccessPage class data inside RD
				SuccessPage sp=new SuccessPage();
  		
				request.setAttribute("successDetails", sp );
				rd.forward(request, response);
			} catch (ServletException | IOException e1) {
				e1.printStackTrace();
			}
			
		}else {
			getLoginPage(request,response);
		}
			
		
	}


	private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// Read the data from jsp page
		String n=request.getParameter("tbName");
		String e=request.getParameter("tbemail");
		long m=Long.parseLong(request.getParameter("tbMbl"));
		String p=request.getParameter("tbPassword");
		String s=request.getParameter("ddlstates");
		
		//store that data in customer object
		Customer c=new Customer(n,e,m,p,s);
		// call insertCustomer method present in dao by passing above object
		DataAccess.insertCustomer(c);
		
		// redirect user to login page
				  
		RequestDispatcher rd=request.getRequestDispatcher("customer_login.jsp");
 
		rd.forward(request, response);
		
	}


	private void getRegistrationPage(HttpServletRequest request, HttpServletResponse response) {
		try {		
			RequestDispatcher rd=request.getRequestDispatcher("customer_registration.jsp");

			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}


	private void getLoginPage(HttpServletRequest request, HttpServletResponse response)
	{
		try {		
			RequestDispatcher rd=request.getRequestDispatcher("customer_login.jsp");

			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}


	private void getStartUpPage(HttpServletRequest request, HttpServletResponse response) 
	{
		try {		
			RequestDispatcher rd=request.getRequestDispatcher("Customer_Management.jsp");

			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

