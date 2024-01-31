/*
*  @(#)TogafUseCase.java
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
package br.com.jtech.services.manager.togaf.application.core.usecases;


import br.com.jtech.services.manager.togaf.application.core.domains.Togaf;
import br.com.jtech.services.manager.togaf.application.ports.input.CreateTogafInputGateway;
import br.com.jtech.services.manager.togaf.application.ports.output.CreateTogafOutputGateway;

/**
* class TogafUseCase  
* 
* user angelo.vicente@jtech.corp  
*/
public class CreateTogafUseCase implements CreateTogafInputGateway {

    private final CreateTogafOutputGateway createTogafOutputGateway;

    public CreateTogafUseCase(CreateTogafOutputGateway createTogafOutputGateway) {
        this.createTogafOutputGateway = createTogafOutputGateway;
     }

    public Togaf create(Togaf togaf) {
        return createTogafOutputGateway.create(togaf);
     }
 }