package com.danaliss.queenservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Queen implements Serializable {

    private int id;
    private String name;
    private boolean winner;
    private boolean missCongeniality;
    private String quote;

}
