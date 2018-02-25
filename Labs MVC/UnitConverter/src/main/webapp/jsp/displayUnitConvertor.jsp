<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Unit Convertor Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>Unit Convertor Calculator</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" ><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayUnitConvertorController">Unit Convertor</a></li>
                </ul>    
            </div>
            <h2>Unit Conversion</h2>
            <div class="row"> 
                <form class="form-horizontal" role="form" action="submitUnitConvertorController" method="POST">
                    <div class="col-md-12">
                        <div class="form-group">
                        <div class="col-md-7 ">
                            <label for="convert-temp" class="col-sm-2 control-label">Temperature:</label> 
                            <div class="col-sm-4">  <input type="number" class="form-control" name="temp" placeholder="Enter Temperature">  </div>
                        </div>
                       
                        <div class="col-xs-2">
                            <select name="selection" class="form-control">
                                <option>Convert From </option>
                                <option name="temp1" value="1">Celsius</option> 
                                <option name="temp1" value="2">Fahrenheit</option>
                            </select>
                        </div>
                        <div class="col-xs-2">
                            <select name="selection" class="form-control">
                                <option>Convert To </option>
                                <option name="temp2" value="1">Celsius</option> 
                                <option name="temp2" value="2">Fahrenheit</option>
                            </select>
                        </div>
                        <input class="btn btn-primary" type="submit" value="Convert" name="submit" />
                         </div>
                    </div>
                </form>
            </div>
            <p></p>
            <p></p>
            <div class="row"> 
                <form class="form-horizontal" role="form" action="submitUnitConvertorController" method="POST">
                    <div class="col-xs-12">
                        <div class="form-group"> 
                        <div class="col-sm-3 col-offset-9">
                            Length: <input type="number" class="form-control"name="length"> 
                        </div>
                        <div class="col-xs-3">
                            <select name="selection" class="form-control">
                                <option>Convert From </option>
                                <option name="len1" value="1">Inches to Centimeters</option>
                                <option name="len1" value="2">Feet to Centimeters</option>
                                <option name="len1" value="3">Centimeters to Inches</option>
                                <option name="len1" value="3">Centimeters to feet</option>
                            </select>
                        </div>
                        <input class="btn btn-primary" type="submit" value="Convert" name="submit" />
                    </div>
                    </div>
                </form>
            </div>
            <p></p>
            <p></p>
            <div class="row"> 
                <form class="form-horizontal" role="form" action="submitUnitConvertorController" method="POST">
                    <div class="col-md-12"> 
                    <div class="form-group">
                         <label for="convert-weight" class="col-sm-2 control-label"> Weight: </label>
                        <div class="col-xs-3">
                           <input type="number" class="form-control" name="weight" placeholder="Enter value"> 
                        <div class="col-xs-8">
                            <select name="selection" class="form-control">
                                <option>Convert From </option>
                                <option name="we1" value="1">Pounds to Kilograms</option>
                                <option name="we1" value="2">Kilograms to Pounds</option>
                            </select>
                        </div>
                           <div class="col-xs-2">
                        <input class="btn btn-primary" type="submit" value="Convert" name="submit" />
                           </div>
                    </div>
                        </div>
                        </div>
                </form>
            </div>
            <br>

        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

