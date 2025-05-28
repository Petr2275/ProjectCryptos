package cz.engeto.ProjectCryptos;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.Getter;



@Data
@AllArgsConstructor
public class Crypto {
    @Getter
    private Integer id;
    private String name;
    private String symbol;
    private Double price;
    private Double quantity;

}
