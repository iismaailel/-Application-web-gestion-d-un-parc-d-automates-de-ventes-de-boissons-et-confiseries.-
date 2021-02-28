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
                <nav class="navbar navbar-expand-md navbar-dark"  style="background-color:  #b7b7b7 ; border-color:#b7b7b7">
                    <div>
                        <a href="https://www.javaguides.net" class="navbar-brand"> Gestion des rapports</a>
                    </div>

                    
                </nav>
            </header>
            <br>

            <div class="row" >
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container" style="background-color:white">
                <br>
                    <h3 class="text-center">Liste des Rapports</h3>
                    <a href="<%=request.getContextPath()%>/listArticle" class="btn btn-success"style="background-color:  #ff000096; border-color: #ff000096">Liste des articles</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/list" class="btn btn-success" style="background-color:  #ff000096; border-color: #ff000096">Liste des automates</a>
                    <br/>
                    <table class="table table-bordered">
                        <br/>
                        <thead>
                            <tr>
                      
                                <th>Numero de serie</th>
                                <th>Date</th>      
                                <th>Statut</th>  
                                <th>Etat</th>
                                <th>Temperature</th>
                                <th>Monaie</th>
                                <th>Carte</th>
                                <th>Contact</th>
                                <th>Erreurs</th>
                                <th>Montant</th>                               
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="rapp" items="${listRapport}">

                                <tr>
                                	<td>
                                        <c:out value="${rapp.numero_serie}" />
                                    </td>
                                    <td>
                                        <c:out value="${rapp.date}" />
                                    </td>
                                    <td>
                                        <c:out value="${rapp.statut}" />
                                    </td>
                           		   <td>
                                        <c:out value="${rapp.etat}" />
                                    </td>
                                    <td>
                                        <c:out value="${rapp.temperature}" />
                                    </td>
                                    <td>
                                        <c:out value="${rapp.monaie}" />
                                    </td>
                                    <td>
                                        <c:out value="${rapp.carte}" />
                                    </td>
                                    <td>
                                        <c:out value="${rapp.sans_contact}" />
                                    </td>
                                    <td>
                                        <c:out value="${rapp.erreurs}" />
                                    </td>
                                    <td>
                                        <c:out value="${rapp.montant}" />
                                    </td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                    <div class="container text-left">
                        <a href="<%=request.getContextPath()%>/service/article/reap" class="btn btn-success"style="background-color:  #ff000096; border-color: #ff000096">Articles à réapprovisionner</a> 
                    </div>
                </div>
            </div>
        </body>
</html>