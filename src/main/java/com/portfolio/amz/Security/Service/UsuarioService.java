
package com.portfolio.amz.Security.Service;

import com.portfolio.amz.Security.Entity.Usuario;
import com.portfolio.amz.Security.Repository.IUsuarioRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    IUsuarioRepository iusuarioRepository ;
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return iusuarioRepository.findByNombreUsuario (nombreUsuario) ;
    }
    
    public boolean existsByNombreUsuario (String nombreUsuario){
        return iusuarioRepository.existByNombreUsuario(nombreUsuario) ;
    }
    
    public boolean existsByEmail (String email){
        return iusuarioRepository.existByNombreUsuario(email) ;
    }
    
    public void save ( Usuario usuario ){
        iusuarioRepository.save(usuario) ;
    }
}
