package com.produce;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class Produto {

    @JsonProperty
    private Integer codigo;
    @JsonProperty
    private String nome;
    @JsonProperty
    private Long preco;

}
