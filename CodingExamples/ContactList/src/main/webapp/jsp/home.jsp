<%-- 
    Document   : home
    Created on : May 26, 2015, 10:38:48 AM
    Author     : apprentice
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Company Contacts</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img.icon.png">
    </head>
    <body>
        <div class="container"> 
            <h1>Company Contacts</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/home">Home</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/search">Search</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/stats">Stats</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/displayContactListNoAjax">
                            Contact list (No Ajax)</a>
                    </li>
                </ul>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <h2>My contacts</h2>
                    <!--Table to hold Contacts information -->
                    <table id="contactTable" class="table table-hover">
                        <tr>
                            <th width="40%">Contact Name</th>
                            <th width="30%">Company</th>
                            <th width="15%"></th>
                            <th width="15%"></th>
                        </tr>
                        <tbody id="contentRows"></tbody>
                    </table>
                </div>
                <!--form to add new contact -->
                <div class="col-md-6">
                    <h2> Add New Contact Form </h2>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="add-first-name" class="col-md-4 control-label">First Name:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control"
                                       id="add-first-name" placeholder="first name"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-last-name" class="col-md-4 control-label">Last Name:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control"
                                       id="add-last-name"   placeholder="last name"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-company" class="col-md-4 control-label">Company:</label>
                            <div class="col-md-8">
                                <input type="text"  class="form-control"
                                       id="add-company" placeholder="company"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-email"  class="col-md-4 control-label">Email:</label>

                            <div class="col-md-8">
                                <input type="email" class="form-control"
                                       id="add-email"   placeholder="example@email.com" />
                            </div>
                        </div>
                           <div class="form-group">
                            <label for="add-phone"  class="col-md-4 control-label">Phone:</label>

                            <div class="col-md-8">
                                <input type="phone" class="form-control"
                                       id="add-phone"   placeholder="000-000-0000" />
                            </div>
                        </div>
                        <div class="form-group"> 
                            <div class="col-md-offset-4 col-md-8"> 
                                <button type="submit" id="add-button" class="btn btn-default">Create Contact:</button>
                            </div>
                        </div>
                    </form>
                    <div id="validationErrors" style="color:red" />
                </div>
            </div>
        </div>
        <!-- dynamic auto filling of table -->

        <div class="modal fade" id="detailsModal" tabindex="-1" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content" >
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span>&times;</span>
                            <span class="sr-only">Close</span>
                        </button>
                        <h4 class="modal-title" id="detailsModalLabel">Contact Details</h4>

                    </div>
                    <div class="modal-body">
                        <h3 id="contact-id"></h3>
                        <table class="table table-bordered">
                            <tr>
                                <th>First Name</th>
                                <td id="contact-firstName"></td>
                            </tr>
                            <tr>
                                <th>Last Name</th>
                                <td id="contact-lastName"></td>
                            </tr>
                            <tr>
                                <th>Company</th>
                                <td id="contact-company"></td>
                            </tr>
                            <tr>
                                <th>Phone</th>
                                <td id="contact-phone"></td>
                            </tr>
                            <tr>
                                <th>Email</th>
                                <td id="contact-email"></td>
                            </tr>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">
                            Close
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <!-- Edit Modal -->
        <div class="modal fade" id="editModal" tableindex="-1" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span> &times;</span>
                            <span class="sr-only"> Close</span>
                        </button>
                        <h4 class="modal-title" id="editModalLabel">Edit Contact</h4>
                    </div>
                    <div class="modal-body">
                        <h3 id="edit-contact-id"></h3>
                        <form class="form-horizontal" role="form">
                            <div class="form-group" >
                                <label for="edit-first-name" class="col-md-4 control-label">
                                    First Name
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-first-name"
                                           placeholder="first name">
                                </div>
                            </div>
                            <div class="form-group"> 
                                <label for="edit-last-name" class="col-md-4 control-label">
                                    Last Name
                                </label>
                                <div class="col-md-8"> 
                                    <input type="text" class="form-control" id="edit-last-name"
                                           placeholder="last name">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-company" class="col-md-4 control-label">
                                    Company
                                </label>
                                <div class="col-md-8">
                                    <input type="text"  class="form-control" id="edit-company"
                                           placeholder="company">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-phone" class="col-md-4 control-label">
                                    Phone
                                </label>
                                <div class="col-md-8">
                                    <input type="text"  class="form-control" id="edit-phone"
                                           placeholder="phone">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-email" class="col-md-4 control-label">
                                    E-mail
                                </label>
                                <div class="col-md-8">
                                    <input type="text"  class="form-control" id="edit-email"
                                           placeholder="e-mail">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-offset-4 col-md-8">
                                    <button type="submit" id="edit-button" class="btn btn-default"
                                            data-dismiss="modal"> Edit Contact</button>
                                    <button type="button" class="btn btn-default" 
                                            data-dismiss="modal">Cancel</button>
                                    <input type="hidden" id="edit-contact-id">
                                </div>
                            </div>
                            <div class="modal-footer">

                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/contactList.js"></script>
    </body>
</html>
