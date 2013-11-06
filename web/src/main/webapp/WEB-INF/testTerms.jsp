<%-- 
    Document   : testTerms
    Created on : 4 nov. 2013, 16:21:43
    Author     : dlebert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="fr">
    <head>
        <meta charset="utf-8" />
        <title>Get terms solr</title>
    </head>
    <body>
        <form method="post" action="testTerms">
            <fieldset>
                <legend>Solr</legend>
                <p>Récupération des terms comencant par un préfix donné</p>
 
                <label for="prefix">Prefix <span class="requis">*</span></label>
                <input type="text" id="prefix" name="prefix" value="" size="20" maxlength="60" />
                <br />

                ${ result }
                
                <input type="submit" value="Envoyer" />
                <br />
            </fieldset>
        </form>
    </body>
</html>
