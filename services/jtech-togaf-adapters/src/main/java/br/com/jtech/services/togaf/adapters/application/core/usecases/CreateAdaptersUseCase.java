/*
*  @(#)AdaptersUseCase.java
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
package br.com.jtech.services.togaf.adapters.application.core.usecases;


import br.com.jtech.services.togaf.adapters.application.core.domains.Adapters;
import br.com.jtech.services.togaf.adapters.application.ports.input.CreateAdaptersInputGateway;
import br.com.jtech.services.togaf.adapters.application.ports.output.CreateAdaptersOutputGateway;

/**
* class AdaptersUseCase  
* 
* user angelo.vicente@jtech.corp  
*/
public class CreateAdaptersUseCase implements CreateAdaptersInputGateway {

    private final CreateAdaptersOutputGateway createAdaptersOutputGateway;

    public CreateAdaptersUseCase(CreateAdaptersOutputGateway createAdaptersOutputGateway) {
        this.createAdaptersOutputGateway = createAdaptersOutputGateway;
     }

    public Adapters create(Adapters adapters) {
        return createAdaptersOutputGateway.create(adapters);
     }
 }