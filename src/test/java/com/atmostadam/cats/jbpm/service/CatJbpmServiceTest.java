package com.atmostadam.cats.jbpm.service;

import com.atmostadam.cats.api.model.in.CatRequest;
import com.atmostadam.cats.api.model.out.CatResponse;
import com.atmostadam.cats.jbpm.configuration.CatJbpmTestConfiguration;
import org.jbpm.test.JbpmJUnitBaseTestCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static com.atmostadam.cats.framework.data.CatTestValues.catRequestTestData;
import static com.atmostadam.cats.framework.data.CatTestValues.catResponseTestData;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

@SpringJUnitConfig(CatJbpmTestConfiguration.class)
class CatJbpmServiceTest extends JbpmJUnitBaseTestCase {
    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    CatJbpmService service;

    @Test
    void testInjection() throws Exception {
        assertThat(applicationContext, notNullValue());
        assertThat(service, notNullValue());


        CatRequest catRequest = catRequestTestData();
        CatResponse catResponse = catResponseTestData();

    }
}
