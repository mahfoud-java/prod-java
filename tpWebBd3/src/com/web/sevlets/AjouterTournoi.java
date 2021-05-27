package com.web.sevlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.Beans.Tournoi;
import com.web.Dao.DaoFactory;
import com.web.Dao.TournoiDaoImpl;

@WebServlet("/ajoutertournoi")
public class AjouterTournoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TournoiDaoImpl tournoidaoimpl;
    public AjouterTournoi() {
        super();
        tournoidaoimpl = new TournoiDaoImpl(DaoFactory.getInstance());
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/WEB-INF/ajoutertournoi.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String nom = request.getParameter("txtNom");
				String code = request.getParameter("txtCode");
				Tournoi tournoi = new Tournoi();
				tournoi.setNom(nom);
				tournoi.setCode(code);
				tournoidaoimpl.ajouter(tournoi);
				response.sendRedirect("/tpWebBd3/listertournoi");
				
	}

}
