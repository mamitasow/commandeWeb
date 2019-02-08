package sn.commande.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sn.commande.metier.ICommandeLocal;
import sn.commande.metier.ILivraisonLocal;
import sn.commande.metier.IUserLocal;
import sn.commande.entities.*;

/**
 * Servlet implementation class CommandeServlet
 */
@WebServlet(name = "Commande", urlPatterns = { "/Commande" })
public class CommandeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@EJB
	private ICommandeLocal commande_dao;
	@EJB
	private ILivraisonLocal livraison_dao;
    public CommandeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Livraison> ListeLivraison = livraison_dao.liste();
		request.setAttribute("ListeLivraison", ListeLivraison);
	        
	        if (request.getParameter("page") != null)
	    		
			{
				
				String page = request.getParameter("page").toString();
				if(page.equals("add")) {
					List<Commande> ListeCommande = commande_dao.liste();
					request.setAttribute("ListeCommande", ListeCommande);
					getServletContext().getRequestDispatcher("/view/commande/add.jsp").forward(request, response);
				
				}else if(page.equals("edit")) {
					String idemp=request.getParameter("id");
					int id=Integer.parseInt(idemp);
					Commande GetCommandeById = commande_dao.get(id);
					request.setAttribute("GetCommandeById", GetCommandeById );
					getServletContext().getRequestDispatcher("/view/commande/edit.jsp").forward(request, response);
			}else if(page.equals("livrer")) {
				String idemp=request.getParameter("id");
				int id=Integer.parseInt(idemp);
				Commande GetCommandeById = commande_dao.get(id);
				request.setAttribute("GetCommandeById", GetCommandeById );
				request.setAttribute("action", "livrer" );
				getServletContext().getRequestDispatcher("/view/commande/add.jsp").forward(request, response);
		}else if(page.equals("cancel")) {
			String idemp=request.getParameter("id");
			int id=Integer.parseInt(idemp);
			Commande cm = commande_dao.get(id);
			cm.setEtat("annuler");
			commande_dao.update(cm);
			List<Commande> ListeCommande = commande_dao.liste();
			request.setAttribute("ListeCommande", ListeCommande);
			getServletContext().getRequestDispatcher("/view/commande/add.jsp").forward(request, response);
	}
		else if(page.equals("delete")) {
			String idemp=request.getParameter("id");
			int id=Integer.parseInt(idemp);
			
			commande_dao.delete(id);
			List<Commande> ListeCommande = commande_dao.liste();
			request.setAttribute("ListeCommande", ListeCommande);
			getServletContext().getRequestDispatcher("/view/commande/add.jsp").forward(request, response);
	}
			}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		if(request.getParameter("action").equals("add")) {
			String livraison = request.getParameter("date");
		      Commande s = new Commande();
		        s.setLibelle(request.getParameter("libelle"));
		        s.setDatecommande(new Date());
		        s.setMontant(Double.parseDouble(request.getParameter("montant").toString()));
		       
		        User user =(User)request.getSession().getAttribute("user_session");
		        s.setUser(user);
		        
		       /* if(livraison.) {
		        	 s.setLivraison(null);
		        }else
		        s.setLivraison(livraison_dao.get(livraison));*/
		        if(livraison.length()<10)
		        {
		        	 s.setEtat(request.getParameter("etat"));
		        	s.setLivraison(null);
		        }else {
		        	
		        	Livraison l = new Livraison();
		        	l.setDate(livraison);
		        int ok=	livraison_dao.add(l);
		        s.setLivraison(livraison_dao.get(ok));
		        s.setEtat("livrer");
		        	        }
		        
		         
		       
		        try {
		           commande_dao.add(s);
		            
		            request.setAttribute("reussi", "commande enregistré");
		            List<Commande> ListeCommande = commande_dao.liste();
					request.setAttribute("ListeCommande", ListeCommande);
					getServletContext().getRequestDispatcher("/view/commande/add.jsp").forward(request, response);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		}else if(request.getParameter("action").equals("livrer")) {
			Commande cm = new Commande();
		int idcm=Integer.parseInt(request.getParameter("idcmd"));
		cm=commande_dao.get(idcm);
		String livraison = request.getParameter("date");
		Livraison l = new Livraison();
    	l.setDate(livraison);
    	 User user =(User)request.getSession().getAttribute("user_session");
    	    l.setUser(user);
           int ok=	livraison_dao.add(l);
           double montant = Double.parseDouble(request.getParameter("montant").toString());
   		String libelle =request.getParameter("libelle").toString();
           cm.setLivraison(livraison_dao.get(ok));
           cm.setMontant(montant);
           cm.setLibelle(libelle);
           cm.setDatecommande(new Date());
           cm.setEtat("livrer");
           cm.setUser(user);
		commande_dao.update(cm);
		 request.setAttribute("reussi", "commande enregistré");
         List<Commande> ListeCommande = commande_dao.liste();
			request.setAttribute("ListeCommande", ListeCommande);
			getServletContext().getRequestDispatcher("/view/commande/add.jsp").forward(request, response);
			
		}else if(request.getParameter("action").equals("edit")) {
			Commande cm = new Commande();
		int idcm=Integer.parseInt(request.getParameter("idcmd"));
		cm=commande_dao.get(idcm);
		Livraison l = new Livraison();
		String datel = request.getParameter("livraison");
    	l.setDate(datel);
    	double mnt = Double.parseDouble(request.getParameter("montant").toString());
		String lib =request.getParameter("libelle").toString();
		String etat =request.getParameter("etat").toString();
		cm=commande_dao.get(idcm);
		cm.setLibelle(lib);
		cm.setMontant(mnt);
		cm.setEtat(etat);
		cm.setDatecommande(new Date());
		if(cm.getLivraison()!=null) {
			
			l=livraison_dao.get(cm.getLivraison().getId());

		}else {
			int ok=livraison_dao.add(l);
			l=livraison_dao.get(ok);
			
		}
		
    int ok1=livraison_dao.update(l);
    cm.setLivraison(livraison_dao.get(ok1));
		commande_dao.update(cm);
		 request.setAttribute("reussi", "commande enregistré");
         List<Commande> ListeCommande = commande_dao.liste();
			request.setAttribute("ListeCommande", ListeCommande);
			getServletContext().getRequestDispatcher("/view/commande/add.jsp").forward(request, response);
			
		}
		 
	}

}
