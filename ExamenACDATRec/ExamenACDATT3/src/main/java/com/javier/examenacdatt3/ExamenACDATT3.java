package com.javier.examenacdatt3;

import models.Alumno;
import dao.Dao;

public class ExamenACDATT3 {

    public static void main(String[] args) {
        
        Alumno a1 = new Alumno();
        Alumno a2 = new Alumno();
        Alumno a3 = new Alumno(); 
        Alumno a4 = new Alumno();
        Alumno a5 = new Alumno();

        a1.setNombre("Lucas");
        a1.setTelefono("111-222-333");
        a1.setEmail("lucas@gmail.com");
        a1.setDi(6);
        a1.setAd(5);
        
        a2.setNombre("Maria");
        a2.setTelefono("444-555-666");
        a2.setEmail("maria@gmail.com");
        a2.setDi(5);
        a2.setAd(5);
        
        a3.setNombre("Sofia");
        a3.setTelefono("777-888-999");
        a3.setEmail("sofia@gmail.com");
        a3.setDi(4);
        a3.setAd(5);
        
        a4.setNombre("Nerea");
        a4.setTelefono("123-456-789");
        a4.setEmail("nerea@gmail.com");
        a4.setDi(4);
        a4.setAd(4);
        
        a5.setNombre("Marcos");
        a5.setTelefono("111-222-333");
        a5.setEmail("marcos@gmail.com");
        a5.setDi(3);
        a5.setAd(5);

        Dao.insertarAlumno(a1);        
        Dao.insertarAlumno(a2);
        Dao.insertarAlumno(a3);
        Dao.insertarAlumno(a4);
        Dao.insertarAlumno(a5);
                
        Dao.listarTodo();
                
        Dao.listarSuspensos();
               
        Dao.estadisticas();
    }
}
