package com.atmostadam.cats.jbpm.configuration;

import com.atmostadam.cats.api.configuration.CatWebClientProperties;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Properties;


@ComponentScan(basePackages = "com.atmostadam.cats")
@EntityScan(basePackages = "com.atmostadam.cats")
@PropertySource("classpath:application.properties")
@EnableConfigurationProperties(CatWebClientProperties.class)
@EnableAutoConfiguration
@Configuration
public class CatJbpmConfiguration {
    private static final String DEFAULT_GROUP = "com.atmostadam.cats";
    private static final String DEFAULT_ARTIFACT = "cats-kjar";
    private static final String DEFAULT_VERSION = "0.0.42";

    @Bean(name = "buildProperties")
    public BuildProperties buildProperties() {
        Properties properties = new Properties();
        properties.setProperty("group", DEFAULT_GROUP);
        properties.setProperty("artifact", DEFAULT_ARTIFACT);
        properties.setProperty("version", DEFAULT_VERSION);
        return new BuildProperties(properties);
    }

    @Bean("CatWebClientPropertiesAdoptAPet")
    @ConfigurationProperties(prefix = "cats.service.http.webclient.adoptapet")
    public CatWebClientProperties catWebClientPropertiesAdoptAPet() {
        return new CatWebClientProperties();
    }

    @Bean("CatWebClientPropertiesPetfinder")
    @ConfigurationProperties(prefix = "cats.service.http.webclient.petfinder")
    public CatWebClientProperties catWebClientPropertiesPetfinder() {
        return new CatWebClientProperties();
    }
}
