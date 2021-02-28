package fr.pwa.webservice.servlet;

import java.io.IOException;
import java.sql.SQLException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pwa.webservice.dao.RapportDAO;
import fr.pwa.webservice.model.Article;
import fr.pwa.webservice.model.Rapport;

/**
 * Servlet implementation class RapportServlet
 */
@WebServlet("/listRapport")
public class RapportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RapportDAO RapportDao;
    /**
     * Default constructor. 
     */
    public RapportServlet() {
        // TODO Auto-generated constructor stub
    }
    public void init() {
        RapportDao = new RapportDAO();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String action = request.getServletPath();

        try {
            switch (action) {
                case "/delete1":
                    DeleteRapport(request, response);
                    break;
                case "/reap":
                	listReaprovisionnement(request, response);
                    break;
                default:
                    listRapport(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	private void listRapport(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List < Rapport > listRapport = RapportDao.listerRapports();
		        request.setAttribute("listRapport", listRapport);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("ListRapport.jsp");
		        dispatcher.forward(request, response);
		    }
	private void listReaprovisionnement(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List < Article > listArt = RapportDao.reaprovisionnement();
		        request.setAttribute("listArt", listArt);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("ListArticle.jsp");
		        dispatcher.forward(request, response);
		    }


		    
		    private void DeleteRapport(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        RapportDao.SupprimerRapport(id);
		        response.sendRedirect("listRapport");
		    }
}
