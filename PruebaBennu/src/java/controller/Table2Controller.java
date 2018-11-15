
package controller;

import modelos.Conectar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
public class Table2Controller 
{
    private JdbcTemplate jdbcTemplate;
    
    public Table2Controller()
    {
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("table2.htm")
    public ModelAndView table2()
    {
        ModelAndView mav=new ModelAndView();
        String sql="SELECT P.id_profesor as id_profesor ,P.id_colegio as id_colegio,P.id_asignatura as id_asignatura, P.nombre AS nombre,P.activo AS activo,C.nombre AS colegio, A.nombre AS asignatura "
                + "FROM profesor as P, colegio as C, asignatura as A "
                + "WHERE P.id_colegio=C.id_colegio and P.id_asignatura=A.id_asignatura";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos",datos);
        mav.setViewName("table2");
        return mav;
    }
}
