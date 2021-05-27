package com.danaliss.queenservice.controller;

import com.danaliss.queenservice.Service;
import com.danaliss.queenservice.dao.QueenRepository;
import com.danaliss.queenservice.model.Queen;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class PublicApiController {

    @Autowired
    Service service;

    @Autowired
    private QueenRepository queenRepository;

    @PostMapping("/refresh-queens")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateDataThatDoesNotRequireClientToBeNotified() {

        service.addQueensToDb();
    }

    @GetMapping("/queens")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Queen> fetchAllQueens() {

        return service.fetchAllQueens();
    }
}
