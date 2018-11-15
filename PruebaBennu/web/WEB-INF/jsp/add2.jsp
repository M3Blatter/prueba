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
                <div class="panel-heading">Ingreso de Profesores</div>
                <div class="panel-body">
                   
                            <form:form method="post" commandName="profesores">
                                              
                            <form:errors path="*" element="div" cssClass="alert alert-danger" />
                            
                            <p>
                                <form:label path="nombre">Nombre:</form:label>
                                <form:input path="nombre" cssClass="form-control" />
                                
                            </p>
                         
                            <form:errors path="*" element="div" cssClass="alert alert-danger" />
                            <p>
                                <form:label path="id_colegio">Id_Colegio:</form:label>
                                <form:input path="id_colegio" cssClass="form-control" />
                                
                            </p>

                            <p>
                                <form:label path="id_asignatura">Id_Asignatura:</form:label>
                                <form:input path="id_asignatura" cssClass="form-control" />
                                
                            </p>
                         
                            <p> Activo </p>
                             <input type="radio" name="Activo" value="si"> SI
                             <input type="radio" name="Activo" value="no"> No

                            <hr />
                            <input type="submit" value="Guardar" class="btn btn-danger" />
                            <a href="<c:url value="index.htm" />" class="btn btn-success"><span aria-hidden="true"></span> Inicio</a>
                            <a href="<c:url value="table2.htm" />" class="btn btn-info"><span aria-hidden="true"></span> Table de Registro</a>
                        </form:form>
                 </div>
            </div>
        </div>
    </body>
</html>
