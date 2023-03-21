package com.example.demo.repositories;

import models.Alumnado;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnadoRepository extends JpaRepository<Alumnado, Long> {
    @Query("select * from alumnado where ad < 5")
    List<Alumnado> getAlumnosSuspensosAD();
    
    @Query("select * from alumnado where di < 5")
    List<Alumnado> getAlumnosSuspensosDI();
}
