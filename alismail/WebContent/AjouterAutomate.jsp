<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Management des automates</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style>
        	element.style {
    		background-color: #fff !important;
			}
        </style>
        </head>

        <body style="background-color: #000000b3">
            <header>
                <nav class="navbar navbar-expand-md" style="background-color:  #b7b7b7 ; border-color:#b7b7b7">
                    <div>
                        <a  class="navbar-brand">Ajout des automates  </a>
                    </div>
                </nav>
            </header>
            <br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            
            <a href="<%=request.getContextPath()%>/listArticle" class="btn btn-success" style="background-color:  #ff000096; border-color: #ff000096">Liste des articles</a>
            <a href="<%=request.getContextPath()%>/listRapport" class="btn btn-success" style="background-color:  #ff000096; border-color: #ff000096">liste des rapports</a>
            <a href="<%=request.getContextPath()%>/list" class="btn btn-success" style="background-color:  #ff000096; border-color: #ff000096">Liste des automates</a>
            <br/>
            <div class="container col-md-5" style="color-background: white ; border-color: white ">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${param.numSerie !=null}">
                            <form action="modifierautomate" method="post">
                        </c:if>
                        <c:if test="${param.numSerie == null}">
                            <form action="insertautomate" method="post">
                        </c:if>

                        
                            <h2>
                                <c:if test="${param.numSerie !=null}">
                                    Modifier l'automate "${param.numSerie}"
                                </c:if>
                                <c:if test="${param.numSerie == null}">
                                   Ajouter un nouveau automate
                                </c:if>
                            </h2>
                            
                        
						<fieldset class="form-group">
                            <label>  Numero Serie </label> <input type="text" value='${param.numSerie}' class="form-control" name="numSerie" required="required">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>  Type T </label> <input type="text" value='${param.typeT}' class="form-control" name="typeT" required="required">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Type</label> <input type="text" value="<c:out value='${auto.type}' />" class="form-control" name="type" required="required">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Adresse d'installation</label> <input type="text" value="<c:out value='${auto.adresse_insta}' />" class="form-control" name="adresse_insta">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Emplacement</label> <input type="text" value="<c:out value='${auto.emplacement}' />" class="form-control" name="emplacement">
                        </fieldset>
                        
                         <fieldset class="form-group">
                            <label>GPS Latitude</label> <input type="text" value="<c:out value='${auto.gpsLatitude}' />" class="form-control" name="gpsLatitude">
                        </fieldset>
                        
                         <fieldset class="form-group">
                            <label>GPS Longitude</label> <input type="text" value="<c:out value='${auto.gpsLongitude}' />" class="form-control" name="gpsLongitude">
                        </fieldset>
                        
                         <fieldset class="form-group">
                            <label>Date derniere intervention</label> <input type="text" value="<c:out value='${auto.date_dern_intervention}' />" class="form-control" name="date_dern_intervention">
                        </fieldset>
                        
                         <fieldset class="form-group">
                            <label>Commentaires/Notes</label> <input type="text" value="<c:out value='${auto.notes}' />" class="form-control" name="notes">
                        </fieldset>
                        
                        

                        <button type="submit" class="btn btn-success" >Enregistrer l'ajout </button>
                        </form>
                    </div>
                </div>
            </div>
        </body>


 

        </html>