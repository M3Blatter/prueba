
package controller;

import modelos.Conectar;
import modelos.Profesores;
import modelos.ProfesoresValidar;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("edit2.htm")
public class Edit2Controller {
    ProfesoresValidar profesoresValidar;
    private final JdbcTemplate jdbcTemplate;
     
    
    public Edit2Controller() 
    {
        this.profesoresValidar=new ProfesoresValidar();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar() );
    }
    @RequestMapping(method=RequestMethod.GET) 
    public ModelAndView form(HttpServletRequest request)
    {
        ModelAndView mav=new ModelAndView();
        int id_profesor=Integer.parseInt(request.getParameter("id_profesor"));
        Profesores datos=this.selectProfesor(id_profesor);
        mav.setViewName("edit2");
        mav.addObject("profesores",new Profesores(id_profesor,datos.getNombre(),datos.getId_colegio(),datos.getId_asignatura(),datos.getActivo()));
        return mav;
    }
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
                @ModelAttribute("profesores") Profesores u,
                BindingResult result,
                SessionStatus status,
                HttpServletRequest request
        )
    {
        this.profesoresValidar.validate(u, result);
        if(result.hasErrors())
        {
             ModelAndView mav=new ModelAndView();
            int id_profesor=Integer.parseInt(request.getParameter("id_profesor"));
            Profesores datos=this.selectProfesor(id_profesor);
            mav.setViewName("edit2");
            mav.addObject("profesores",new Profesores(id_profesor,datos.getNombre(),datos.getId_colegio(),datos.getId_asignatura(),datos.getActivo()));
            return mav;
        }else
        {
            int id_profesor=Integer.parseInt(request.getParameter("id_profesor"));
        this.jdbcTemplate.update(
                "UPDATE `profesor` SET `id_colegio`=?,`id_asignatura`=?, `nombre`=?,`activo`=?"
                        + " WHERE `id_profesor`=?",
                 u.getId_colegio(),u.getId_asignatura(),u.getNombre(),u.getActivo(),id_profesor);
        
         return new ModelAndView("redirect:/table2.htm");
        }
       
    }
    public Profesores selectProfesor(int id_profesor) 
    {
        final Profesores pro = new Profesores();
        String quer = "SELECT * FROM profesor WHERE id_profesor='" + id_profesor+"'";
        return (Profesores) jdbcTemplate.query
        (quer, (ResultSet rs) -> {
            if (rs.next()) {
                pro.setNombre(rs.getString("nombre"));
                pro.setId_colegio(rs.getInt("id_colegio"));
                pro.setId_asignatura(rs.getInt("id_asignatura"));
                pro.setActivo(rs.getString("activo"));
            }
            return pro;
        });
      }
    }