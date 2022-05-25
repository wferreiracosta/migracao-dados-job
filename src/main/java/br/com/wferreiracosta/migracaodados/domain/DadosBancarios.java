package br.com.wferreiracosta.migracaodados.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DadosBancarios {

    private int id;
    private int pessoaId;
    private int agencia;
    private int conta;

}
