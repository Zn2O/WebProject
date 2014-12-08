package com.servlet;

import interf.ComposantPanierRemote;
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
@WebServlet("/AjoutProduit")
public class AjoutProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB 
	ComposantPanierRemote produit;

    public AjoutProduitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Nom =request.getParameter("Nom");
		String Quantite = request.getParameter("Quantite");
		String Price = request.getParameter("Price");
		
		if(!Nom.isEmpty() && !Quantite.isEmpty() && !Price.isEmpty())
		{
			
			Produit currentProd = new Produit();
			currentProd.setNom(Nom);
			currentProd.setQuantite(Quantite);
			currentProd.setPrix(Price);
			
			produit.ajouterProduit();

			
			request.getSession().setAttribute("produit", currentProd);
			request.getRequestDispatcher("produit.jsp").forward(request, response);
		}
		else 
		{
			
			response.sendRedirect("index.jsp");
		}
	}

}
