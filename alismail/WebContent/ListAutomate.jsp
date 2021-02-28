<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Management des automates</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
			crossorigin="anonymous" >
        </head>

        <body style="background-color: #000000b3">

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color:  #b7b7b7 ; border-color:#b7b7b7">
                    <div>
                        <a class="navbar-brand"> &nbsp;&nbsp;&nbsp;Gestion d'automates </a>
                    </div>

                    <ul class="navbar-nav">
                       <!--   <li><a href="<%=request.getContextPath()%>/list" class="nav-link"> Liste des automates</a></li>-->
                    </ul>
                </nav>
            </header>
            <br>

            <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container" style="background-color: white">
                <br/>
                    <h3 class="text-center">Liste des Automates</h3>
                    <br/><br/>
                    <hr>
                    <div class="container text-left" >
                        <a href="<%=request.getContextPath()%>/newautomate" class="btn btn-success" style="background-color:  #ff000096; border-color: #ff000096">Ajouter automate</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/listRapport" class="btn btn-success"style="background-color:  #ff000096; border-color: #ff000096">Liste des rapports</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/listArticle" class="btn btn-success"style="background-color:  #ff000096; border-color: #ff000096">Liste des articles</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Numero de serie</th>
                                <th>Type T</th>                             
                                <th>Type</th>      
                                <th>Adresse d'installation</th>  
                                <th>Emplacement</th>
                                <th>Gps latitude</th>
                                <th>Gps longitude</th>
                                 <th>Date derniere intervention</th>
                                 <th>Commentaires/Notes</th>
                                <th> </th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="auto" items="${listAuto}">

                                <tr>
                                    <td>
                                        <c:out value="${auto.numSerie}" />
                                    </td>
                                    <td>
                                        <c:out value="${auto.typeT}" />
                                    </td>                                 
                                    <td>
                                        <c:out value="${auto.type}" />
                                    </td>
                           		   <td>
                                        <c:out value="${auto.adresse_insta}" />
                                    </td>
                                    <td>
                                        <c:out value="${auto.emplacement}" />
                                    </td>
                                    <td>
                                        <c:out value="${auto.gpsLatitude}" />
                                    </td>
                                    <td>
                                        <c:out value="${auto.gpsLongitude}" />
                                    </td>
                                    <td>
                                        <c:out value="${auto.date_dern_intervention}" />
                                    </td>
                                    <td>
                                        <c:out value="${auto.notes}" />
                                    </td>
                                    <td>
                                    <a href="service/rapport/get/<c:out value='${auto.typeT}' />/<c:out value='${auto.numSerie}' />">Rapport</a>
                                    <a href="modifautomate?numSerie=<c:out value='${auto.numSerie}' />">Edit</a>
                                    <a href="deleteautomate?numSerie=<c:out value='${auto.numSerie}' />">Delete</a>                 
                                     </td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                    
                </div>
            </div>
        </body>

        </html>