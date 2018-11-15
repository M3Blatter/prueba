<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Prueba Bennu</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container">
            <div class="panel panel-primary">
                <div class="panel-heading">Editar Datos Colegios</div>
                <div class="panel-body">
                   
                        <form:form method="post" commandName="colegios">
                            <form:errors path="*" element="div" cssClass="alert alert-danger" />
                            
                            <p>
                                <form:label path="nombre">Nombre:</form:label>
                                <form:input path="nombre" cssClass="form-control" />
                                
                            </p>
                            
                            <p>
                                <form:label path="direccion">Direccion</form:label>
                                <form:input path="direccion" cssClass="form-control" />
                            </p>
                            
                            <hr />
                            <input type="submit" value="Guardar" class="btn btn-danger" />
                            <a href="<c:url value="table.htm" />" class="btn btn-success"><span aria-hidden="true"></span> Volver</a>
                        </form:form>
                </div>
            </div>
        </div>
    </body>
</html>