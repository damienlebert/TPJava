<%-- 
    Document   : rechercheSolr
    Created on : 5 nov. 2013, 13:08:04
    Author     : dlebert
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="fr">
    <head>
        <script type="text/javascript" src="./js/jquery-1.9.1.js"></script>
        <script type="text/javascript" src="./js/jquery-ui-1.10.3.custom.js"></script>
        <script type="text/javascript" src="./js/solr.js"></script>
        
        <link rel="stylesheet" type="text/css" media="screen" href="./css/jquery-ui-1.10.3.custom.css" />
        <meta charset="utf-8" />
        <title>Get terms solr</title>
    </head>
    <body>
        <form method="post" action="SolrSearch">
            <fieldset>
                <legend>Solr</legend>
                <p>Recherche dans l'ensemble des documents</p>
                
                <label for="lalala">Recherche <span class="requis">*</span></label>
                <input type="text" id="search" name="search" value="" size="20" maxlength="60" />
                <br />
                
                <input type="submit" value="Envoyer" />
                <br />
                <br />
            </fieldset>
        </form>
      
        <c:forEach items="${result.matchedDocuments}" var="document">
            <p><a class="resultDocument">${document.id}</a></p>
           
            <p class="highlights">
                <c:forEach items="${document.highlights}" var="highlight">
                    ${highlight} ...
                    <br />
                </c:forEach>
            </p>    
        </c:forEach>
        
        
    </body>
</html>
