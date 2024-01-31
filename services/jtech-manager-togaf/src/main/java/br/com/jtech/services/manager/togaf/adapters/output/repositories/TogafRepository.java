/*
*  @(#)TogafRepository.java
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
package br.com.jtech.services.manager.togaf.adapters.output.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.jtech.services.manager.togaf.adapters.output.repositories.entities.TogafEntity;

import java.util.UUID;

/**
* class TogafRepository 
* 
* @author angelo.vicente@jtech.corp
*/
@Repository
public interface TogafRepository extends JpaRepository<TogafEntity, UUID> {
    
}