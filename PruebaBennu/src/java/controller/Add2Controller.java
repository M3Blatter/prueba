
package controller;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import java.sql.ResultSet;
import modelos.Asignaturas;
import modelos.AsignaturasValidar;
import modelos.Colegios;
import modelos.ColegiosValidar;
import modelos.Conectar;
import modelos.Profesores;
import modelos.ProfesoresValidar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("add2.htm")
public class Add2Controller {
    ProfesoresValidar profesoresValidar;
    ColegiosValidar colegioValidar;
    AsignaturasValidar asignaturaValidar;
    private final JdbcTemplate jdbcTemplate;

    public Add2Controller() 
    {
        this.profesoresValidar=new ProfesoresValidar();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar() );
    }
    @RequestMapping(method=RequestMethod.GET) 
    public ModelAndView form()
    {
        ModelAndView mav=new ModelAndView();
        mav.setViewName("add2");
        mav.addObject("profesores",new Profesores());
        return mav;
    }
        public Colegios selectColegio(string nombre) 
    {
        final Colegios cole = new Colegios();
        String quer = "SELECT * FROM colegio WHERE nombre='" + nombre+"'";
        return (Colegios) jdbcTemplate.query
        (quer, (ResultSet rs) -> {
            if (rs.next()) {
                cole.setId_colegio(rs.getInt("id_colegio"));
            }
            return cole;
        });
    }
        public Asignaturas selectAsignatura(string nombre) 
    {
        final Asignaturas asig = new Asignaturas();
        String quer = "SELECT * FROM `asignatura` WHERE `nombre`='" + nombre+"'";
        return (Asignaturas) jdbcTemplate.query
        (quer, (ResultSet rs) -> {
            if (rs.next()) {
                asig.setId_asignatura(rs.getInt("id_asignatura"));
            }
            return asig;
        });
    } 
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
                @ModelAttribute("Profesores") Profesores u,
                BindingResult result,
                SessionStatus status
        )
    {
        this.profesoresValidar.validate(u, result);
        if(result.hasErrors())
        {
            ModelAndView mav=new ModelAndView();
            mav.setViewName("add2");
            mav.addObject("profesores",new Profesores());
            return mav;
        }else
        {
            
        this.jdbcTemplate.update
        ( 
        "insert into profesor (id_colegio,id_asignatura,nombre,activo) values (?,?,?,?)",
         u.getId_colegio(),u.getId_asignatura(),u.getNombre(),u.getActivo()
        );
         return new ModelAndView("redirect:/table2.htm");
        }
    }

}
