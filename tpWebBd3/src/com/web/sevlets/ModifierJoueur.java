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

@WebServlet("/modifierjoueur")
public class ModifierJoueur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JoueurDaoImpl joueurdaoimpl;
	private Joueur joueur;

	public ModifierJoueur() {
		super();
		joueurdaoimpl = new JoueurDaoImpl(DaoFactory.getInstance());

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("idjoueur");
		joueur = joueurdaoimpl.lecture(Long.parseLong(id));

		if (request.getParameter("action").equals("modifier")) {
			request.setAttribute("joueur", joueur);
			request.getServletContext().getRequestDispatcher("/WEB-INF/modifierjoueur.jsp").forward(request, response);
		} else {
			joueurdaoimpl.supprimer(Long.parseLong(id));
			response.sendRedirect("/tpWebBd3/listerjoueur");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		joueur.setNom(request.getParameter("txtNom"));
		joueur.setPrenom(request.getParameter("txtPrenom"));
		joueur.setSexe(request.getParameter("opSexe"));
		joueurdaoimpl.modifier(joueur);
		response.sendRedirect("/tpWebBd3/listerjoueur");

	}

}
