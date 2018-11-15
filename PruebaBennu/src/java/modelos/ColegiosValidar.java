
package modelos;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ColegiosValidar implements Validator{

    @Override
    public boolean supports(Class<?> type) 
    {
        return Colegios.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre",
        "required.nombre", "El campo Nombre es Obligatorio.");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "direccion",
        "required.direccion", "El campo direccion es Obligatorio.");
         
    }
}
