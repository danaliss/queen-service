package com.danaliss.queenservice;

import com.danaliss.queenservice.model.Queen;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@Slf4j
public class Controller {

    @Autowired
    ServiceImpl service;

    @PostMapping("/refresh-queens")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateDataThatDoesNotRequireClientToBeNotified() {
        return;
    }

    @GetMapping("/queens")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Queen> fetchAllQueens() {
        return service.fetchAllQueens();
    }
}
