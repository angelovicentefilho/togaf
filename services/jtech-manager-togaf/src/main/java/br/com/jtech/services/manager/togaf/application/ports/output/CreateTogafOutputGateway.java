/*
*  @(#)TogafOutputGateway.java
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
package br.com.jtech.services.manager.togaf.application.ports.output;

import br.com.jtech.services.manager.togaf.application.core.domains.Togaf;

/**
* class TogafOutputGateway 
* 
* user angelo.vicente@jtech.corp 
*/
public interface CreateTogafOutputGateway {
    Togaf create(Togaf togaf);
}