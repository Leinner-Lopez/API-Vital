package com.vitalapi.Repositories.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisponibilidadDTO {
    private LocalDateTime inicio;
    private LocalDateTime fin;
}
