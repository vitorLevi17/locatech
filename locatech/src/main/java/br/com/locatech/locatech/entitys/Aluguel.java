package br.com.locatech.locatech.entitys;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Aluguel {
    private Long id;
    private Long pessoa_id;
    private Long veiculo_id;
    private String veiculo_modelo;
    private String pessoa_CPF;
    private String pessoa_nome;
    private LocalDate data_inicio;
    private LocalDate data_final;
    private BigDecimal valor_total;
}
