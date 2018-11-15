
package controller;

import modelos.Conectar;
import modelos.Colegios;
import modelos.ColegiosValidar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("add.htm")
public class AddController {
    ColegiosValidar colegiosValidar;
    private JdbcTemplate jdbcTemplate;
    
    public AddController() 
    {
        this.colegiosValidar=new ColegiosValidar();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar() );
    }
    @RequestMapping(method=RequestMethod.GET) 
    public ModelAndView form()
    {
        ModelAndView mav=new ModelAndView();
        mav.setViewName("add");
        mav.addObject("colegios",new Colegios());
        return mav;
    }
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
                @ModelAttribute("colegios") Colegios u,
                BindingResult result,
                SessionStatus status
        )
    {
        this.colegiosValidar.validate(u, result);
        if(result.hasErrors())
        {
            ModelAndView mav=new ModelAndView();
            mav.setViewName("add");
            mav.addObject("colegios",new Colegios());
            return mav;
        }else
        {
        this.jdbcTemplate.update
        (
        "insert into colegio (nombre,direccion ) values (?,?)",
         u.getNombre(),u.getDireccion()
        );
         return new ModelAndView("redirect:/table.htm");
        }
       
    }
}
