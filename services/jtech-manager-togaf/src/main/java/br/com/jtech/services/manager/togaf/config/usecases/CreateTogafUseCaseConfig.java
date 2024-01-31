/*
*  @(#)TogafUseCaseConfig.java
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
package br.com.jtech.services.manager.togaf.config.usecases;

import br.com.jtech.services.manager.togaf.adapters.output.CreateTogafAdapter;
import br.com.jtech.services.manager.togaf.application.core.usecases.CreateTogafUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* class TogafUseCaseConfig
* 
* user angelo.vicente@jtech.corp
*/
@Configuration
public class CreateTogafUseCaseConfig {

    @Bean
    public CreateTogafUseCase useCase(CreateTogafAdapter createTogafAdapter) {
        return new CreateTogafUseCase(createTogafAdapter);
     }

 }