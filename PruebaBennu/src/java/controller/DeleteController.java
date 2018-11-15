
package controller;

import modelos.Conectar;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


public class DeleteController {
    private JdbcTemplate jdbcTemplate;
    public DeleteController()
    {
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar() );
    }
    
    @RequestMapping("delete.htm")
    public ModelAndView delete(HttpServletRequest request) 
    {
        int id_colegio=Integer.parseInt(request.getParameter("id_colegio"));
        this.jdbcTemplate.update(
                "delete from colegio "
                + "where "
                + "id_colegio=? ",
        id_colegio);
        return new ModelAndView("redirect:/table.htm");
    }
}
