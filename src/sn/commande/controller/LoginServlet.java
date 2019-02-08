package sn.commande.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.commande.entities.*;

import sn.commande.metier.IUserLocal;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private IUserLocal user_dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getSession().getAttribute("user_session")==null) {
			request.getRequestDispatcher("index.jsp").forward(request,response);
		}else {
			request.getRequestDispatcher("acceuil.jsp").forward(request,response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String email=request.getParameter("email").toString();
		 String password=request.getParameter("pass").toString();
		 User user = user_dao.verifUser(email, password);
		 if(user!=null) {
			 
			
			 request.setAttribute("user",user);
			 request.getSession().setAttribute("user_session",user);
			 response.sendRedirect("Welcome");
			     
		 }else {
			    	  request.setAttribute("error_login", "yes");
			    	  request.getRequestDispatcher("index.jsp")
			    	           .forward(request, response);
			      }
		 }
	}


