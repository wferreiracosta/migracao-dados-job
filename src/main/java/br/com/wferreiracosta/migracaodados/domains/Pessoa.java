package br.com.wferreiracosta.migracaodados.domains;

import lombok.*;
import org.apache.logging.log4j.util.Strings;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    private int id;
    private String nome;
    private String email;
    private Date dataNascimento;
    private int idade;

    public Boolean isValida(){
        return !Strings.isBlank(nome) &&
                !Strings.isBlank(email) &&
                (dataNascimento != null);
    }

}
