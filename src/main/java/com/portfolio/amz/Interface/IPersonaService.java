
package com.portfolio.amz.Interface;

import com.portfolio.amz.Entity.Persona;
import java.util.List;

public interface IPersonaService {
    
    //traer una lista de Personas 
    public List<Persona> getPersona();

    //guardar un objeto de tipo Persona
    public void savePersona(Persona persona);
    
    //Eliminar un objeto encontrado por id
    public void deletePersona (Long id);
    
    //Buscar una persona por id
    public Persona findPersona (Long id);
}
