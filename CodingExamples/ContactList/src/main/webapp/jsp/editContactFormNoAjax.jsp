<%-- 
    Document   : newContactFormNoAjax
    Created on : May 27, 2015, 9:14:39 AM
    Author     : apprentice
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Company Contacts Page</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img.icon.png">
    </head>
    <body>
        <div class="container">
            <h1>Company Contact!</h1>
            <hr/>
        </div>
            <div class="container">
                <hr>New Contact Form<hr/>
                <a href="displayContactListNoAjax">Contact list (No Ajax)</a><br/>
                <hr/>
                <sf:form class="form-horizontal" modelAttribute="contact" role="form" 
                         action="editContactNoAjax" method="POST">
                    
                    <div class="form-group">
                        <label for="add-first-name" class="col-md-4 control-label">First Name: </label>
                        <div class="col-md-8">
                            <sf:input type="text" class="form-control" id="add-first-name" 
                                       path="firstName"
                                   placeholder="First Name"/>
                            <sf:errors path="firstName" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-last-name" class="col-md-4 control-label">Last Name: </label>
                        <div class="col-md-8">
                            <sf:input type="text" class="form-control" id="add-last-name" path="lastName"
                                   placeholder="last Name"/>
                            <sf:errors path="lastName" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-company" class="col-md-4 control-label">Company: </label>
                        <div class="col-md-8">
                            <sf:input type="text" class="form-control" id="add-company" path="company"
                                   placeholder="company"/>
                            <sf:errors path="company" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-email" class="col-md-4 control-label">E-mail </label>
                        <div class="col-md-8">
                            <sf:input type="text" class="form-control" id="add-email" path="email"
                                   placeholder="example@email.com"/>
                            <sf:errors path="email" cssclass="error"></sf:errors>
                        </div>
                    </div>
                     <div class="form-group">
                        <label for="add-phone" class="col-md-4 control-label">Phone </label>
                        <div class="col-md-8">
                            <sf:input type="text" class="form-control" id="add-phone" path="phone"
                                   placeholder="phone"/>
                            <sf:errors path="phone" cssclass="error"></sf:errors>
                            <sf:hidden path="contactId"/>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <button type="submit" id="add-button" class="btn btn-default">Add New Contact</button>
                        </div>
                    </div>
                </sf:form>
            </div>
    </body>
</html>
