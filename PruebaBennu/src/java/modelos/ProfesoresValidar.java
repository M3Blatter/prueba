
package modelos;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ProfesoresValidar implements Validator{

    @Override
    public boolean supports(Class<?> type) 
    {
        return Profesores.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Profesores profesores=(Profesores)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre",
        "required.nombre", "El campo Nombre es Obligatorio.");
        if(profesores.getId_colegio()==0)
        {
	    errors.rejectValue("id_colegio", "required.id_colegio","Seleccione un id_colegio");
	}
        if(profesores.getId_asignatura()==0)
        {
	    errors.rejectValue("id_asignatura", "required.id_asignatura","Seleccione una id_asignatura");
	}

        
}
}
