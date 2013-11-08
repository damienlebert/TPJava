<%-- 
    Document   : rechercheSolr
    Created on : 5 nov. 2013, 13:08:04
    Author     : dlebert
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="./includes/header.jsp" />

    <body>
    <div class="container"> 
            
            <ul class="inline list-unstyled">
                <li>
                    <a class="menu" href="SolrIndex">Indexer un fichier</a>
                </li>      
            </ul>

        <form role="form" class="SearchForm text-center" method="post" action="SolrSearch">


                    
                    <img class="logo " src="./img/solr_logo.png" width="250px" /> 
                    <div class="form-group">    
                        <input  class="form-control" type="text" id="search" name="search" value="<c:out value="${param.search}" />" />
                    </div>          
                    <button class="btn btn-default" type="submit">Rechercher </button>

        </form>
        
        <c:if test="${!empty error}">
            <p class="alert-error"> ${error}</p>
        </c:if>
            <c:if test="${!empty result}">
            <p class="alert-success"> ${result.nbrDocument} document(s) trouvé(s)</p>
        </c:if>
            
        <c:forEach items="${result.matchedDocuments}" var="document">
            <p class="lead"><a>${document.id}</a></p>
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
