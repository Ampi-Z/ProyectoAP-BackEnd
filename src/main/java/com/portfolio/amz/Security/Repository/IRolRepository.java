
package com.portfolio.amz.Security.Repository;

import com.portfolio.amz.Security.Entity.Rol;
import com.portfolio.amz.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol , Integer>{
    
    Optional<Rol> findByRolNombre (RolNombre rolNombre) ;
}