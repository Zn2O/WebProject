package com.servlet;

import interf.ComposantPanierRemote;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.client.Utilisateur;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	@EJB 
	ComposantPanierRemote panier;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet()
    {
        super();
        // TODO Auto-generated constructor stub
    }
    	protected void doGet(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException{
		
		reponse.sendRedirect("index.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException{
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		if(!login.isEmpty() && !password.isEmpty())
		{
			
			Utilisateur currentUser = new Utilisateur();
			currentUser.setLogin(login);
			currentUser.setPassword(password);
			
			panier.ajouterProduit();
			
			request.getSession().setAttribute("utilisateur", currentUser);
			request.getRequestDispatcher("content.jsp").forward(request, reponse);
		}
		else 
		{
			
			reponse.sendRedirect("index.jsp");
		}
	}
}
