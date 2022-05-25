package br.com.wferreiracosta.migracaodados.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    private int id;
    private String nome;
    private String email;
    private Date dataNascimento;
    private int idade;

}
