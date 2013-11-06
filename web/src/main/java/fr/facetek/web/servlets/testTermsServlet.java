/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.web.servlets;

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
public class testTermsServlet extends HttpServlet {

    public static final String VUE = "/WEB-INF/testTerms.jsp";
    public static final String CHAMP_PREFIX = "prefix";
    
    @Override
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
         
         this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    @Override
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Traitement des données du formulaire */
        String prefix = request.getParameter( CHAMP_PREFIX );
        
        // Reset all
        try {
            //SolrService.deleteAllDocument();
            String result = showTerms(getAutoComplete(prefix));
            System.out.println("");
            request.setAttribute("result", result);
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        } catch (Exception ex) {
            Logger.getLogger(ServletHelloWorld.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}