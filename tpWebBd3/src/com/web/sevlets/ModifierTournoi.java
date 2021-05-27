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

@WebServlet("/modifiertournoi")
public class ModifierTournoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TournoiDaoImpl tournoidaoimpl;
	Tournoi tournoi;
    public ModifierTournoi() {
        super();
        tournoidaoimpl = new TournoiDaoImpl(DaoFactory.getInstance());
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idtournoi");
		tournoi = tournoidaoimpl.lecture(Long.parseLong(id));

		if (request.getParameter("action").equals("modifier")) {
			request.setAttribute("tournoi", tournoi);
			request.getServletContext().getRequestDispatcher("/WEB-INF/modifiertournoi.jsp").forward(request, response);
		} else {
			tournoidaoimpl.supprimer(Long.parseLong(id));
			response.sendRedirect("/tpWebBd3/listertournoi");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		tournoi.setNom(request.getParameter("txtNom"));
		tournoi.setCode(request.getParameter("txtCode"));
	
		tournoidaoimpl.modifier(tournoi);
		response.sendRedirect("/tpWebBd3/listertournoi");
		
	}

}
