package io.github.PatrickZerbinatti.apiv1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "cliente")
public class Usuario {
    @Id
    private String id;
    private String nome;
    private Date dataNasc;
}
