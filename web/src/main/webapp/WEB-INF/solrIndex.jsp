<%-- 
    Document   : 
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
        <form method="post" action="SolrIndex">
            <fieldset>
                <legend>Solr</legend>
                <p>Indexation d'un document via solr</p>
 
                <label for="solrId">Solr Id <span class="requis">*</span></label>
                <input type="text" id="solrId" name="solrId" value="" size="20" maxlength="60" />
                <br />
 
                <label for="file">Chemin du fichier <span class="requis">*</span></label>
                <input type="text" id="file" name="file" value="" size="100" maxlength="100" />
                <br />
 
                
 
                <input type="submit" value="Envoyer" />
                <br />
            </fieldset>
        </form>
    </div>    
    </body>
</html>
