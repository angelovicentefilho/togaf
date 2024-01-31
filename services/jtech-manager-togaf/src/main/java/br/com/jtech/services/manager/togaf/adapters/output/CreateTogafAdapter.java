/*
*  @(#)TogafAdapter.java
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
package br.com.jtech.services.manager.togaf.adapters.output;

import br.com.jtech.services.manager.togaf.application.core.domains.Togaf;
import br.com.jtech.services.manager.togaf.application.ports.output.CreateTogafOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
* class TogafAdapter 
* 
* user angelo.vicente@jtech.corp  
*/
@Component
@RequiredArgsConstructor
public class CreateTogafAdapter implements CreateTogafOutputGateway {

    // private final TogafRepository repository;

    @Override
    public Togaf create(Togaf togaf) {
       // return this.repository.save(togaf);
          return togaf;
    }

}