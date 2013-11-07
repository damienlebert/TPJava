/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.web;
import fr.facetek.web.error.SearchException;
import static fr.facetek.web.utils.SolrService.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.solr.client.solrj.SolrServerException;
import org.junit.Test;

/**
 *
 * @author dlebert
 */
public class SolrSearchTest {
    
    @Test
    public void solrTest() throws SolrServerException, IOException {
        try {
            searchEn("une recherche pourri");
        } catch (SearchException ex) {
            Logger.getLogger(SolrSearchTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    }
    
}
