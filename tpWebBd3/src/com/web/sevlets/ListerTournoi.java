package com.web.sevlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.Beans.Tournoi;
import com.web.Dao.DaoFactory;
import com.web.Dao.TournoiDaoImpl;

@WebServlet("/listertournoi")
public class ListerTournoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TournoiDaoImpl tournoidaoimpl;
    public ListerTournoi() {
    	 super();
    	tournoidaoimpl = new TournoiDaoImpl(DaoFactory.getInstance());
       
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Tournoi> listeJ = new ArrayList<>();
		listeJ = tournoidaoimpl.lister();
		
		request.setAttribute("listeTournois", listeJ);
		request.getServletContext().getRequestDispatcher("/WEB-INF/listertournoi.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
