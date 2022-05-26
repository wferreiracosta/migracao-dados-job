package br.com.wferreiracosta.migracaodados.reader;

import br.com.wferreiracosta.migracaodados.domain.Pessoa;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.validation.BindException;

import static br.com.wferreiracosta.migracaodados.utils.mappers.PessoaMapper.map;

@Configuration
public class ArquivoPessoasReaderConfig {

    @Bean
    public FlatFileItemReader<Pessoa> arquivoPessoaReader() {
        return new FlatFileItemReaderBuilder<Pessoa>()
                .name("arquivoPessoaReader")
                .resource(new FileSystemResource("files/pessoas.csv"))
                .delimited()
                .names("nome", "email", "dataNascimento", "idade", "id")
                .addComment("--") // Ignorar linha com comentario
                .fieldSetMapper(fieldSetMapper())
                .build();
    }

    // Mapeador costumizado, criado por causa do campo data nascimento
    private FieldSetMapper<Pessoa> fieldSetMapper() {
        return new FieldSetMapper<Pessoa>() {
            @Override
            public Pessoa mapFieldSet(FieldSet fieldSet) throws BindException {
                return map(fieldSet);
            }
        };
    }

}
