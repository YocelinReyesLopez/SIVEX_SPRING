package com.edu.utez.Sivex.Service.Usuario;

import com.edu.utez.Sivex.Models.Servicios.BeanServicios;
import com.edu.utez.Sivex.Models.Usuario.BeanUsuario;
import com.edu.utez.Sivex.Models.Usuario.UsuarioRepository;
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
public class ServiceUsuario {

    private final UsuarioRepository repository;
    public ServiceUsuario(UsuarioRepository repository) {
        this.repository = repository;
    }
    @Transactional(readOnly = true)
    public Optional<BeanUsuario> findUserByUsername(String Correo){
        return repository.findBycorreo(Correo);
    }
    @Transactional(readOnly=true)
    public ResponseEntity<ApiResponse> GetAll(){
        return new ResponseEntity<>(new ApiResponse(repository.findAll(), HttpStatus.OK,"Todo Bien :D"), HttpStatus.OK);
    }

    //Busqueda Individual
    @Transactional(readOnly=true)
    public ResponseEntity<ApiResponse>Buscar(Long id){
        Optional<BeanUsuario>UsuarioFound=repository.findById(id);
        if (UsuarioFound.isPresent()){
            return new ResponseEntity<>(new ApiResponse(UsuarioFound.get(),HttpStatus.OK, "Busqueda Complatada"),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new ApiResponse(null,HttpStatus.NOT_FOUND,"Registro No encontrado"), HttpStatus.NOT_FOUND);
        }
    }

    //Crear
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse>save(BeanUsuario usuario){
        Optional<BeanUsuario>FoundUsuario=repository.findBycorreo(usuario.getCorreo());
        if (FoundUsuario.isPresent())
            return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST,true,"Ese espacio la existe"),HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(new ApiResponse(repository.saveAndFlush(usuario),HttpStatus.OK,"Espacio Agregado"),HttpStatus.OK);
    }

    //Eliminar
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse>Delete(Long id){
        Optional<BeanUsuario>FoundUsuario=repository.findById(id);
        if (FoundUsuario.isPresent()){
            repository.deleteById(id);
            return new ResponseEntity<>(new ApiResponse(HttpStatus.OK,true,"Eliminacion Correcta"),HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse(null,HttpStatus.BAD_REQUEST,"Error dato no encontrado"),HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse>Update(Long id, BeanUsuario usuario){
        Optional<BeanUsuario>FoundUsuario=repository.findById(id);
        if (FoundUsuario.isPresent()){
            return new ResponseEntity<>(new ApiResponse(repository.saveAndFlush(usuario),HttpStatus.OK,"Actualizacion Correcta"),HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse(null,HttpStatus.BAD_REQUEST,"Registro no encontrado"),HttpStatus.NOT_FOUND);
    }

}
