/*
*  @(#)AdaptersAdapter.java
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
package br.com.jtech.services.togaf.adapters.adapters.output;

import br.com.jtech.services.togaf.adapters.application.core.domains.Adapters;
import br.com.jtech.services.togaf.adapters.application.ports.output.CreateAdaptersOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
* class AdaptersAdapter 
* 
* user angelo.vicente@jtech.corp  
*/
@Component
@RequiredArgsConstructor
public class CreateAdaptersAdapter implements CreateAdaptersOutputGateway {

    // private final AdaptersRepository repository;

    @Override
    public Adapters create(Adapters adapters) {
       // return this.repository.save(adapters);
          return adapters;
    }

}