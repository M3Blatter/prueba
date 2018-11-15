<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Prueba Bennu</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container">
            <div class="row">
                 <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Colegio</th>
                            <th>Asignatura</th>
                            <th>Opciones</th>
                       </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato">
                            <tr>
                                <td><c:out value="${dato.nombre}" /></td>
                                 <td><c:out value="${dato.colegio}" /></td>
                                  <td><c:out value="${dato.asignatura}" /></td>
                                <td>
                                    <a href="<c:url value="edit2.htm?id_profesor=${dato.id_profesor}" />"><button type="button" class="btn btn-Warning">Editar</button>
                                    <a href="<c:url value="delete2.htm?id_profesor=${dato.id_profesor}" />"><button type="button" class="btn btn-Danger">Eliminar</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <p>
                    <a href="<c:url value="add2.htm" />" class="btn btn-success"><span aria-hidden="true"></span> Volver</a>
                </p>
            </div>
            
        </div>
    </body>
</html>
