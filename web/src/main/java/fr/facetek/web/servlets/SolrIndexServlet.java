/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.web.servlets;
import static fr.facetek.web.utils.SolrService.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.solr.client.solrj.SolrServerException;

/**
 *
 * @author dlebert
 */
public class SolrIndexServlet extends HttpServlet {
    
    public static final String VUE = "/WEB-INF/solrIndex.jsp";
    public static final String GET_ACTION = "action";
    public static final String CHAMP_FILE = "fileToExtract";

    
    @Override
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
         
        String action = request.getParameter( GET_ACTION );
        if (action != null){

            if ( action.equals("indexall")){
                try {
                    indexFile();
                    request.setAttribute("indexSuccess", "L'indexation à été efectué avec succès");

                 } catch (SolrServerException ex) {
                     Logger.getLogger(SolrIndexServlet.class.getName()).log(Level.SEVERE, null, ex);
                 }
             } 
        }

        List< String > solrDocumentList = new ArrayList<>();
        try{
            solrDocumentList = getListDocument();
            for( String curDocument : solrDocumentList){
             
                 System.out.println(curDocument);
            }
        } catch ( SolrServerException ex){
            Logger.getLogger(SolrIndexServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("solrDocuments", solrDocumentList);
        List<String> toIndexDocumentList = getDocumentToIndex();
        request.setAttribute("toIndexDocuments", toIndexDocumentList);
        
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
       
    }
    
    @Override
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Traitement des données du formulaire */
        String solrId = "";
        String fileName = request.getParameter( CHAMP_FILE );
        
        
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        
       
    }
    
}
