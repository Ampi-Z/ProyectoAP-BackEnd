
package com.portfolio.amz.Controller;

import com.portfolio.amz.Dto.dtoPersona;
import com.portfolio.amz.Entity.Persona;
import com.portfolio.amz.Security.Controller.Mensaje;
import com.portfolio.amz.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/personas")
@CrossOrigin(origins={"http://localhost:4200", "https://portfolio-amz.web.app"})
public class PersonaController {
    @Autowired
    ImpPersonaService impPersonaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = impPersonaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
   
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!impPersonaService.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Persona persona = impPersonaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona){
        if(!impPersonaService.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
        }
        if(impPersonaService.existsByNombre(dtopersona.getNombre()) && impPersonaService.getByNombre(dtopersona.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Esa persona ya existe"), HttpStatus.BAD_REQUEST);  
        }
        if(StringUtils.isBlank(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre no puede estar en blanco"), HttpStatus.BAD_REQUEST);  
        }
        
        Persona persona = impPersonaService.getOne(id).get();
        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        persona.setDescripcion(dtopersona.getDescripcion());
        persona.setImg(dtopersona.getImg());
        impPersonaService.save(persona);
        return new ResponseEntity(new Mensaje("Persona Actualizada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtopersona){
        if(StringUtils.isBlank(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("Campo nombre obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(impPersonaService.existsByNombre(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("Esa Experiencia existe"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = new Persona(dtopersona.getNombre(),dtopersona.getApellido(),dtopersona.getImg(), dtopersona.getDescripcion());
        impPersonaService.save(persona);
        return new ResponseEntity(new Mensaje("Persona agregada"), HttpStatus.OK);
       
    }
}
