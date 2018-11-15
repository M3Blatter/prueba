/*
a.	Consulta que obtenga todos los profesores de un colegio ordenados por nombre.
*/
SELECT  nombre as "Nombre De Profesor"
FROM  profesor
ORDER BY nombre ASC 
/*
b.	Consulta que obtenga todos los alumnos con promedio rojo por asignatura.
*/
SELECT alum.nombre "Alumno", asig.nombre as "Asignatura", AVG(nota) AS "Promedio"
FROM nota, asignatura AS asig, alumno AS alum
WHERE nota.id_alumno = alum.id_alumno
AND nota.id_asignatura = asig.id_asignatura
GROUP BY alum.nombre, asig.nombre
HAVING  AVG(nota) <4
/*
c.	Consulta que contenga el alumno con mejor nota por asignatura.
*/
SELECT a.nombre as "Alumno", asig.nombre as "Asignatura", MAX( n.nota ) AS  "Nota Maxima"
FROM nota AS n, alumno AS a, asignatura AS asig
WHERE a.id_alumno = n.id_alumno
AND asig.id_asignatura = n.id_asignatura
GROUP BY asig.nombre