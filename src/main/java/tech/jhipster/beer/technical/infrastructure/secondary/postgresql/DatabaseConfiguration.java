package tech.jhipster.beer.technical.infrastructure.secondary.postgresql;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories({ "tech.jhipster.beer" })
@EnableTransactionManagement
public class DatabaseConfiguration {}
