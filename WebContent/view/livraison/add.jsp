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
	<div class="panel-heading"><h1>LIVRAISON</h1></div>
	<div class="panel-body">
  <form method="POST" action="Livraison">
	 	
	 	 <div class="form-group">
                     <label> date livraison</label>
                     <input class="form-control" type ="date" name="date"  required="true">                       
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
                                       
                                       
                                        <th>Date Livraison</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${ListeLivraison}" var="comp">
                                    <tr class="odd gradeX">
                                        <td>${comp.date}</td>
   <td> <a href="Commande?page=edit?id=${comp.id}">edit</a>  |  <a href="Commande?page=delete?id=${comp.id}">delete</a></td>
                                           
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