
package T1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LibreriaImporter {

    private static String url = "jdbc:mysql://localhost:3306/ad";
    
    public static void importar(String archivo){
        try {
            Connection con = DriverManager.getConnection(url, "root", "");
            crearTabla(con, archivo);
            importarDatos(con, archivo);
        } catch (SQLException ex) {
            Logger.getLogger(LibreriaImporter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void crearTabla(Connection con, String archivo){
        try {
            BufferedReader lectura = new BufferedReader(new FileReader(archivo));
            String linea;
            int count = 0;
            List<String> columnas = new ArrayList<>();
            
            while((linea = lectura.readLine()) != null && count < 1){
                columnas = Arrays.asList(linea.split(";"));
                count++;
            }
            
            String tabla = "CREATE TABLE IF NOT EXISTS libreria ("
                    + "id INT,";
            for(int i = 0; i < columnas.size(); i++){
                tabla += "`" + columnas.get(i) + "` TEXT,";
            }
            tabla += "date TEXT)";
                        
            Statement stmt = con.createStatement();
            
            boolean execution = stmt.execute(tabla);
            if(execution){
                System.out.println("Tabla creada");
            } else {
                System.out.println("Tabla no creada");
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LibreriaImporter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(LibreriaImporter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void importarDatos(Connection con, String archivo) {
        BufferedReader lectura;
        try {
            lectura = new BufferedReader(new FileReader(archivo));
            String linea;
            List<String> elements;
            Pelicula p;
            List<Pelicula> peliculas = new ArrayList<>();
            int count = 1, numLinea = 0;
            
            while((linea = lectura.readLine()) != null){
            
                if(numLinea > 1){
                    elements = Arrays.asList(linea.split(";"));
                    p = new Pelicula();
                    p.setId(count);
                    p.setTitulo(elements.get(0));
                    p.setAutor(elements.get(1));
                    p.setAnio(elements.get(2));
                    p.setGenero(elements.get(3));
                    p.setIdioma(elements.get(4));
                    p.setSipnosis(elements.get(5));
                    p.setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

                    peliculas.add(p);

                    count++;
                }
                
                numLinea++;
            }
            
            for(int i = 0; i < peliculas.size(); i++){
                anadirPelicula(con, peliculas.get(i));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LibreriaImporter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LibreriaImporter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void anadirPelicula(Connection con, Pelicula pel) {
        String sentence = "INSERT INTO libreria VALUES ('" + pel.getId() + "', '" + pel.getTitulo() + "', '" + pel.getAutor() + "', '" + pel.getAnio() + 
                "', '" + pel.getGenero() + "', '" + pel.getIdioma() + "', '" + pel.getSipnosis() + "','" + pel.getDate() + "')";

        Statement stmt;
        try {
            stmt = con.createStatement();
            int nFil = stmt.executeUpdate(sentence);
            System.out.println("Se han insertado " + nFil + " filas");
        } catch (SQLException ex) {
            Logger.getLogger(LibreriaImporter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
