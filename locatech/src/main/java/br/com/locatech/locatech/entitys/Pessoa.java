package br.com.locatech.locatech.entitys;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class Pessoa {

    private Long id;
    @NotBlank(message = "Este campo não pode estar vazio")
    private String nome;
    @Size(min = 11,max = 11,message = "CPF inválido")
    private String cpf;
    @NotBlank(message = "Este campo não pode estar vazio")
    private String telefone;
    @NotBlank(message = "Este campo não pode estar vazio")
    private String email;
}
