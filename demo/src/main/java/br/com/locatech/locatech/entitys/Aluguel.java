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
    private Long pessoa;
    private Long veiculo;
    private String veiculo_modelo;
    private String pessoaCPF;
    private String pessoaNome;
    private LocalDate data_inicial;
    private LocalDate data_final;
    private BigDecimal valor_total;
}
