<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADD</title>
<link  rel="stylesheet" type="text/css" href="./css/bootstrap.min.css"/>
</head>
<body>
<div class="container">
<div class="row">
        <div class="col-lg-12">
<div class="panel panel-primary">
	<div class="panel-heading"><h1>Gestion de Commande</h1></div>
	<div class="panel-body">
  <form method="POST" action="Commande">
	 	<c:if test ="${action !=null}">
			<input  type="hidden" name="idcmd" value="${GetCommandeById.id}" />	 	
	 	 </c:if>
	 	 <c:if test ="${action ==null}">
			<input  type="hidden" name="action" value="add" />	 	
	 	 </c:if>
	 	  <c:if test ="${action !=null}">
			<input  type="hidden" name="action" value="livrer" />	 	
	 	 </c:if>
	 	<div class="form-goup">
			<label class="control-label">Libelle Commande</label>
			 <c:if test ="${action !=null}">
			<input class="form-control" type="text" name="libelle" value="${GetCommandeById.libelle}"/>	 	
	 	 </c:if>
	 	  <c:if test ="${action==null}">
			<input class="form-control" type="text" name="libelle" />	 	
	 	 </c:if>
	 	 </div>
	<div class="form-goup">
			<label class="control-label">Montant</label>
			 <c:if test ="${action !=null}">
			<input class="form-control" type="text" name="montant" value="${GetCommandeById.montant}"/>	
	 	 </c:if>
	 	  <c:if test ="${action ==null}">
			<input class="form-control" type="text" name="montant" />	
	 	 </c:if> 	
	 	</div>
	 	<div class="form-goup">
			<label class="control-label">Date Livraison</label>
			<input class="form-control" type="date" name="date"/>	 	
	 	</div>

	 	<div class="form-goup">
			<label class="control-label">Status</label>
			<input class="form-control" value="non_livrer" type="text" name="etat"/>	 	
	 	</div>
	 	
	 	
			<input  type="submit" name="save" class="btn btn-success" value="valider"/>	
			
				 	
	 	
	</form>
	</div>
	</div>
	</div>
	</div>
	<div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Liste des Commandes
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                       
                                        <th>Libelle</th>
                                        <th>Montant</th>
                                       <th>Date Commande</th>
                                        <th>Etat</th>
                                        <th>Livraison</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${ListeCommande}" var="comp">
                                    <tr class="odd gradeX">
                                        <td>${comp.libelle}</td>
                                        <td>${comp.montant}</td>
                                         <td>${comp.datecommande}</td>
                                          <td>${comp.etat}</td>
                                           <td>${comp.livraison}</td>
   <td><a href="Commande?page=livrer&id=${comp.id}">livrer</a>	|  <a href="Commande?page=edit&id=${comp.id}">edit</a>  |  <a href="Commande?page=delete&id=${comp.id}">delete</a>| <a href="Commande?page=cancel&id=${comp.id}">cancel</a></td>
                                           
                                    </tr>                                   
                                     </c:forEach>
                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
                            
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
</div>

</body>
</html>