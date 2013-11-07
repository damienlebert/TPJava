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
public class MatchedDocument {
    
    private String id;
    private List<String> highlights = new ArrayList<>();

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the highlights
     */
    public List<String> getHighlights() {
        return highlights;
    }

    /**
     * @param highlights the highlights to set
     */
    public void setHighlights(List<String> highlight) {
        this.highlights = highlight;
    }
    
    
    
}
