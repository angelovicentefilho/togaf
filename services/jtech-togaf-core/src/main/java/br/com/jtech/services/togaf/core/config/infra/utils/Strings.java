package br.com.jtech.services.togaf.core.config.infra.utils;

import lombok.experimental.UtilityClass;

import static java.util.Objects.nonNull;

@UtilityClass
public class Strings {

    public static boolean hasText(String value) {
        return nonNull(value) && !value.isEmpty();
    }

}
