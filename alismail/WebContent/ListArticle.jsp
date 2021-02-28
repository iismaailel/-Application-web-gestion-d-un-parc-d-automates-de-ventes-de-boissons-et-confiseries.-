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

        <body style="background-color:#000000b3">

            <header>
                <nav  class="navbar navbar-expand-md navbar-dark" style="background-color:  #b7b7b7 ; border-color:#b7b7b7">
                    <div>
                        <a class="navbar-brand"> Gestion des articles</a>
                    </div>

                    
                </nav>
            </header>
            <br>

            <div class="row" >
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container" style="background-color:white">
                <br/>
                    <h3 class="text-center">Liste des Articles</h3>
                    <br>
                    <a href="<%=request.getContextPath()%>/listRapport" class="btn btn-success"style="background-color:  #ff000096; border-color: #ff000096">Liste des rapports</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/list" class="btn btn-success" style="background-color:  #ff000096; border-color: #ff000096">Liste des automates</a>
                    <br>
                    <table class="table table-bordered">
                        <br>
                        <thead>
                            <tr>
                                <th>Numero de serie</th>
                                <th>Nom</th>      
                                <th>Quantite</th>  
                               
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="art" items="${listArt}">

                                <tr>
                                    <td>
                                        <c:out value="${art.num_serie}" />
                                    </td>
                                    <td>
                                        <c:out value="${art.nom}" />
                                    </td>
                           		   <td>
                                        <c:out value="${art.quantite}" />
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