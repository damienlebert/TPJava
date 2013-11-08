/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.web;


import static fr.facetek.web.utils.SolrService.*;
import java.io.IOException;
import org.apache.solr.client.solrj.SolrServerException;

import org.junit.Test;


/**
 *
 * @author dlebert
 */
public class SolrTests {
    
    @Test
    public void solrTest() throws SolrServerException, IOException {


            // Reset all
            deleteAllDocument();

            indexFile();


    }
        
}
