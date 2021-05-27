package com.web.sevlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.Beans.Joueur;
import com.web.Dao.DaoFactory;
import com.web.Dao.JoueurDaoImpl;

@WebServlet("/listerjoueur")
public class ListerJoueur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JoueurDaoImpl joueurimpldao;
    public ListerJoueur() {
    	joueurimpldao = new JoueurDaoImpl(DaoFactory.getInstance());
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Joueur> listeJ = new ArrayList<>();
		listeJ = joueurimpldao.lister();
		
		request.setAttribute("listeJoueurs", listeJ);
		request.getServletContext().getRequestDispatcher("/WEB-INF/listerjoueur.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Joueur> listeJ = new ArrayList<>();
		listeJ = joueurimpldao.rechercher(request.getParameter("txtsearch"));
		request.setAttribute("listeJoueurs", listeJ);
		request.getServletContext().getRequestDispatcher("/WEB-INF/listerjoueur.jsp").forward(request, response);
	}

}
