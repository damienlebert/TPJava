/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.web.utils;

import fr.facetek.web.error.SearchException;
import fr.facetek.web.model.MatchedDocument;
import fr.facetek.web.model.SearchResult;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.request.AbstractUpdateRequest;
import org.apache.solr.client.solrj.request.ContentStreamUpdateRequest;
import org.apache.solr.client.solrj.request.QueryRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.util.ContentStream;
import org.apache.solr.common.util.ContentStreamBase;

/**
 *
 * @author dlebert
 */
public class SolrService {
    
    private static final SolrServer server = new HttpSolrServer("http://localhost:8983/solr");
    private static final String dirFileToIndex = "C:/Travail/";
    
    /**
    * Method to index all types of files into SolrService. 
    * @param fileName
    * @param solrId
    * @throws IOException
    * @throws SolrServerException
    */

    
    public static void indexFile() throws SolrServerException, IOException{
        
        List<String> listDocumentToIndex = getDocumentToIndex();
        ContentStreamUpdateRequest up = new ContentStreamUpdateRequest("/update/extract");
        for ( String curDocument : listDocumentToIndex){
            
            ContentStreamBase.FileStream csb = new ContentStreamBase.FileStream(new File(dirFileToIndex+curDocument)); 
            up.addContentStream((ContentStream)csb);
            up.setParam("literal.id", curDocument);
            //up.setParam("Content-type", "application/pdf");
            up.setAction(AbstractUpdateRequest.ACTION.COMMIT, true, true);
            server.request(up);
        }
       
    }
    
    /**
     * Method to delete every document indexed on the server
     * @throws SolrServerException
     * @throws IOException 
     */
    public static void deleteAllDocument() throws SolrServerException, IOException{
       
        server.deleteByQuery( "*:*" );
        server.commit(); 
    }
    
    public static List< String > getListDocument() throws SolrServerException{
        
        List< String > listDocuments = new ArrayList<>();
        
        SolrQuery query = new SolrQuery("*:*");
        query.setRequestHandler("/select");
        query.setFields("id");
        QueryRequest request = new QueryRequest(query);
        
        QueryResponse response = request.process(server);
        if (!response.getResults().isEmpty()){
            
            for (SolrDocument curDocument : response.getResults()){
                
                listDocuments.add((String)curDocument.get("id"));
            }
        }
        return listDocuments;
    }
    
    public static List< String > getDocumentToIndex(){
        
        List<String> fileNameList = new ArrayList<>();
        File dir = new File("C:/Travail");
        File[] fileList = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".pdf");
            }
        });
        for (File curFile : fileList){
            fileNameList.add(curFile.getName().toLowerCase());
        }
        return fileNameList;
    }
    
    /**
     * Send the search query (parameter search) to the solr server and return the result   
     * @param search
     * @return {@link SearchResult}
     * @throws SolrServerException
     * @throws IOException 
     */
    public static SearchResult searchEn(String search) throws SolrServerException, IOException, SearchException{
        
        // Var to return
        SearchResult result = new SearchResult();
        
        // Creating the query
        SolrQuery query = new SolrQuery();
        query.setRequestHandler("/searchEn");
        query.setQuery(search);
        QueryRequest request = new QueryRequest(query);
        
        // Sending the query and retrieving response
        QueryResponse response = request.process(server);   
        
        // Analysing response from solr 
        if (response.getResults().isEmpty()){
            throw new SearchException("Aucun document ne correspond aux termes de recherche spécifiés");
        }
        
        //Retrieving matched document ids
        for (SolrDocument curDocument : response.getResults()){
            
            MatchedDocument curMatchedDocument = new MatchedDocument();

            curMatchedDocument.setId((String)curDocument.get("id"));
            
            // Retrieving highlights for the current document
            Map< String, List< String > > curDocumentHighlighting = response.getHighlighting().get(curMatchedDocument.getId());
            for (Map.Entry<String,List<String>> hl : curDocumentHighlighting.entrySet()){
                
                curMatchedDocument.setHighlights(hl.getValue());
            }
            result.addMatchedDocument(curMatchedDocument);
        }
        return result;
    }
}
