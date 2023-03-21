package dao;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import models.Alumno;

public class Dao {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("alumnos.odb");

    public static void insertarAlumno(Alumno alumno){
        var em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(alumno);
        em.getTransaction().commit();
        em.close();
    }
    
    public static void listarTodo(){
        var em = emf.createEntityManager();
        TypedQuery<Alumno> query = em.createQuery("select u from Alumno u", Alumno.class);
        for(var alumno : query.getResultList()){
            System.out.println(alumno);
        }
        em.close();
    }
    
    public static void listarSuspensos(){
        var em = emf.createEntityManager();
        TypedQuery<Alumno> query = em.createQuery("select u from Alumno u where u.di < 5 or u.ad < 5", Alumno.class);
        for(var alumno : query.getResultList()){
            System.out.println(alumno);
        }
        em.close();

    }
    
    public static void estadisticas(){
       Double media1 = 0.0, media2 = 0.0;
       Long total = 0L, totalSinSuspender = 0L;
       
       var em = emf.createEntityManager();
       TypedQuery<Double> q1 = em.createQuery("select avg(u.ad) from Alumno u", Double.class);
       List<Double> lista1 = q1.getResultList();
       
       if(!lista1.isEmpty()){
           media1 = lista1.get(0);
       }
       
       TypedQuery<Double> q2 = em.createQuery("select avg(u.di) from Alumno u", Double.class);
       List<Double> lista2 = q2.getResultList();
       
       if(!lista2.isEmpty()){
           media2 = lista2.get(0);
       }

       TypedQuery<Long> q3 = em.createQuery("select count(u) from Alumno u where u.ad >= 5 and u.di >= 5", Long.class);
       List<Long> lista3 = q3.getResultList();
       
       if(!lista3.isEmpty()){
           totalSinSuspender = lista3.get(0);
       }

       TypedQuery<Long> q4 = em.createQuery("select count(u) from Alumno u", Long.class);
       List<Long> lista4 = q4.getResultList();
       
       if(!lista4.isEmpty()){
           total = lista4.get(0);
       }
       
       double ratio = ((double) totalSinSuspender) / total;
       
        System.out.println("Media del módulo DI: " + media2);
        System.out.println("Media del módulo AD: " + media1);
        System.out.println("Total sin suspender: " + totalSinSuspender);
        System.out.println("Total alumnos: " + total);
        System.out.println("Ratio de aprobados: " + ratio);
    }
}
