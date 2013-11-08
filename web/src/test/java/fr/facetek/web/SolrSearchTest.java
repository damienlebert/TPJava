/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.web;
import fr.facetek.web.error.SearchException;
import fr.facetek.web.model.SearchResult;
import static fr.facetek.web.utils.SolrService.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.solr.client.solrj.SolrServerException;
import static org.junit.Assert.*;
import org.junit.Test;


/**
 *
 * @author dlebert
 */
public class SolrSearchTest {
    
    private String failSearch = "une recherche pourri";
    private String successfulSearch = "mandatory medical standards found in Regulation";
    
    @Test
    public void solrTest() throws SolrServerException, IOException {

        SearchResult searchResult = null;
        try {
            searchResult = searchEn(successfulSearch);
        } catch (SearchException ex) {
            
        }
        assertNotNull("fr.facetek.web.utils.SolrService.searchEn - Successful research should return a not null SearchResult object", searchResult);
        
        
        searchResult = null;
        try {
            searchResult = searchEn(failSearch);
        } catch (SearchException ex) {
            //expected error
        }
        assertNull("fr.facetek.web.utils.SolrService.searchEn - Fail research should throw an error", searchResult);      
    
    }
    
     @Test
    public void solrListDocuments() throws SolrServerException, IOException {
         
         List< String > solrDocumentList;
         solrDocumentList = getListDocument();
         
         for( String curDocument : solrDocumentList){
             
             System.out.println(curDocument);
         }
         
     }
    
}
