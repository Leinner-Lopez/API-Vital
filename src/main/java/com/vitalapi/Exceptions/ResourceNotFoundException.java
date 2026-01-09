package com.vitalapi.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ResourceNotFoundException extends RuntimeException {
    private String mensaje;
}
