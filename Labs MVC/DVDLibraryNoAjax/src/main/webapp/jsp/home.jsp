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
        <div class="container"> 
            <h1>DVD Library</h1>
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
                            DVD List (No Ajax)
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
<!--- 
                <!-- add col to hold new dvd form & take up other half of row 
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
                                Title:
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
                                Title:
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
                                Title:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id="add-studio"
                                       placeholder="Studio"/>
                            </div>
                        </div>
                         <div class="form-group">
                             <div class="col-md-offset-4 col-md-8">
                                 <button type="submit"
                                         id="add-button"
                                         class="btn btn-default">
                                     Add DVD
                                 </button>
                             </div>
                    </form>

                </div> <!-- End col div -->

            </div> <!-- End row div -->


        </div>

        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>

</html>
