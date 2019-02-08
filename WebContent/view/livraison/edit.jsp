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
	<c:forEach items="${GetLivraisonById}" var="e">
		<form method="POST" action="Livraison">
		
	   
	 	<div class="form-goup">
			<label class="control-label">Date</label>
			<input class="form-control" value="${e.date}" type="date" name="date"/>	 	
	 	</div>
	 	
	 	
	 	<div class="form-goup">
			<input  type="submit" name="valider" class="btn btn-success" value="valider"/>	
			<input  type="reset" name="annuler" class="btn btn-danger" value="annuler"/>	 	
	 	</div>
	</form>		
		</c:forEach>
	 	
	</div>
</div>
</div>
</body>
</html>