package com.edu.utez.Sivex.Service.Servicios;

import com.edu.utez.Sivex.Models.Servicios.BeanServicios;
import com.edu.utez.Sivex.Models.Servicios.ServiciosRepository;
import com.edu.utez.Sivex.config.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Optional;
@Service
@Transactional
@AllArgsConstructor
public class ServicesExtra {
    private final ServiciosRepository repository;

    @Transactional(readOnly=true)
    public ResponseEntity<ApiResponse> GetAll(){
        return new ResponseEntity<>(new ApiResponse(repository.findAll(), HttpStatus.OK,"Todo Bien :D"), HttpStatus.OK);
    }

    //Busqueda Individual
    @Transactional(readOnly=true)
    public ResponseEntity<ApiResponse>Buscar(Long id){
        Optional<BeanServicios> EspacioFound=repository.findById(id);
        if (EspacioFound.isPresent()){
            return new ResponseEntity<>(new ApiResponse(EspacioFound.get(),HttpStatus.OK, "Busqueda Complatada"),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new ApiResponse(null,HttpStatus.NOT_FOUND,"Registro No encontrado"), HttpStatus.NOT_FOUND);
        }
    }

    //Crear
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse>save(BeanServicios servicios){
        Optional<BeanServicios>FoundServicio=repository.findByNombre(servicios.getNombre());
        if (FoundServicio.isPresent())
            return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST,true,"Ese espacio la existe"),HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(new ApiResponse(repository.saveAndFlush(servicios),HttpStatus.OK,"Espacio Agregado"),HttpStatus.OK);
    }

    //Eliminar
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse>Delete(Long id){
        Optional<BeanServicios>FoundServicio=repository.findById(id);
        if (FoundServicio.isPresent()){
            repository.findById(id);
            return new ResponseEntity<>(new ApiResponse(HttpStatus.OK,true,"Eliminacion Correcta"),HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse(null,HttpStatus.BAD_REQUEST,"Error dato no encontrado"),HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse>Update(Long id, BeanServicios servicios){
        Optional<BeanServicios>FoundServicio=repository.findById(id);
        if (FoundServicio.isPresent()){
            return new ResponseEntity<>(new ApiResponse(repository.saveAndFlush(servicios),HttpStatus.OK,"Actualizacion Correcta"),HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse(null,HttpStatus.BAD_REQUEST,"Registro no encontrado"),HttpStatus.NOT_FOUND);
    }
}
