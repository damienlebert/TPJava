<%-- 
    Document   : 
    Created on : 5 nov. 2013, 13:08:04
    Author     : dlebert
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="./includes/header.jsp" />

    <body>
    <div class="container"> 
        
        <section>
            <article>
                <h1>Liste des documents contenus dans l'index Solr</h1>
            
                <c:choose>
                    <c:when test="${!empty solrDocuments}">
                        <ul class="list-group">
                            <c:forEach items="${solrDocuments}" var="curDocument">
                                <li>
                                    <c:out value="${curDocument}" />
                                </li>
                            </c:forEach>
                         </ul>    
                    </c:when>
                    <c:otherwise>
                        <p>L'index Solr ne contient aucun document</p>
                    </c:otherwise>
                </c:choose>
           
            </article>
            
            <article>
                <h1>Liste des documents contenus dans le dossier a indexer</h1>

                <c:choose>
                    <c:when test="${!empty toIndexDocuments}">
                        <ul class="list-group">
                            <c:forEach items="${toIndexDocuments}" var="curDocument">
                                <li>
                                    <c:out value="${curDocument}" />
                                </li>
                            </c:forEach>
                         </ul>    
                    </c:when>
                    <c:otherwise>
                        <p>Le dossier ne contient aucun document à indexer</p>
                    </c:otherwise>
                </c:choose>
                        
            </article>
            
    
        </section>
        
        
        <form role="form"  method="post" action="SolrIndex">
                <legend>Indexation d'un document via solr</legend>
                
                <div class="form-group">
                    <label for="fileToExtract">Fichier a extraire</label>
                    <input type="file" id="fileToExtract"name="fileToExtract">
                    
                </div>
                
                <button type="submit" class="btn btn-default"> Envoyer</button>
           
        </form>
    </div>    
    </body>
</html>
