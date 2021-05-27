package com.web.sevlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.Beans.User;
import com.web.Dao.DaoFactory;
import com.web.Dao.UserDaoImpl;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userdaoimpl;
  
    public Login() {
       
    	userdaoimpl = new UserDaoImpl(DaoFactory.getInstance());
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = userdaoimpl.isValideLogin(request.getParameter("txtLogin"), request.getParameter("txtPassword"));
		
		if(user != null) {
			response.sendRedirect("/tpWebBd3/listerjoueur");
			return;
		}
		this.doGet(request, response);
	}

}
