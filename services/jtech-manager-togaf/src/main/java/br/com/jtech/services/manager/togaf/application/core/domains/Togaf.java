/*
*  @(#)Togaf.java
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
package br.com.jtech.services.manager.togaf.application.core.domains;

import br.com.jtech.services.manager.togaf.adapters.input.protocols.TogafRequest;
import br.com.jtech.services.manager.togaf.adapters.output.repositories.entities.TogafEntity;
import lombok.*;

import java.util.UUID;
import java.util.List;


/**
* class Togaf 
* 
* user angelo.vicente@jtech.corp 
*/
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Togaf {

    private String id;

    public static List<Togaf> of(List<TogafEntity> entities) {
        return entities.stream().map(Togaf::of).toList();
     }

    public TogafEntity toEntity() {
        return TogafEntity.builder()
            .id(UUID.fromString(getId()))
            .build();
     }

    public static Togaf of(TogafEntity entity) {
        return Togaf.builder()
            .id(entity.getId().toString())
            .build();
     }

    public static Togaf of(TogafRequest request) {
        return Togaf.builder()
            .id(request.getId())
            .build();
     }
 }