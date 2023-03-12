package dao;

import datos.Empleado;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class DaoEmpleado {

    public static List<Empleado>getEmpleesByFirstName(String nombre, Connection con) throws SQLException, Exception{
            ResultSet rs = null;
            Statement st = null;
            ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();

            try {
                st = con.createStatement();
                String query ="select empleado.codigo,empleado.nombre, empleado.apellido1, empleado.apellido2, empleado.nif from empleado where nombre ='"+nombre+"';";
                rs = st.executeQuery(query);
           
                while(rs.next()){
                    Empleado empleado = new Empleado();
                    empleado.setCodigo(rs.getInt("codigo"));
                    empleado.setNombre(rs.getString("nombre"));
                    empleado.setApellido1(rs.getString("apellido1"));
                    empleado.setApellido2(rs.getString("apellido2"));
                    empleado.setNif(rs.getString("nif"));                 

                    listaEmpleados.add(empleado);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw e;
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }finally{
                if (rs!=null)            
                    rs.close();
                if (st!=null)            
                    st.close();
                if (con!=null)            
                    con.close();
            }
            return listaEmpleados;
    }
    
}
