
package controller;

import modelos.Conectar;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


public class Delete2Controller {
    private JdbcTemplate jdbcTemplate;
    public Delete2Controller()
    {
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar() );
    }
    
    @RequestMapping("delete2.htm")
    public ModelAndView delete2(HttpServletRequest request) 
    {
        int id_profesor=Integer.parseInt(request.getParameter("id_profesor"));
        this.jdbcTemplate.update(
                "DELETE FROM profesor where id_profesor=? ",
        id_profesor);
        return new ModelAndView("redirect:/table2.htm");
    }
}
