<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>DVD Library </title>
        <!--Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" 
              rel="stylesheet">
        <!--WC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body>
        <div class="container"> 
            <h1>DVD Library </h1>


            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" >
                        <a href="${pageContext.request.contextPath}/home">Home</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/search">Search</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/stats">Stats</a>
                    </li>
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/displayDVDDaoNoAjax">
                            DVD List (No Ajax)
                    </li>
                </ul>  
            </div>
        </div>

        <div class="container">
            <!-- #1 link to addDVDForm -->
            <a href="${pageContext.request.contextPath}/displayNewDvdFormNoAjax">Add a DVD </a><br/>
            <hr/>

            <!-- #2 iterate over dvdList forEach dvd in dvdList, so something -->
            <c:forEach var="dvd" items="${dvdList}"> 

                <!--#3 build custom delete url for each dvd. use id for dvd -->
                <!--    to specify the dvd to delete or update -->
                <s:url value="deleteDvdNoAjax"
                       var="deleteDvd_url">
                    <s:param name="dvdId" value="${dvd.dvdId}" />
                </s:url>
                <s:url value="editDvdFormNoAjax"
                       var="editDvd_url">
                    <s:param name="dvdId" value="${dvd.dvdId}" />
                </s:url>
                Title: ${dvd.title} | <a href="${deleteDvd_url}">delete</a> |
                <a href="${editDvd_url}">Edit</a><br/>
                
                MPAA Rating: ${dvd.mpaaRating}<br/>
                Director: ${dvd.director}<br/>
                Release Date: ${dvd.releaseDate}<br/>
                studio: ${dvd.studio}<br/>
                Notes: ${dvd.note}<br/>
                <hr/>
            </c:forEach>

            </div>

            <!-- Placed at the end of the document so the pages load faster -->
            <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

        </body>

    </html>
