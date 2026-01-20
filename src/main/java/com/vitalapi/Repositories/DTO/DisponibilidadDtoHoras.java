package com.vitalapi.Repositories.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DisponibilidadDtoHoras{
    private LocalDateTime inicio;
    private LocalDateTime fin;
}
