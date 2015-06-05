<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset-UTF-8">
        <title>Address Book</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link ref="shortcut icon" href="${pageContext.request.contextPath}/img.icon.png">
    </head>
    <body>
        <div class="container" style="padding: 40px">
            <div class="row">
                <div class="col-md-12" style="text-align: center; font-size: 4em; border: 1px dotted blue; padding: 10px">Address Book <br/>

                </div>
            </div>
        </div>
        <div class="container">
            <div class="nav navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/search">search</a></li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/stats">Stats</a></li>
                    <Li role="presentation" >
                        <a href="${pageContext.request.contextPath}/displayAddressBook">Address List</a></li>                   
                </ul>
            </div>
            <div class="row">
                <!--dynamic table layout-->

                <div class="col-md-6">
                    <h2>My Address Contacts</h2>
                    <table id="addressTable" class="table table-responsive">
                        <tr>
                            <th width="40%"> Entry Name</th>
                            <th width="30%"> State</th>
                            <th width="15%"></th>
                            <th width="15%"></th>
                        </tr>
                        <tbody id="contentRows"></tbody>
                    </table>
                </div> 

                <!--add newAddress form--> 
                <div class="col-md-6">
                    <h2> Add new Address </h2>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="add-first-name" class="col-md-4 control-label">
                                First Name </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control"
                                       id="add-first-name" placeholder="first name"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-last-name" class="col-md-4 control-label">
                                Last Name
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control"
                                       id="add-last-name" placeholder="last name"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-street" class="col-md-4 control-label">
                                Street
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control"
                                       id="add-street" placeholder="street address"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-city" class="col-md-4 control-label">
                                City
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control"
                                       id="add-city" placeholder="city"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-state" class="col-md-4 control-label">
                                State
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control"
                                       id="add-state" placeholder="state"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-zip" class="col-md-4 control-label">
                                Zip
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control"
                                       id="add-zip" placeholder="zip code">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit" id="add-button" 
                                        class="btn btn-success">
                                    Add Entry
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <!--Dynamic auto filling of table-->
            <div class="modal fade" id="detailsModal" tabindex="-1" role="dialog">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">
                                <span> &times;</span>
                                <span class="sr-only"> Close </span>
                            </button>
                            <h4 class="modal-title" id="detailsModalLabel">
                                Address Details
                            </h4>
                        </div>
                        <div class="modal-body">
                            <h3 id="address-id"></h3>
                            <table class="table table-responsive">
                                <tr>
                                    <th>First Name </th>
                                    <td id="address-firstName"></td>
                                </tr>
                                <tr>
                                    <th>Last Name </th>
                                    <td id="address-lastName"></td>
                                </tr>
                                <tr>
                                    <th>Street</th>
                                    <td id="address-street"></td>
                                </tr>
                                <tr>
                                    <th>City</th>
                                    <td id="address-city"></td>
                                </tr>
                                <tr>
                                    <th>State</th>
                                    <td id="address-state"></td>
                                </tr>
                                <tr>
                                    <th>Zip</th>
                                    <td id="address-zip"></td>
                                </tr>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-success"
                                    data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
            
            <!--Edit Modal--> 
            <div class="modal fade" id="editModal" tableindex="-1" role="dialog">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">
                                <span> &times;</span>
                                <span class="sr-only">Close</span>
                            </button>
                            <h4 class="modal-title" id="editModalLabel">Edit Address</h4>
                        </div>
                        <div class="modal-body">
                            <h3 id="edit-address-id"></h3>
                            <form class="form-horizontal" role="form">
                                <div class="form-group">
                                    <label for="edit-first-name" class="col-md-4 control-label">
                                        First Name
                                    </label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control"
                                               id="edit-first-name" placeholder="first name">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit-last-name" class="col-md-4 control-label">
                                        Last name
                                    </label>
                                    <div class="col-md-8">
                                        <input typ="text" class="form-control"
                                               id="edit-last-name" placeholder="last name">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit-street" class="col-md-4 control-label">
                                        Street
                                    </label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control"
                                               id="edit-street" placeholder="street">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit-city" class="col-md-4 control-label">
                                        City
                                    </label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control"
                                               id="edit-city" placeholder="city">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit-state" class="col-md-4 control-label">
                                        State
                                    </label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control"
                                               id="edit-state" placeholder="state">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit-zip" class="col-md-4 control-label">
                                        Zip
                                    </label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control"
                                               id="edit-zip" placeholder="zip">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-offset-4 col-md-8">
                                        <button type="submit" id="edit-button"
                                            class="btn btn-warning" data-dismiss="modal">
                                                    Edit Address
                                        </button>
                                        <button type="button" class="btn btn-default"
                                                data-dismiss="modal">Cancel</button>
                                        <input type="hidden" id="edit-address-id">
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
      <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
      <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/addressBook.js"></script>
              
    </body>
</html>