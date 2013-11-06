/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.web.utils;

import fr.facetek.web.model.MatchedDocument;
import fr.facetek.web.model.SearchResult;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.request.AbstractUpdateRequest;
import org.apache.solr.client.solrj.request.ContentStreamUpdateRequest;
import org.apache.solr.client.solrj.request.QueryRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.TermsResponse;
import org.apache.solr.client.solrj.response.TermsResponse.Term;
import org.apache.solr.common.util.ContentStream;
import org.apache.solr.common.util.ContentStreamBase;

/**
 *
 * @author dlebert
 */
public class SolrService {
    
 
    
    /**
    * Method to index all types of files into SolrService. 
    * @param fileName
    * @param solrId
    * @throws IOException
    * @throws SolrServerException
    */

    
    public static void indexFile(String fileName, String solrId) throws SolrServerException, IOException{
        
        SolrServer server = new HttpSolrServer("http://localhost:8983/solr");
        server.ping();
        ContentStreamUpdateRequest up = new ContentStreamUpdateRequest("/update/extract");
        ContentStreamBase.FileStream csb = new ContentStreamBase.FileStream(new File(fileName)); 

        up.addContentStream((ContentStream)csb);
        up.setParam("literal.id", solrId);
        //up.setParam("Content-type", "application/pdf");
        up.setAction(AbstractUpdateRequest.ACTION.COMMIT, true, true);
        server.request(up);
        
    }
    
    /**
     * Method to delete every document indexed on the server
     * @throws SolrServerException
     * @throws IOException 
     */
    public static void deleteAllDocument() throws SolrServerException, IOException{
       
        SolrServer server = new HttpSolrServer("http://localhost:8983/solr");
        server.deleteByQuery( "*:*" );
        server.commit(); 
    }
    
    /**
     * Method to retrieve terms contain in all document matching a specific prefix
     * @throws SolrServerException
     * @throws IOException 
     */
    public static Map<String , List<Term>> getAutoComplete(String prefix) throws SolrServerException, IOException{
       
        SolrServer server = new HttpSolrServer("http://localhost:8983/solr");
        
        SolrQuery query = new SolrQuery();
        query.setRequestHandler("/terms");
        query.setTermsPrefix(prefix);
        QueryRequest request = new QueryRequest(query);
        Map<String , List<Term>> terms = request.process(server).getTermsResponse().getTermMap();
        
        return terms; 
    }

    public static String showTerms (Map<String , List<Term>> termsMap) throws SolrServerException, IOException{
          
        String result = "";
        for(Map.Entry<String, List<TermsResponse.Term>> entry : termsMap.entrySet()) {
            
            String cle = entry.getKey();
            List<Term> terms = entry.getValue();
            // traitements
            result += "Clé : " + cle + " -------------------------------------------<br />";
            System.out.println(cle);
            System.out.println(terms.size());
            for (TermsResponse.Term term : terms){
                result += term.getTerm() + "<br />";
                System.out.println(term.getTerm());
            }

        }
        return result;
      }
    
    
    
    public static SearchResult searchEn(String search) throws SolrServerException, IOException{

        SearchResult result = new SearchResult();
        
        SolrServer server = new HttpSolrServer("http://localhost:8983/solr");

        SolrQuery query = new SolrQuery();
        query.setRequestHandler("/searchEn");
        query.setQuery(search);
        QueryRequest request = new QueryRequest(query);
        QueryResponse response = request.process(server);   

        for (Map.Entry<String,Map<String,List<String>>> doc : response.getHighlighting().entrySet()){
            
            MatchedDocument curDocument = new MatchedDocument();
            
            curDocument.setId(doc.getKey());
            
            Map< String, List< String > > documentHighlighting = doc.getValue();
            for (Map.Entry<String,List<String>> hl : documentHighlighting.entrySet()){
                
                curDocument.setHighlights(hl.getValue());
            }
            result.addMatchedDocument(curDocument);
        }
        return result;
    }
    
    
}
