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

import fr.pwa.webservice.dao.ArticlesDAO;
import fr.pwa.webservice.model.Article;

/**
 * Servlet implementation class AutomateServlet
 */
@WebServlet("/listArticle")
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticlesDAO ArticlesDao;
    /**
     * Default constructor. 
     */
    public ArticleServlet() {
        // TODO Auto-generated constructor stub
    }
    public void init() {
        ArticlesDao = new ArticlesDAO();
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

                default:
                    listArticles(request, response);
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

	
	private void listArticles(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List<Article> listArt = ArticlesDao.listerArticles();
		        request.setAttribute("listArt", listArt);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("ListArticle.jsp");
		        dispatcher.forward(request, response);
		    }
 

		   
		   
}
