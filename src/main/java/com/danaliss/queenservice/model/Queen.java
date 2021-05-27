package com.danaliss.queenservice.model;

import lombok.Data;
import lombok.val;

import javax.persistence.*;

@Data
@Entity
@Table(name = "queen")
public class Queen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private boolean winner;

    private boolean missCongeniality;

    public static Queen of(final ClientQueen pClientQueen){
        // final Queen queen = new Queen();
        val queen = new Queen();

        queen.name = pClientQueen.getName();
        queen.winner = pClientQueen.isWinner();
        queen.missCongeniality = pClientQueen.isMissCongeniality();

        return queen;
    }
}
