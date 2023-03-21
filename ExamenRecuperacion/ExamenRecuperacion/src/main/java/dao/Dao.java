package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Alumno;

public class Dao {
    private static String URL = "jdbc:mysql://localhost:3306/acdat";
    
    public static List<Alumno> getAlumnos(){
        try {
            Connection con = DriverManager.getConnection(URL, "root", "");
            Statement stmt = con.createStatement();
            List<Alumno> alumnos = new ArrayList<>();
            Alumno a;
            
            String sql = "select * from alumnos;";
            
            var result = stmt.executeQuery(sql);
            
            while(result.next()){
                a = new Alumno(result.getString("nombre"), result.getString("apellidos"), result.getDouble("ad"),
                    result.getDouble("sge"), result.getDouble("di"), result.getDouble("pmdm"),
                    result.getDouble("psp"), result.getDouble("eie"), result.getDouble("hlc"));
                alumnos.add(a);
            }
            
            return alumnos;
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
            return List.of();
        }
    }
    
    public static Alumno getByNombre(String nombre, String apellidos){
        try{
            Connection con = DriverManager.getConnection(URL, "root", "");
            Statement stmt = con.createStatement();
            Alumno a = null;
            
            String sql = "select * from alumnos where nombre = '" + nombre + "' and apellidos = '" + apellidos + "';";
            
            var result = stmt.executeQuery(sql);
            
            while(result.next()){
                a = new Alumno(result.getString("nombre"), result.getString("apellidos"), result.getDouble("ad"),
                    result.getDouble("sge"), result.getDouble("di"), result.getDouble("pmdm"),
                    result.getDouble("psp"), result.getDouble("eie"), result.getDouble("hlc"));
            }
            
            return a;

        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static void aniadir(Alumno a){
        try{
            Connection con = DriverManager.getConnection(URL, "root", "");
            Statement stmt = con.createStatement();
            
            String sql = "INSERT INTO alumnos values ('" + a.getNombre() + "', '" + a.getApellidos() + "', '" + a.getAd() +"', '" + a.getSge()
                    + "', '" + a.getDi() + "', '" + a.getPmdm() + "', '" + a.getPsp()+ "', '" + a.getEie() + "', '" + a.getHlc()+ "')";
            
            stmt.executeUpdate(sql);
         
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
