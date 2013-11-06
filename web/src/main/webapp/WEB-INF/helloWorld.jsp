<%-- 
    Document   : HelloWorld
    Created on : 30 oct. 2013, 12:54:35
    Author     : dlebert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="fr">
    <head>
        <meta charset="utf-8" />
        <title>Indexation solr</title>
    </head>
    <body>
        <form method="post" action="indexAction">
            <fieldset>
                <legend>Solr</legend>
                <p>Idexation d'un document via solr</p>
 
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
    </body>
</html>
