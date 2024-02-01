/*
*  @(#)AdaptersResponse.java
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
package br.com.jtech.services.togaf.adapters.adapters.input.protocols;

import br.com.jtech.services.togaf.adapters.application.core.domains.Adapters;
import br.com.jtech.services.togaf.adapters.adapters.output.repositories.entities.AdaptersEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.List;

/**
* class AdaptersResponse 
* 
* user angelo.vicente@jtech.corp 
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdaptersResponse implements Serializable {
    private String id;
    List<AdaptersResponse> responses;

    public static AdaptersResponse of(Adapters adapters) {
        return AdaptersResponse.builder()
                .id(adapters.getId())
                .build();
    }

    public static AdaptersResponse of(List<AdaptersEntity> entities) {
        var list = entities.stream().map(AdaptersResponse::of).toList();
        return AdaptersResponse.builder()
                .responses(list)
                .build();
    }

    public static AdaptersResponse of(AdaptersEntity entity) {
        var response = new AdaptersResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }
}