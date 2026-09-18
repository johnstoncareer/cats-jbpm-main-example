package com.atmostadam.cats.jbpm.service;

import com.atmostadam.cats.api.configuration.CatWebClientProperties;
import com.atmostadam.cats.api.model.Cat;
import com.atmostadam.cats.api.model.in.CatRequest;
import com.atmostadam.cats.api.model.out.CatResponse;
import com.atmostadam.cats.framework.rest.CatWebClient;
import com.atmostadam.cats.jbpm.configuration.CatJbpmTestConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static com.atmostadam.cats.framework.data.CatTestValues.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

@SpringJUnitConfig(CatJbpmTestConfiguration.class)
public class PostAdoptAPetCatTest {
    @Autowired
    PostAdoptAPetCat adoptAPet;

    @MockBean
    CatWebClient client;

    @Test
    void injection() {
        assertThat(adoptAPet, notNullValue());
        assertThat(client, notNullValue());
    }

    @Test
    void httpStatus200() {
        long microchipNumber = 431655446132657L;
        Cat cat = catTestData().setMicrochipNumber(microchipNumber);

        ResponseEntity<CatResponse> mockResponse = new CatResponse()
                .setMessage(TEST_MESSAGE)
                .addCat(cat)
                .newResponseEntity(TEST_REQUEST_ID, HttpStatus.OK);

        when(client.invoke(isA(CatWebClientProperties.class), isA(String.class), isA(Object.class))).thenReturn(mockResponse);

        ResponseEntity<CatResponse> response = adoptAPet.invoke(TEST_REQUEST_ID, new CatRequest()
                .addMicrochipNumber(microchipNumber)
                .addCat(cat));

        assertThat(response, notNullValue());
        assertThat(response.getStatusCode().value(), equalTo(200));
    }
}
