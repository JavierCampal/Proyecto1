package com.javier.examenacdatt2;

import dao.BlogDAOHib;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import models.Comentario;
import models.Entrada;

public class ExamenACDATT2 {

    public static void main(String[] args) {
        Entrada e1 = new Entrada();
        Entrada e2 = new Entrada();
        Entrada e3 = new Entrada();
        Entrada e4 = new Entrada();
        
        Comentario c1 = new Comentario();
        Comentario c2 = new Comentario();
        Comentario c3 = new Comentario();
        Comentario c4 = new Comentario();        
        Comentario c5 = new Comentario();
        Comentario c6 = new Comentario();
        Comentario c7 = new Comentario();
        Comentario c8 = new Comentario();
        
        e1.setTitulo("Entrada 1");
        e1.setContenido("Contenido 1");
        e1.setEnlace("Enlace 1");
        e1.setFecha(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        
        e2.setTitulo("Entrada 2");
        e2.setContenido("Contenido 2");
        e2.setEnlace("Enlace 2");
        e2.setFecha(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        
        e3.setTitulo("Entrada 3");
        e3.setContenido("Contenido 3");
        e3.setEnlace("Enlace 3");
        e3.setFecha(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        
        e4.setTitulo("Entrada 4");
        e4.setContenido("Contenido 4");
        e4.setEnlace("Enlace 4");
        e4.setFecha(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        
        c1.setEmail("user1@gmail.com");
        c1.setComentario("Comentario 1");
        c1.setFecha(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        c1.setEntrada(e1);
        
        c2.setEmail("user2@gmail.com");
        c2.setComentario("Comentario 2");
        c2.setFecha(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        c2.setEntrada(e1);
        
        e1.setComentarios(List.of(c1, c2));
        
        c3.setEmail("user3@gmail.com");
        c3.setComentario("Comentario 3");
        c3.setFecha(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        c3.setEntrada(e2);
        
        c4.setEmail("user4@gmail.com");
        c4.setComentario("Comentario 4");
        c4.setFecha(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        c4.setEntrada(e2);
        
        e2.setComentarios(List.of(c3, c4));

        c5.setEmail("user5@gmail.com");
        c5.setComentario("Comentario 5");
        c5.setFecha(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        c5.setEntrada(e3);
        
        c6.setEmail("user6@gmail.com");
        c6.setComentario("Comentario 6");
        c6.setFecha(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        c6.setEntrada(e3);
        
        e3.setComentarios(List.of(c5, c6));
        
        c7.setEmail("user7@gmail.com");
        c7.setComentario("Comentario 7");
        c7.setFecha(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        c7.setEntrada(e4);
        
        c8.setEmail("user8@gmail.com");
        c8.setComentario("Comentario 8");
        c8.setFecha(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        c8.setEntrada(e4);
        
        e4.setComentarios(List.of(c7, c8));

        BlogDAOHib dao = new BlogDAOHib();
        
        dao.guardar(e1);
        dao.guardar(e2);
        dao.guardar(e3);
        dao.guardar(e4);

        dao.portada();
    }
}
