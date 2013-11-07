/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.web.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dlebert
 */
public class SearchResult {
    
    private List<MatchedDocument> matchedDocuments = new ArrayList<>();
    private int nbrDocument;

    /**
     * @return the matchedDocuments
     */
    public List<MatchedDocument> getMatchedDocuments() {
        return matchedDocuments;
    }

    /**
     * @param matchedDocuments the matchedDocuments to set
     */
    public void setMatchedDocuments(List<MatchedDocument> matchedDocuments) {
        this.matchedDocuments = matchedDocuments;
        this.nbrDocument = matchedDocuments.size();
    }
    
    public void addMatchedDocument(MatchedDocument matchedDocument){
        this.matchedDocuments.add(matchedDocument);
        this.nbrDocument++;
    }
    
    public int getNbrDocument(){
        return nbrDocument;
    }
}
