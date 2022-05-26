package br.com.wferreiracosta.migracaodados.writers;

import br.com.wferreiracosta.migracaodados.domains.DadosBancarios;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

import static br.com.wferreiracosta.migracaodados.utils.queries.DadosBancariosQuery.INSERT_DADOS_BANCARIOS;

@Configuration
public class BancoDadosBancariosWriterConfig {

    @Bean
    public JdbcBatchItemWriter<DadosBancarios> bancoDadosBancariosWriter(
            @Qualifier("appDataSource") DataSource dataSource
    ) {
        return new JdbcBatchItemWriterBuilder<DadosBancarios>()
                .dataSource(dataSource)
                .sql(INSERT_DADOS_BANCARIOS)
                .beanMapped() // Pode ser usado para mapear os argumentos da query quando os nomes forem iguais dos atributos
                .build();
    }

}
