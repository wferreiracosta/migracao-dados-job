package br.com.wferreiracosta.migracaodados.utils.queries;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class DadosBancariosQuery {

    public static final String INSERT_DADOS_BANCARIOS = "INSERT INTO dados_bancarios (id, pessoa_id, agencia, conta, banco)" +
            " VALUES (:id, :pessoaId, :agencia, :conta, :banco)";

}
