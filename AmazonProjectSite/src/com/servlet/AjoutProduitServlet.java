package com.servlet;

import interf.ComposantProduitRemote;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comp.Produit;

/**
 * Servlet implementation class AjoutProduit
 */
@WebServlet("/AjoutProduitServlet")
public class AjoutProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB 
	ComposantProduitRemote produit;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello");
		/*String Nom =request.getParameter("Nom");
		String Quantite = request.getParameter("Quantite");
		String Prix = request.getParameter("Prix");
		
		if(!Nom.isEmpty() && !Quantite.isEmpty() && !Prix.isEmpty())
		{
			
			Produit currentProd = new Produit();
			currentProd.setNom(Nom);
			currentProd.setQuantite(Quantite);
			currentProd.setPrix(Prix);
			
			produit.NouveauProduit();

			
			request.getSession().setAttribute("produit", currentProd);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
		else 
		{
			
			response.sendRedirect("index.jsp");
		}
	}*/
	}
}
