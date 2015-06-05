<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>DVD Library </title>
        <!--Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" 
              rel="stylesheet">
        <!--WC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body>
        <div class="container" style="padding: 40px">
            <div class="row">
                <div class="col-md-12" style="text-align: center; font-size: 4em; border: 1px dotted darkmagenta; padding: 15px">DVD Library </br/>
                </div> 
            </div>
        </div>
        <div class="container"> 
     
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
                        <a href="${pageContext.request.contextPath}/displayDVDDaoNoAjax">
                            DVD List (No Ajax) </a>
                    </li>
                </ul>  
            </div>

            <!-- add row to container to hold summary table & form -->
            <div class="row">

                <!-- add col to hold summary table, take up half the row -->
                <div class="col-md-6">

                    <h2> My DVDs </h2>
                    <table id="dvdTable" class="table table-hover">
                        <tr>
                            <th widht="40%">Title</th>
                            <th width="30%">MPAA Rating</th>
                            <th width="15%"></th>
                            <th width="15%"></th>

                        </tr>
                        <!-- holds list of dvds, will fill dynamically using jQuery -->
                        <tbody id="contentRows"></tbody>
                    </table>
                </div> <!-- End col div  -->

                <!-- add col to hold new dvd form & take up other half of row -->
                <div class="col-md-6">
                    <h2>Add new DVD </h2>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="add-title" class="col-md-4 control-label">
                                Title:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id="add-title"
                                       placeholder="DVD Title"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-rating" class="col-md-4 control-label">
                                Rating:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id="add-rating"
                                       placeholder="MPAA Rating"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-director" class="col-md-4 control-label">
                                Director
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id="add-director"
                                       placeholder="Director"/>
                            </div>
                        </div>
                        <div class="form-group">

                            <label for="add-release-date" class="col-md-4 control-label">
                                Release Date:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id="add-release-date"
                                       placeholder="Release Date"/>
                            </div>
                        </div>
                        <div class="form-group">

                            <label for="add-studio" class="col-md-4 control-label">
                                Studio:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id="add-studio"
                                       placeholder="Studio"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-note" class="col-md-4 control-label">
                                Note
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control"
                                       id="add-note" placeholder="Notes"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit" id="add-button"
                                        class="btn btn-default">
                                    Add DVD
                                </button>
                            </div>
                        </div> <!-- End col div -->
                    </form>
                </div> <!-- End row div -->
            </div>
        </div>
                 <!-- dynamic auto filling of table -->
                 
                 <div class="modal fade" id="detailsModal" tablindex="-1" role="dialog">
                     <div class="modal-dialog"> 
                         <div class="modal-content"> 
                             <div class="modal-header"> 
                                 <button type="button" class="close" data-dismiss="modal">
                                     <span>&times;</span>
                                     <span class="sr-only">Close</span>
                                 </button>
                                 <h4 class="modal-title" id="detailsModalLabel">Address Details</h4>
                             </div>
                             <div class="modal-body">
                                 <h3 id="dvd-id"></h3>
                                 <table class="table table-striped"> 
                                     <tr>
                                         <th>Title</th>
                                         <td id="dvd-title"></td>
                                     </tr>
                                     <tr>
                                         <th>Rating </th>
                                         <td id="dvd-rating"></td>
                                     </tr>
                                     <tr>
                                         <th>Release Date </th>
                                         <td id="dvd-release-date"></td>
                                     </tr>
                                     <tr>
                                         <th>Director</th>
                                         <td id="dvd-director"></td>
                                     </tr>
                                     <tr>
                                         <th>Studio</th>
                                         <td id="dvd-studio"></td>
                                     </tr>
                                     <tr>
                                         <th>Notes</th>
                                         <td id="dvd-note"></td>
                                     </tr>
                                 </table>
                             </div>
                             <div class="modal-footer">
                                 <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                             </div>
                         </div>
                     </div>
                 </div>
                 
                 <!-- Edit Modal  -->
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
                                 <h3 id="edit-dvd-id"></h3>
                                 <form class="form-horizontal" role="form">
                                     <div class="form-group">
                                         <label for="edit-title" class="col-md-4 control-label">
                                             Title
                                         </label>
                                         <div class="col-md-8">
                                         <input type="text" class="form-control" id="edit-title"
                                                placeholdler="title">
                                         </div>
                                     </div>
                                     <div class="form-group">
                                         <label for="edit=rating" class="col-md-4 control-label">Rating</label>
                                         <div class="col-md-8">
                                             <input type="text" class="form-control" id="edit-rating" placeholder="mpaa rating">
                                         </div>
                                     </div>
                                     <div class="form-group">
                                         <label for="edit-release-date" class="col-md-4 control-label">Release Date</label>
                                         <div class="col-md-8"> 
                                             <input type="text" class="form-control" id="edit-release-date" placeholder="release date">
                                         </div>
                                     </div>
                                     <div class="form-group">
                                         <label for="edit-director" class="col-md-4 control-label">Director</label>
                                         <div class="col-md-8">
                                             <input type="text" class="form-control" id="edit-director" placeholder="director">
                                         </div>
                                     </div>
                                     <div class="form-group">
                                         <label for="edit-studio" class="col-md-4 control-label">Studio</label>
                                         <div class="col-md-8">
                                             <input type="text" class="form-control" id="edit-studio" placeholder="studio">
                                         </div>
                                     </div>
                                     <div class="form-group"> 
                                         <label for="edit-note" class="col-md-4 control-label">Notes</label>
                                         <div class="col-md-8">
                                             <input type="text" class="form-control" id="edit-note" placeholder="notes">
                                         </div>
                                     </div>
                                     <div class="form-group">
                                         <div class="col-md-offset-4 col-md-8">
                                             <button type="submit" id="edit-button" class="btn btn-default"
                                                     data-dismiss="modal">Edit Contact</button>
                                             <button type="button" class="btn btn-default"
                                                     data-dismiss="modal">Cancel</button>
                                             <input type="hidden" id="edit-dvd-id">
                                         </div>
                                     </div>
                                 </form>
                             </div>
                             <div class="modal-footer">
                                 
                             </div>
                         </div>
                     </div>
                 </div>
                 
            <!-- Placed at the end of the document so the pages load faster -->
            <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/dvdLibrary.js"></script>


    </body>

</html>
