package br.com.wferreiracosta.migracaodados.jobs;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@Configuration
@EnableBatchProcessing
public class MigracaoDadosJobConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job migracaoDadosJob(
            @Qualifier("migrarPessoasStep") Step migrarPessoasStep,
            @Qualifier("migrarDadosBancariosStep") Step migrarDadosBancariosStep
    ) {
        return jobBuilderFactory
                .get("migracaoDadosJob")
                .start(startStepsParalelos(migrarPessoasStep, migrarDadosBancariosStep))
                .end()
                .incrementer(new RunIdIncrementer())
                .build();
    }

    // Fazendo os steps INDENPENDENTES rodarem juntos
    private Flow startStepsParalelos(Step migrarPessoasStep, Step migrarDadosBancariosStep) {
        final var migrarDadosBancariosFlow = new FlowBuilder<Flow>("migrarDadosBancariosFlow")
                .start(migrarDadosBancariosStep)
                .build();

        return new FlowBuilder<Flow>("stepsParalelosFlow")
                .start(migrarPessoasStep)
                .split(new SimpleAsyncTaskExecutor())
                .add(migrarDadosBancariosFlow)
                .build();
    }

}
