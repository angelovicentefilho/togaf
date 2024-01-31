
/*
*  @(#)TogafController.java
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
package br.com.jtech.services.manager.togaf.adapters.input.controllers;

import br.com.jtech.services.manager.togaf.adapters.input.protocols.TogafRequest;
import br.com.jtech.services.manager.togaf.application.ports.input.CreateTogafInputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.jtech.services.manager.togaf.application.core.domains.Togaf.of;

/**
* class TogafController
* 
* user angelo.vicente@jtech.corp
*/
@RestController
@RequestMapping("/api/v1/togafs")
@RequiredArgsConstructor
public class CreateTogafController {

    private final CreateTogafInputGateway createTogafInputGateway;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody TogafRequest request) {
        createTogafInputGateway.create(of(request));
        return ResponseEntity.noContent().build();
     }
 }