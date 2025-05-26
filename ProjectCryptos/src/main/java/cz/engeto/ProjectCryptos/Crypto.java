package cz.engeto.ProjectCryptos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Crypto {
    private Integer id;
    private String name;
    private String symbol;
    private Double price;
    private Double quantity;
}
