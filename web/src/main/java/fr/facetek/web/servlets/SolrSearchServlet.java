/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.web.servlets;
import fr.facetek.web.model.SearchResult;
import static fr.facetek.web.utils.SolrService.*;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dlebert
 */
public class SolrSearchServlet extends HttpServlet {


    public static final String VUE = "/WEB-INF/solrSearch.jsp";
    public static final String CHAMP_RECHERCHE = "search";

    @Override
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

         this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    
    @Override
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Traitement des données du formulaire */
        String recherche = request.getParameter( CHAMP_RECHERCHE );

        // Reset all
        try {
            //SolrService.deleteAllDocument();
            SearchResult result = searchEn(recherche);
            request.setAttribute("result", result);    
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        
        } catch (Exception ex) {
            Logger.getLogger(ServletHelloWorld.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
