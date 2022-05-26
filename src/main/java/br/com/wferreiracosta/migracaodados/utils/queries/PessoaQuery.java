package br.com.wferreiracosta.migracaodados.utils.queries;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class PessoaQuery {

    public static final String INSERT_PESSOA = "INSERT INTO pessoa (id, nome, email, data_nascimento)" +
            " VALUES (?,?,?,?,?)";

}
