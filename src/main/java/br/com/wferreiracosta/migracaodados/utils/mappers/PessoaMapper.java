package br.com.wferreiracosta.migracaodados.utils.mappers;

import br.com.wferreiracosta.migracaodados.domain.Pessoa;
import lombok.NoArgsConstructor;
import org.springframework.batch.item.file.transform.FieldSet;

import java.util.Date;

import static br.com.wferreiracosta.migracaodados.utils.DateUtils.DEFAULT_DATE_TIME_FORMAT;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class PessoaMapper {

    public static Pessoa map(FieldSet fieldSet) {
        return Pessoa.builder()
                .nome(fieldSet.readString("nome"))
                .email(fieldSet.readString("email"))
                .dataNascimento(new Date(fieldSet.readDate("dataNascimento", DEFAULT_DATE_TIME_FORMAT).getTime()))
                .idade(fieldSet.readInt("idade"))
                .id(fieldSet.readInt("id"))
                .build();
    }

}
