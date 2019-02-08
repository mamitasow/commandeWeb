<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EDIT</title>
</head>
<link  rel="stylesheet" type="text/css" href="./css/bootstrap.min.css"/>
</head>
<body>
<div class="container">
<div class="panel panel-primary">
	<div class="panel-heading"><h1>Modification Commande</h1></div>
	<div class="panel-body">
		<form method="POST" action="Commande">
		<div class="form-goup">
		<input class="form-control" value="${GetCommandeById.id}" type="hidden" name="idcmd"/>
		</div>
	 	<input  type="hidden" name="action" value="edit" />	 	
	 	
	 	<div class="form-goup">
			<label class="control-label">Libelle</label>
			<input class="form-control" value="${GetCommandeById.libelle}" type="text" name="libelle"/>	 	
	 	</div>
	   <div class="form-goup">
			<label class="control-label">Montant</label>
			<input class="form-control" value="${GetCommandeById.montant}" type="text" name="montant"/>	 	
	 	</div>
	 	<div class="form-goup">
			<label class="control-label">Status</label>
			<input class="form-control" value="${GetCommandeById.etat}" type="text" name="etat"/>	 	
	 	</div>
	 	<div class="form-goup">
			<label class="control-label">Livraison</label>
			<input class="form-control" value="${GetCommandeById.livraison}" type="date" name="livraison"/>	
			<input class="form-control" value="${GetCommandeById.livraison.id}" type="hidden" name="idl"/>		 	
	 	</div>
	 	
	 	<div class="form-goup">
			<input  type="submit" name="valider" class="btn btn-success" value="valider"/>	
			<input  type="reset" name="annuler" class="btn btn-danger" value="annuler"/>	 	
	 	</div>
	</form>		
	 	
	</div>
</div>
</div>
</body>
</html>