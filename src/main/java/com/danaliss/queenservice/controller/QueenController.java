package com.danaliss.queenservice.controller;

import com.danaliss.queenservice.model.Queen;
import com.danaliss.queenservice.service.QueenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1")
@Slf4j
public class QueenController {

    @Autowired
    QueenService queenService;

//    @PostMapping("/refresh-queens")
//    @ResponseStatus(value = HttpStatus.OK)
//    public void updateDataThatDoesNotRequireClientToBeNotified() {
//        queenService.fetchAllQueens();
//    }

    @GetMapping("/queens")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<Queen[]> fetchAllQueens() {
        return queenService.fetchAllQueens();
    }
}
