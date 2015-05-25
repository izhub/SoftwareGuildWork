<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Interest Calculator Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>Spring MVC Interest Calculator</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayInterestCalc">Interest Calculator</a></li>
                </ul>    
            </div>
            <h2>Interest Calculations</h2>
            <form action="submitInterestCalc" method="POST">
                
                <div class="Row"> 
                    <div class="col-xs-4"> Enter Principal Balance:</div>  <div class="col-xs-8"> <input type="text" name="principal"/>  <b>${errorMessage}</b><br> </div>             
                </div><br>
                <div class="Row"> 
                     <div class="col-xs-4"> Enter interest rate:</div>  <div class="col-xs-8">  <input type="text" name="interest"/><b>${errorMessage1}</b> <br></div>
                </div><br>
                 <div class="Row"> 
                    <div class="col-xs-4">  Enter number of years to invest: </div>  <div class="col-xs-8"> <input type="text" name="period"/> <b>${errorMessage2}</b><br></div>
                 </div>
                 <div class="Row"> 
                    <div class="col-xs-4"> Select time interval of investment: </div><div class="col-xs-8">
                    <label class="radio-inline"><input type="radio" name="int" value="1" checked>Quarterly</label>
                    <label class="radio-inline"><input type="radio" name="int" value="2">Monthly</label>
                    <label class="radio-inline"><input type="radio" name="int" value="3">Daily</label> 
                <div class="co-xs-4"><p><input type="submit" value="Calculate"/></p></div>
                </div> 
                 </div>
                
                </div>
              
                

            </form>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

