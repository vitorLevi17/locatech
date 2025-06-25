package br.com.locatech.locatech.entitys;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Veiculo {

    private Long id;
    @NotBlank(message = "O campo (marca) não pode ser nulo")
    private String marca;
    @NotBlank(message = "O campo (modelo) não pode ser nulo")
    private String modelo;
    @NotBlank(message = "O campo (placa) não pode ser nulo")
    private String placa;
    @Min(value = 1000, message = "Ano inválido: deve ter 4 dígitos")
    @Max(value = 9999, message = "Ano inválido: deve ter 4 dígitos")
    private int ano;
    @NotBlank(message = "O campo (cor) não pode ser nulo")
    private String cor;
    @Min(value = 20,message = "O valor minimo de uma diaria é de: R$20 ")
    private BigDecimal diaria_valor;
}