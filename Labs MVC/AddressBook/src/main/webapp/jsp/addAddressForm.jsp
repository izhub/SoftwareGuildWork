<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Address Book</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
              rel="stylesheet">
        <link rel="shortcut cion" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body>

        <div class="container" style="padding: 40px">
            <div class="row">
                <div class="col-md-12" style="text-align: center; font-size: 4em; border: 1px dotted blue; padding: 10px">Address Book <br/>
            
                </div>
            </div>
        </div>
        <div class="container">
            <a class="btn btn-info btn-block btn-lg"  href="displayAddressBook" role="button">Address List </a><br/>
            <hr/>
            
            <sf:form class="form-horizontal" role="form" action="addnew" 
                     modelAttribute="address" method="POST">
                <div class="form-group">
                    <label for="add-firstName" class="col-md-4 control-label">
                        First Name:
                    </label>
                    <div class="col-md-8">
                        <sf:input type="text"
                                  class="form-control"
                                  id="add-firstName"
                                  path="firstName"
                                  placeholder="First Name" />
                        <sf:errors path="firstName" cssclass="errors"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-lastName" class="col-md-4 control-label">
                            Last Name:
                        </label>
                        <div class="col-md-8">
                        <sf:input type="text"
                                  class="form-control"
                                  id="add-lastName"
                                  path="lastName"
                                  placeholder="Last Name" />
                        <sf:errors path="lastName" cssClass="errors"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-street" class="col-md-4 control-label">Street Address</label>
                        <div class="col-md-8">
                        <sf:input type="text"
                                  class="form-control"
                                  id="add-street"
                                  path="street"
                                  placeholder="street address" />
                        <sf:errors path="street" cssClass="errors"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-city" class="col-md-4 control-label">City</label>
                        <div class="col-md-8">
                        <sf:input type="text"
                                  class="form-control"
                                  id="add-city"
                                  path="city"
                                  placeholder="enter city" />
                        <sf:errors path="city" cssClass="errors"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-state" class="col-md-4 control-label">State</label>
                        <div class="col-md-8">
                        <sf:input type="text"   class="form-control"
                                  id="add-state"
                                  path="state"
                                  placeholder="enter state" />
                        <sf:errors path="state" cssClass="errors"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-zip" class="col-md-4 control-label">Zip</label>
                        <div class="col-md-8">
                        <sf:input type="text"   class="form-control"
                                  id="add-zip"
                                  path="zip"
                                  placeholder="enter zip" />
                        <sf:errors path="zip" cssClass="errors"></sf:errors>
                        </div>
                    </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit"
                                        id="add-button"
                                        class="btn btn-success">
                                            Add Address
                                </button>
                            </div>
                        </div>
            </sf:form>
        </div>
        
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/jsj/bootstrap.min.js"></script>
    </body>
</html>
