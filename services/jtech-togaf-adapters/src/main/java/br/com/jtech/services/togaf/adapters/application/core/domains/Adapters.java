/*
*  @(#)Adapters.java
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
package br.com.jtech.services.togaf.adapters.application.core.domains;

import br.com.jtech.services.togaf.adapters.adapters.input.protocols.AdaptersRequest;
import br.com.jtech.services.togaf.adapters.adapters.output.repositories.entities.AdaptersEntity;
import lombok.*;

import java.util.UUID;
import java.util.List;


/**
* class Adapters 
* 
* user angelo.vicente@jtech.corp 
*/
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Adapters {

    private String id;

    public static List<Adapters> of(List<AdaptersEntity> entities) {
        return entities.stream().map(Adapters::of).toList();
     }

    public AdaptersEntity toEntity() {
        return AdaptersEntity.builder()
            .id(UUID.fromString(getId()))
            .build();
     }

    public static Adapters of(AdaptersEntity entity) {
        return Adapters.builder()
            .id(entity.getId().toString())
            .build();
     }

    public static Adapters of(AdaptersRequest request) {
        return Adapters.builder()
            .id(request.getId())
            .build();
     }
 }