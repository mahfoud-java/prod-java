package com.web.sevlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.Beans.Epreuve;
import com.web.Beans.Joueur;
import com.web.Beans.Match;
import com.web.Beans.Tournoi;
import com.web.Dao.DaoFactory;
import com.web.Dao.EpreuveDaoImpl;
import com.web.Dao.JoueurDaoImpl;
import com.web.Dao.MatchDaoImpl;
import com.web.Dao.TournoiDaoImpl;

@WebServlet("/listermatch")
public class ListerMatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MatchDaoImpl matchimpldao;

	private JoueurDaoImpl joueurimpldao;
	
    public ListerMatch() {
    	matchimpldao = new MatchDaoImpl(DaoFactory.getInstance());
    	
    	joueurimpldao = new JoueurDaoImpl(DaoFactory.getInstance());
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Match> listeM = new ArrayList<>();
		
		listeM = matchimpldao.lister();
		
		for (Match match : listeM) {
			match.setJoueurF(joueurimpldao.lecture(match.getIdFinaliste()));
			match.setJoueurV(joueurimpldao.lecture(match.getIdVainqueur()));
		}
	
		
		request.setAttribute("listeMatchs", listeM);
	
		request.getServletContext().getRequestDispatcher("/WEB-INF/listermatch.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
