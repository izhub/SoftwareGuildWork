<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Address Book</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
              rel="stylesheet">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon/png">
    </head>
    <body>
        <div class="container" style="padding: 40px">
            <div class="row">
                <div class="col-md-12" style="text-align: center; font-size: 4em; border: 1px dotted blue; padding: 10px">Address Book <br/>

                </div>
            </div>
        </div>
        <div class="container">
            <hr/>
            <div class="nav navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/search">search</a></li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/stats">Stats</a></li>
                    <Li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/displayAddressBook">Address List</a></li>                   
                </ul>
            </div>
            <div class="container">
                <a class="btn btn-block bg-info btn-lg" role="button" 
                   href="${pageContext.request.contextPath}/addAddressForm">Add Address</a>
                <hr/>

                <c:forEach var="address" items="${aList}">
                    <s:url value="deleteAddress" var="deleteAddress_url">
                        <s:param name="id" value="${address.id}"/>
                    </s:url>
                    <s:url value="editAddress" var="editAddress_url">
                        <s:param name="id" value="${address.id}" />
                    </s:url>
                    <a class="btn btn-danger" role="button" href="${deleteAddress_url}">Delete</a> 
                    <a class="btn btn-warning" role="button" href="${editAddress_url}">Edit</a><br/>
                    ${address.firstName} ${address.lastName}<br/>
                    ${address.street}<br/>
                    ${address.city}, ${address.state}, ${address.zip}
                    <br/>
                    <hr/>

                </c:forEach>
            </div>
        </div>

        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>