package com.vitalapi.Entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@Data
public class Administrador extends Usuario{
}
