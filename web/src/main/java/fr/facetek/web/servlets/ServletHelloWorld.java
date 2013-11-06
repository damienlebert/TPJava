/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.web.servlets;

import fr.facetek.web.utils.SolrService;
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
public class ServletHelloWorld extends HttpServlet {
    
    public static final String VUE = "/WEB-INF/helloWorld.jsp";
    public static final String CHAMP_SOLRID = "solrId";
    public static final String CHAMP_FILE = "file";
    
    @Override
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
         
         this.getServletContext().getRequestDispatcher( "/WEB-INF/helloWorld.jsp" ).forward( request, response );
    }
    @Override
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Traitement des données du formulaire */
        String solrId = request.getParameter( CHAMP_SOLRID );
        String fileName = request.getParameter( CHAMP_FILE );
        
        // Reset all
            
        
        try {
            //SolrService.deleteAllDocument();
            SolrService.indexFile(fileName, solrId);
        } catch (Exception ex) {
            Logger.getLogger(ServletHelloWorld.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
