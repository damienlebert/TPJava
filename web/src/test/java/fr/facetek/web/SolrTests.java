/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.web;


import static fr.facetek.web.utils.SolrService.*;

import org.junit.Test;


/**
 *
 * @author dlebert
 */
public class SolrTests {
    
    @Test
    public void solrTest() {
        try {

            // Reset all
            deleteAllDocument();
            
            //Solr cell can also index MS file (2003 version and 2007 version) types.
            String fileName = "C:/Travail/FaceTek/web/test.pdf"; 
            //this will be unique Id used by SolrService to index the file contents.
            String solrId = "test.pdf"; 
            indexFile(fileName, solrId);
            
            fileName = "C:/Travail/FaceTek/web/medical.pdf"; 
            //this will be unique Id used by SolrService to index the file contents.
            solrId = "medical.pdf"; 
            indexFile(fileName, solrId);
            fileName = "C:/Travail/FaceTek/web/test.json";
            solrId = "test.json"; 
            //indexFile(fileName, solrId);
            fileName = "C:/Travail/FaceTek/web/test.csv";
            solrId = "test.csv"; 
            //indexFile(fileName, solrId);

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

    }
        
}
