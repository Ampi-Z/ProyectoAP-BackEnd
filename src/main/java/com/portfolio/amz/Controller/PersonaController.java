
package com.portfolio.amz.Controller;

import com.portfolio.amz.Entity.Persona;
import com.portfolio.amz.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class PersonaController {
    @Autowired IPersonaService iPersonaService;

    @GetMapping (value = "/personas/traer")
    public List<Persona> getPersona() {
        return iPersonaService.getPersona();
    }

    @PostMapping (value = "/personas/crear")
    public String createPersona(@RequestBody Persona persona) {
        iPersonaService.savePersona(persona);
        return "Persona creada correctamente" ;
    }

    @DeleteMapping(value = "/personas/borrar/{id}")
    public String deletePersona (@PathVariable Long id) {
        iPersonaService.deletePersona(id);
        return "Persona borrada correctamente" ;
    }

    //URL: PUERTO/personas/editar/num?nombre=n&apellido=a&img=i

    @PutMapping (value = "/personas/editar/{id}")
    public Persona editPersona (@PathVariable Long id , @RequestParam("nombre") String nuevoNombre
                                                      , @RequestParam("apellido") String nuevoApellido
                                                      , @RequestParam("img") String nuevaImg) {

        Persona persona = iPersonaService.findPersona(id) ;
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevaImg);

        iPersonaService.savePersona(persona);

        return persona ;
    }

    @GetMapping ("/personas/traer/perfil")
    public Persona findPersona(){
        return iPersonaService.findPersona( (long) 1);
    }
    
}
