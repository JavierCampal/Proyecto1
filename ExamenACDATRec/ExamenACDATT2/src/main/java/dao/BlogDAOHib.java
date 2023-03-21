package dao;

import com.javier.examenacdatt2.HibernateUtils;
import java.util.ArrayList;
import models.Entrada;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class BlogDAOHib implements BlogDAO{

    @Override
    public void guardar(Entrada e) {
        try(var s = HibernateUtils.getSessionFactory().openSession()){
            Transaction t = s.beginTransaction();
            s.save(e);
            t.commit();
        }    
    }

    @Override
    public void portada() {
        try(var s = HibernateUtils.getSessionFactory().openSession()){
            Query consulta = s.createQuery("from Entrada");
            var listado = (ArrayList<Entrada>) consulta.list();
            
            for(int i = 0; i < 3; i++){
                System.out.println(listado.get(i));
            }
        }      
    }
    
}
