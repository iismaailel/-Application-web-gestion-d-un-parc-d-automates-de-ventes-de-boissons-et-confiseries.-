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

import fr.pwa.webservice.dao.AutomateDAO;
import fr.pwa.webservice.model.Automate;

/**
 * Servlet implementation class AutomateServlet
 */
@WebServlet("/")
public class AutomateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AutomateDAO AutomateDao;
    /**
     * Default constructor. 
     */
    public AutomateServlet() {
        // TODO Auto-generated constructor stub
    }
    public void init() {
        AutomateDao = new AutomateDAO();
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
                case "/newautomate":
                    showForm(request, response);
                    break;
                case "/insertautomate":
                    insertAutomate(request, response);
                    break;
                case "/deleteautomate":
                    Delete(request, response);
                    break;
                case "/modifautomate":
                    Edit(request, response);
                    break;
            
                case "/modifierautomate":
                	update(request, response);
                    break;

                default:
                    list_Automate(request, response);
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

	
	private void list_Automate(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List<Automate> listAuto = AutomateDao.listerAutomates();
		        request.setAttribute("listAuto", listAuto);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("ListAutomate.jsp");
		        dispatcher.forward(request, response);
		    }

	private void showForm(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        RequestDispatcher dispatcher = request.getRequestDispatcher("AjouterAutomate.jsp");
		        dispatcher.forward(request, response);
		    }

	private void Edit(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        String numSerie= request.getParameter("numSerie");
		        Automate existingUser = AutomateDao.fetchAuto(numSerie);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("AjouterAutomate.jsp");
		        request.setAttribute("Automate", existingUser);
		        dispatcher.forward(request, response);

		    }

	private void insertAutomate(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        String numSerie = request.getParameter("numSerie");
		        String typeT = request.getParameter("typeT");
		        String type = request.getParameter("type");
		        String adresse_installation = request.getParameter("adresse_insta");
		        String emplacement = request.getParameter("emplacement");
		        double gps_lat =  Double.parseDouble(request.getParameter("gpsLatitude"));
		        double gps_long =  Double.parseDouble(request.getParameter("gpsLongitude"));
		        String date_dern_intervention = request.getParameter("date_dern_intervention");
		        String notes = request.getParameter("notes");
		 
		        Automate newAutomate = new Automate(numSerie,typeT, type, adresse_installation,emplacement,gps_lat,gps_long,date_dern_intervention,notes);
		        AutomateDao.AjouterAutomate(newAutomate);
		        response.sendRedirect("list");
		    }

		    
	private void Delete(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        String numSerie = request.getParameter("numSerie");
		        AutomateDao.supprimerAutomate(numSerie);
		        response.sendRedirect("list");

		    }
	

		    
	private void update(HttpServletRequest request, HttpServletResponse response)
		    	    throws SQLException, IOException {
		    	        String numSerie = request.getParameter("numSerie");
		    	        String typeT = request.getParameter("typeT");
		    	        String type = request.getParameter("type");
				        String adresse_installation = request.getParameter("adresse_insta");
				        String emplacement = request.getParameter("emplacement");
				        double gps_lat =  Double.parseDouble(request.getParameter("gpsLatitude"));
				        double gps_long =  Double.parseDouble(request.getParameter("gpsLongitude"));
				        String date_dern_intervention = request.getParameter("date_dern_intervention");
				        String notes = request.getParameter("notes");
		    	        Automate automate1 = new Automate(numSerie,typeT, type, adresse_installation, emplacement,gps_lat,gps_long,date_dern_intervention,notes);
		    	        AutomateDao.modifierAuto(automate1);
		    	        response.sendRedirect("list");
		    	    }
}
