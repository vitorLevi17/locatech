package br.com.locatech.locatech.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AluguelRequesstDTO(@NotNull(message = "O campo (pessoa_id) não pode ser nulo") Long pessoa_id,
                                 @NotNull(message = "O campo (veiculo_id) não pode ser nulo")Long veiculo_id,
                                 @NotNull(message = "O campo (data_inicio) não pode ser nulo") LocalDate data_inicio,
                                 @NotNull(message = "O campo (data_final) não pode ser nulo") LocalDate data_final
                                 ) {
}
