package io.github.PatrickZerbinatti.apiv1.repository;

import io.github.PatrickZerbinatti.apiv1.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario,String> {
    List<Usuario> findByNome(String nome);
}
