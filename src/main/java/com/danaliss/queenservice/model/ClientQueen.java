package com.danaliss.queenservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ClientQueen {

    private int id;
    private String name;
    private boolean winner;
    private boolean missCongeniality;
    private String quote;

}
