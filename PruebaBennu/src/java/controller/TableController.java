
package controller;

import modelos.Conectar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
public class TableController 
{
    private JdbcTemplate jdbcTemplate;
    
    public TableController()
    {
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("table.htm")
    public ModelAndView table()
    {
        ModelAndView mav=new ModelAndView();
        String sql="select * from colegio";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos",datos);
        mav.setViewName("table");
        return mav;
    }
}
