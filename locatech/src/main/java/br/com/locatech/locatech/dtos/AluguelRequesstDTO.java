package br.com.locatech.locatech.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AluguelRequesstDTO(@NotNull(message = "O campo (pessoa_id) não pode ser nulo") Long pessoa_id,
                                 @NotNull(message = "O campo (veiculo_id) não pode ser nulo")Long veiculo_id,
                                 LocalDate data_inicio,
                                 LocalDate data_final
                                 ) {
}
