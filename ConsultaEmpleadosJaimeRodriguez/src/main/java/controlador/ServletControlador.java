package controlador;

import dao.DaoEmpleado;
import datos.Empleado;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.sql.DataSource;

@WebServlet(name = "ServletControlador", urlPatterns = {"/ServletControlador"})
public class ServletControlador extends HttpServlet {

    @Resource(name="jdbc/resource_empleados")
    DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        request.setAttribute("nombre", nombre);
        DaoEmpleado dao=new DaoEmpleado();
        try {
            ArrayList<Empleado> listaEmpleados = (ArrayList<Empleado>)dao.getEmpleesByFirstName(nombre, dataSource.getConnection());
            request.setAttribute("listaEmpleados", listaEmpleados);
//            request.setAttribute("busquedaEmpleado", busquedaEmpleado);
            request.getRequestDispatcher("vistafinal.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("vistafinal.jsp").forward(request, response);
        } finally {

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
