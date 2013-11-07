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
        <link rel="stylesheet" type="text/css" media="screen" href="./bootstrap/css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" media="screen" href="./css/mycss.css" />
        <meta charset="utf-8" />
        <title>Recherche</title>
    </head>
    <body>
    <div class="container"> 
        
            
            <ul class="nav nav-pills">
                <li class="">
                    <a href="SolrIndex">Indexer un fichier</a>
                </li>    
                    
            </ul>

        <form method="post" action="SolrSearch">
            <fieldset>
                <div class="text-center">
                    <img class="logo " src="./img/solr_logo.png" width="250px" />   
                    <input  class="input-xxlarge" type="text" id="search" name="search" value="<c:out value="${param.search}" />" />
                    <br />            
                    <input class="btn"type="submit" value="Rechercher" />
                </div>

            </fieldset>
        </form>
        
        <c:if test="${!empty error}">
            <p class="alert-error"> ${error}</p>
        </c:if>
            <c:if test="${!empty result}">
            <p class="alert-success"> ${result.nbrDocument} document(s) trouvé(s)</p>
        </c:if>
            
        <c:forEach items="${result.matchedDocuments}" var="document">
            <p><a class="resultDocument">${document.id}</a></p>
            <p class="highlights">
                <c:forEach items="${document.highlights}" var="highlight">
                    ${highlight} ...
                    <br />
                </c:forEach>
            </p>    
        </c:forEach>
    </div>    
    </body>
</html>
