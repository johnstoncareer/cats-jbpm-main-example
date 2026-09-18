package com.atmostadam.cats.jbpm.configuration;

import com.atmostadam.cats.api.configuration.CatConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Import({CatJbpmConfiguration.class, CatConfiguration.class})
@ComponentScan(basePackages = "com.atmostadam.cats")
@EntityScan(basePackages = "com.atmostadam.cats")
@EnableAutoConfiguration
@TestConfiguration
public class CatJbpmTestConfiguration {
}
