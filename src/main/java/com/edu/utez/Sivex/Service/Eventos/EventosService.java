package com.edu.utez.Sivex.Service.Eventos;

import com.edu.utez.Sivex.Models.Eventos.BeanEventos;
import com.edu.utez.Sivex.Models.Eventos.EventosRepository;
import com.edu.utez.Sivex.Models.Usuario.BeanUsuario;
import com.edu.utez.Sivex.config.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Optional;
@Service
@Transactional
@AllArgsConstructor
public class EventosService {
    private final EventosRepository repository;
    @Transactional(readOnly=true)
    public ResponseEntity<ApiResponse> GetAll(){
        return new ResponseEntity<>(new ApiResponse(repository.findAll(), HttpStatus.OK,"Todo Bien :D"), HttpStatus.OK);
    }

    //Busqueda Individual
    @Transactional(readOnly=true)
    public ResponseEntity<ApiResponse>Buscar(Long id){
        Optional<BeanEventos> EventoFound=repository.findById(id);
        if (EventoFound.isPresent()){
            return new ResponseEntity<>(new ApiResponse(EventoFound.get(),HttpStatus.OK, "Busqueda Complatada"),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new ApiResponse(null,HttpStatus.NOT_FOUND,"Registro No encontrado"), HttpStatus.NOT_FOUND);
        }
    }

    //Crear
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse>save(BeanEventos eventos){
        Optional<BeanEventos>FoundUsuario=repository.findById(eventos.getId());
        if (FoundUsuario.isPresent())
            return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST,true,"Ese espacio la existe"),HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(new ApiResponse(repository.saveAndFlush(eventos),HttpStatus.OK,"Espacio Agregado"),HttpStatus.OK);
    }

    //Eliminar
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse>Delete(Long id){
        Optional<BeanEventos>EventoFound=repository.findById(id);
        if (EventoFound.isPresent()){
            repository.deleteById(id);
            return new ResponseEntity<>(new ApiResponse(HttpStatus.OK,true,"Eliminacion Correcta"),HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse(null,HttpStatus.BAD_REQUEST,"Error dato no encontrado"),HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse>Update(Long id, BeanEventos eventos){
        Optional<BeanEventos>EventoFound=repository.findById(id);
        if (EventoFound.isPresent()){
            return new ResponseEntity<>(new ApiResponse(repository.saveAndFlush(eventos),HttpStatus.OK,"Actualizacion Correcta"),HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse(null,HttpStatus.BAD_REQUEST,"Registro no encontrado"),HttpStatus.NOT_FOUND);
    }
}
