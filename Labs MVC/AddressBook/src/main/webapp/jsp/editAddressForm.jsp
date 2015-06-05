<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Address Book</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
              rel="stylesheet">
        <link href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body>        <div class="container" style="padding: 40px">
            <div class="row">
                <div class="col-md-12" style="text-align: center; font-size: 4em; border: 1px dotted blue; padding: 10px">Address Book <br/>

                </div>
            </div>
        </div>
        <div class="container">

            <a class="btn btn-info btn-block btn-lg" role="button" href="displayAddressBook">Address Book List</a>
            <hr/>
            <sf:form class="form-horizontal" role="form" modelAttribute="address"
                     action="editAddressForm" method="POST">

                <div class="form-group">
                    <label for="edit-firstName" class="col-md-4 control-label">First Name</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control"
                                  id="edit-firstName"    path="firstName"
                                  placeholder="first name" />
                        <sf:errors path="firstName" cssClass="errors"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-lastName" class="col-md-4 control-label">Last Name</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control"
                                  id="lastName" path="lastName"
                                  placeholder="last name" />
                        <sf:errors path="lastName" cssClass="errors"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-street" class="col-md-4 control-label">Street</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control"
                                  id="edi-street" path="street"
                                  placeholder="street"/>
                        <sf:errors path="street" cssClass="errors"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-city" class="col-md-4 control-label">City</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control"
                                  id="edit-city" path="city"
                                  placeholder="city" />
                        <sf:errors path="city" cssClass="errors"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-state" class="col-md-4 control-label">State</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control"
                                  id="edit-state" path="state"
                                  placeholder="state" />
                        <sf:errors path="state" cssClass="errors"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-zip" class="col-md-4 control-label">Zip</label>
                        <div class="col-md-8">
                        <sf:input type="text"   class="form-control"
                                  id="add-zip"  path="zip"
                                  placeholder="enter zip" />
                        <sf:errors path="zip" cssClass="errors"></sf:errors>
                        <sf:hidden path="id"></sf:hidden>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit"
                                        id="add-button"
                                        class="btn btn-success">Update</button>
                            </div>
                        </div>
                </sf:form>
            </div>
            <script src="${pageContext.request.contextPath}/js/jjquery-1.11.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>