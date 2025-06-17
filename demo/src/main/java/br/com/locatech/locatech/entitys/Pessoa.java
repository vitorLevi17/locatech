package br.com.locatech.locatech.entitys;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class Pessoa {

    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
}
