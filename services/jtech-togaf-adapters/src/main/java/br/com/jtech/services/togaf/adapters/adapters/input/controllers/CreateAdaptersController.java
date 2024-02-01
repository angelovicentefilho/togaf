
/*
*  @(#)AdaptersController.java
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
package br.com.jtech.services.togaf.adapters.adapters.input.controllers;

import br.com.jtech.services.togaf.adapters.adapters.input.protocols.AdaptersRequest;
import br.com.jtech.services.togaf.adapters.application.ports.input.CreateAdaptersInputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.jtech.services.togaf.adapters.application.core.domains.Adapters.of;

/**
* class AdaptersController
* 
* user angelo.vicente@jtech.corp
*/
@RestController
@RequestMapping("/api/v1/adapterss")
@RequiredArgsConstructor
public class CreateAdaptersController {

    private final CreateAdaptersInputGateway createAdaptersInputGateway;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody AdaptersRequest request) {
        createAdaptersInputGateway.create(of(request));
        return ResponseEntity.noContent().build();
     }
 }