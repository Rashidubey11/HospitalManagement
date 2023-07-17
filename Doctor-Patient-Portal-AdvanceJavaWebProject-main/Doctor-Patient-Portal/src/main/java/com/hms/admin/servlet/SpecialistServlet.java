package com.hms.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hms.dao.SpecialistDAO;
import com.hms.db.DBConnection;

@WebServlet("/addSpecialist")
public class SpecialistServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String specname = req.getParameter("specname");
		
		 
			
		
		SpecialistDAO specialistDAO = new SpecialistDAO(DBConnection.getConn());
		boolean f = specialistDAO.addSpecialist(specname);
		
		HttpSession session = req.getSession();
		
		if (f==true) {
			
			session.setAttribute("successMsg", "Specialist added.");
			resp.sendRedirect("admin/index.jsp");
			
		} else {
			session.setAttribute("errorMsg", "Something went wrong on server");
			resp.sendRedirect("admin/index.jsp");
		}
	}
	
	

}
