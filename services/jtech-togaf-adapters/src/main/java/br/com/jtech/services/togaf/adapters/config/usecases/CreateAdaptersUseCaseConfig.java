/*
*  @(#)AdaptersUseCaseConfig.java
*
*  Copyright (c) J-Tech Solucoes em Informatica.
*  All Rights Reserved.
*
*  This software is the confidential and proprietary information of J-Tech.
*  ("Confidential Information"). You shall not disclose such Confidential
*  Information and shall use it only in accordance with the terms of the
*  license agreement you entered into with J-Tech.
*
*/
package br.com.jtech.services.togaf.adapters.config.usecases;

import br.com.jtech.services.togaf.adapters.adapters.output.CreateAdaptersAdapter;
import br.com.jtech.services.togaf.adapters.application.core.usecases.CreateAdaptersUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* class AdaptersUseCaseConfig
* 
* user angelo.vicente@jtech.corp
*/
@Configuration
public class CreateAdaptersUseCaseConfig {

    @Bean
    public CreateAdaptersUseCase useCase(CreateAdaptersAdapter createAdaptersAdapter) {
        return new CreateAdaptersUseCase(createAdaptersAdapter);
     }

 }