package br.com.locatech.locatech.dtos;

import java.time.LocalDate;

public record AluguelRequesstDTO(Long pessoa_id,
                                 Long veiculo_id,
                                 LocalDate data_inicio,
                                 LocalDate data_final
                                 ) {
}
