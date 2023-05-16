
package com.portfolio.amz.Repository;

import com.portfolio.amz.Entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IProyectosRepository extends JpaRepository<Proyectos, Integer>{
    Optional<Proyectos> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
