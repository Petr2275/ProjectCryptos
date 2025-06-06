package cz.engeto.ProjectCryptos.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Data
@Getter
public class Crypto {

    private Integer id;
    private String name;
    private String symbol;
    private Double price;
    private Double quantity;

}
