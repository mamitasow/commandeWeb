package sn.commande.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.commande.entities.Commande;
import sn.commande.entities.Livraison;
import sn.commande.metier.ILivraisonLocal;

/**
 * Servlet implementation class LivraisonServlet
 */
@WebServlet(name = "Livraison", urlPatterns = { "/Livraison" })
public class LivraisonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private ILivraisonLocal livraison_dao;

    public LivraisonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Livraison> ListeLivraison = livraison_dao.liste();
		request.setAttribute("ListeLivraison", ListeLivraison);
		getServletContext().getRequestDispatcher("/view/livraison/add.jsp").forward(request, response);
		
		
		String idemp=request.getParameter("id");
		int id=Integer.parseInt(idemp);
		Livraison GetLivraisonById = livraison_dao.get(id);
		request.setAttribute("GetLivraisonById", GetLivraisonById );
		getServletContext().getRequestDispatcher("/view/Livraison/edit.jsp").forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
        String date = request.getParameter("date").toString();
        Livraison s = new Livraison();
        s.setDate(date);
        try {
	           livraison_dao.add(s);
	            
	            request.setAttribute("reussi", "Livraison enregistré");
	            List<Livraison> ListeLivraison = livraison_dao.liste();
	    		request.setAttribute("ListeLivraison", ListeLivraison);
	    		getServletContext().getRequestDispatcher("/view/livraison/add.jsp").forward(request, response);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	}

}
