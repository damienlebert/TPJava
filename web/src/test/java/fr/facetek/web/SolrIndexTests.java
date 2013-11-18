/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.web;


import static fr.facetek.web.utils.SolrService.*;
import java.io.IOException;
import java.util.List;
import org.apache.solr.client.solrj.SolrServerException;

import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author dlebert
 */
public class SolrIndexTests {
    
    @Test
    public void solrTest() throws SolrServerException, IOException {

            // Delete solr index 
            deleteAllDocument();
            
            List< String > solrDocumentList;
            solrDocumentList = getIndexedDocuments();
            assertTrue("fr.facetek.web.utils.SolrService.deleteAllDocuments() - Solr index should be empty after this method", solrDocumentList.isEmpty());
            
            // Index all files 
            indexFile();
            
            solrDocumentList = getIndexedDocuments();
            
            List< String > documentsToIndexList;
            documentsToIndexList = getDocumentsToIndex();
            
            assertTrue("fr.facetek.web.utils.SolrService.indexFile - Some documents may have not been indexed correctly", solrDocumentList.containsAll(documentsToIndexList));
            
    }
        
}
