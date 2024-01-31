/*
*  @(#)TogafResponse.java
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
package br.com.jtech.services.manager.togaf.adapters.input.protocols;

import br.com.jtech.services.manager.togaf.application.core.domains.Togaf;
import br.com.jtech.services.manager.togaf.adapters.output.repositories.entities.TogafEntity;
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
* class TogafResponse 
* 
* user angelo.vicente@jtech.corp 
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TogafResponse implements Serializable {
    private String id;
    List<TogafResponse> responses;

    public static TogafResponse of(Togaf togaf) {
        return TogafResponse.builder()
                .id(togaf.getId())
                .build();
    }

    public static TogafResponse of(List<TogafEntity> entities) {
        var list = entities.stream().map(TogafResponse::of).toList();
        return TogafResponse.builder()
                .responses(list)
                .build();
    }

    public static TogafResponse of(TogafEntity entity) {
        var response = new TogafResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }
}