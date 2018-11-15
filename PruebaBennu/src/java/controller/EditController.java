
package controller;

import modelos.Conectar;
import modelos.Colegios;
import modelos.ColegiosValidar;
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
@RequestMapping("edit.htm")
public class EditController {
    ColegiosValidar colegiosValidar;
    private final JdbcTemplate jdbcTemplate;
     
    
    public EditController() 
    {
        this.colegiosValidar=new ColegiosValidar();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar() );
    }
    @RequestMapping(method=RequestMethod.GET) 
    public ModelAndView form(HttpServletRequest request)
    {
        ModelAndView mav=new ModelAndView();
        int id_colegio=Integer.parseInt(request.getParameter("id_colegio"));
        Colegios datos=this.selectColegio(id_colegio);
        mav.setViewName("edit");
        mav.addObject("colegios",new Colegios(id_colegio,datos.getNombre(),datos.getDireccion()));
        return mav;
    }
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
                @ModelAttribute("colegios") Colegios u,
                BindingResult result,
                SessionStatus status,
                HttpServletRequest request
        )
    {
        this.colegiosValidar.validate(u, result);
        if(result.hasErrors())
        {
             ModelAndView mav=new ModelAndView();
            int id_colegio=Integer.parseInt(request.getParameter("id_colegio"));
            Colegios datos=this.selectColegio(id_colegio);
            mav.setViewName("edit");
            mav.addObject("colegios",new Colegios(id_colegio,datos.getNombre(),datos.getDireccion()));
            return mav;
        }else
        {
            int id_colegio=Integer.parseInt(request.getParameter("id_colegio"));
        this.jdbcTemplate.update(
                "UPDATE `colegio` SET `nombre`=?,`direccion`=? WHERE `id_colegio`=?",
                 u.getNombre(),u.getDireccion(),id_colegio);
        
         return new ModelAndView("redirect:/table.htm");
        }
       
    }
    public Colegios selectColegio(int id_colegio) 
    {
        final Colegios user = new Colegios();
        String quer = "SELECT * FROM colegio WHERE id_colegio='" + id_colegio+"'";
        return (Colegios) jdbcTemplate.query
        (quer, (ResultSet rs) -> {
            if (rs.next()) {
                user.setNombre(rs.getString("nombre"));
                user.setDireccion(rs.getString("direccion"));
            }
            return user;
        });
    }
}