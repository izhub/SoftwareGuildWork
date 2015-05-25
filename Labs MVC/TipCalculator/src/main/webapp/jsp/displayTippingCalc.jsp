<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Tipping Calculator Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>Tipping Calculator</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayTippingCalc">Tipping Calculator</a></li>
                </ul>    
            </div>
            <h2>Find the Total Amount with Tips</h2>

            <form action="submitTippingCalc" method="POST">
                <div class="form-group"> 
                    <div class="form-group">
                        <div class="col-xs-4"> <p> Enter dollar value:</p> </div>  <div class="col-xs-8"> <input type="text" name="value"> <b>${errorMessage}</b><br> </div><br>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-4"> <p>Enter Tip Percentage:</p> </div> <div class="col-xs-8"> <input type="text" name="tip" <b>${errorMessage1}</b> <br> </div>
                    </div>    
                    
                </div>
                    <input type="submit" value="Calculate"/>
            </form>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

