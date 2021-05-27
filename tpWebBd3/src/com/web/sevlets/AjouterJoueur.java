package com.web.sevlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.Beans.Joueur;
import com.web.Dao.DaoFactory;
import com.web.Dao.JoueurDaoImpl;

@WebServlet("/ajouterjoueur")
public class AjouterJoueur extends HttpServlet {

	private static final long serialVersionUID = 1L;
	JoueurDaoImpl joueurdaoimpl;
	public AjouterJoueur() {
        super();
        joueurdaoimpl = new JoueurDaoImpl(DaoFactory.getInstance());
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/WEB-INF/ajouterjoueur.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom = request.getParameter("txtNom");
		String prenom = request.getParameter("txtPrenom");
		String sexe = request.getParameter("opSexe");
		Joueur joueur = new Joueur();
		joueur.setNom(nom);
		joueur.setPrenom(prenom);
		joueur.setSexe(sexe);
		joueurdaoimpl.ajouter(joueur);
		response.sendRedirect("/tpWebBd3/listerjoueur");
		
	}

}
