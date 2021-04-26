package io.github.PatrickZerbinatti.apiv1.controller;

import io.github.PatrickZerbinatti.apiv1.model.Usuario;
import io.github.PatrickZerbinatti.apiv1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/usuario")
public class app {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public app(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public List<Usuario> buscaUsuario(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/{nome}")
    public List<Usuario> buscaUsuarioNome(@PathVariable("nome") String nome){
        return usuarioRepository.findByNome(nome);
    }

    @PostMapping
    public ResponseEntity<?> criaUsuario(@RequestBody Usuario usuario){

        Usuario usuarioValido = new Usuario();
        usuarioValido.setNome(usuario.getNome());
        usuarioValido.setDataNasc(usuario.getDataNasc());
        usuarioRepository.insert(usuarioValido);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alteraTudoUsuarioNome(@RequestBody Usuario usuario,@PathVariable String id){
        if (usuarioRepository.findById(id).isPresent()){

            Usuario usuarioValido = usuarioRepository.findById(id).get();
            usuarioValido.setNome(Optional.ofNullable(usuario.getNome()).orElse(usuarioValido.getNome()));
            usuarioValido.setDataNasc(Optional.ofNullable(usuario.getDataNasc()).orElse(usuarioValido.getDataNasc()));


            usuarioRepository.save(usuarioValido);
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletaUsuarioNome(@PathVariable String id){
        if (usuarioRepository.findById(id).isPresent()){
            usuarioRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }



}
