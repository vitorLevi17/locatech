package br.com.locatech.locatech.entitys;

import br.com.locatech.locatech.enums.TpUsuarioEnum;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Usuarios {
    private Long id;
    private String usuario;
    private String senha;
    private TpUsuarioEnum tpUsuarioEnum;
}
