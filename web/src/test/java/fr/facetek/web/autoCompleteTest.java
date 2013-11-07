/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.web;

import fr.facetek.web.error.SearchException;
import java.util.List;
import java.util.Map;
import org.apache.solr.client.solrj.response.TermsResponse;
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
public class autoCompleteTest {
    
        @Test
        public void testAutoComplete(){
            try {
                /*
                solrTermTest("thr");
                solrTermTest("gar");
                solrTermTest("rip");
               solrTermTest("bra");
                solrTermTest("arr");
                */
     
                searchEn("available");
                
            } catch (SolrServerException ex) {
                Logger.getLogger(autoCompleteTest.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(autoCompleteTest.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SearchException ex) {
                Logger.getLogger(autoCompleteTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
    public void solrTermTest(String prefix) {
        try {
    
            System.out.println("Term Query START--------------------------------------------------------");
           
            Map<String, List<TermsResponse.Term>> termsMap = getAutoComplete(prefix);
            
            for(Map.Entry<String, List<TermsResponse.Term>> entry : termsMap.entrySet()) {
                String cle = entry.getKey();
                List<TermsResponse.Term> terms = entry.getValue();
                // traitements
                System.out.println(cle);
                System.out.println(terms.size());
                for (TermsResponse.Term term : terms){
                    
                    System.out.println(term.getTerm());
                }
                
            }

            System.out.println("Term Query END --------------------------------------------------------");

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

    }
        
}
