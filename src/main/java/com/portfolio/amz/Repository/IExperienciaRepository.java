
package com.portfolio.amz.Repository;

import com.portfolio.amz.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia, Integer>{
    public Optional<Experiencia> findByNombreEx(String nombreEx);
    public boolean existsByNombreEx(String nombreEx);
}
