
package com.portfolio.amz.Security.Repository;

import com.portfolio.amz.Security.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario , Integer>{
    
    Optional<Usuario> findByNombreUsuario (String nombreUsuario) ;
    
    boolean existByNombreUsuario (String nombreUsuario) ;
    boolean existByEmail (String email) ;
}
