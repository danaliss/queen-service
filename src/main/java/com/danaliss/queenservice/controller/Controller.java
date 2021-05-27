package com.danaliss.queenservice.controller;

import com.danaliss.queenservice.Service;
import com.danaliss.queenservice.dao.QueenRepository;
import com.danaliss.queenservice.model.Queen;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/v1/queens")
@Slf4j
public class Controller {

    @Autowired
    Service service;

    @Autowired
    private QueenRepository queenRepository;

    @GetMapping("/{id}")
    public Queen read(@PathVariable("id") final int pId) {
        return queenRepository.findById(pId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "cannot find referenced queen"));
    }

    @GetMapping
    public Iterable<Queen> getAll() {
        return queenRepository.findAll();
    }

    @GetMapping("/winners")
    public Iterable<Queen> getAllWinners() {
        return queenRepository.findAllWinners();
    }

    @PostMapping
    public Queen create(@RequestBody Queen pQueen) {

        return queenRepository.save(pQueen);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final int pId) {
        if (!queenRepository.existsById(pId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "cannot find referenced queen");
        }

        queenRepository.deleteById(pId);
    }

    @PutMapping("/{id}")
    public Queen update(@PathVariable("id") final int pId, @RequestBody Queen pQueen) {
        if (!queenRepository.existsById(pId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "cannot find referenced queen");
        }
        return queenRepository.save(pQueen);
    }
}
