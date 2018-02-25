<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Flooring Calculator Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>Flooring Calculator</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"> <a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li role="presentation"> <a href="${pageContext.request.contextPath}/Lucky7/displayLucky7">Lucky Sevens</a></li>
                    <li role="presentation"> <a href="${pageContext.request.contextPath}/Factorizor/displayFactorizor">Factorizor</a></li>
                    <li role="presentation"> <a href="${pageContext.request.contextPath}/InterestCalculator/displayInterestCalc">Interest Calculator</a></li>
                    <li role="presentation"class="active"> <a href="${pageContext.request.contextPath}/FlooringCalculator/displayFlooringCalc">Flooring Calculator</a></li>
                    <li role="presentation"> <a href="${pageContext.request.contextPath}/TipCalculator/displayTippingCalc">Tipping Calculator</a></li>
                    <li role="presentation"> <a href="${pageContext.request.contextPath}/UnitConvertorCalculator/unitConvertorCalc">Unit Converter</a></li>
                </ul>     
            </div>
            <h2>Calculate your Flooring project! </h2>
            <form action="submitFlooringCalc" method="POST">
                <div class="Row"> 
                    <div class="col-xs-4"> <b> Enter the Length:</b> </div>  <div class="col-xs-8"> <input type="text" name="length"/><b>${errorMessage}</b></div><br>
                </div><br>
                <div class="Row"> 
                    <div class="col-xs-4"> <b> Enter the Width:</b>  </div>  <div class="col-xs-8"> <input type="text" name="width" /><b>${errorMessage1}</b></div><br>
                </div><br>
                <div class="Row"> 
                        <div class="col-xs-4"> <b> Enter the Cost per Square Foot:</b></div>  <div class="col-xs-8"> <input type="text" name="costPerSqrFoot"/>${errorMessage2}</b></p></div><br>
                    </div><br>
                    <div class="Row"> 
                        <div class="col-xs-8">  <input type="submit" value="Calculate"/> </div>
                    </div>
            </form>

        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

