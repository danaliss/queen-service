package com.danaliss.queenservice.service;

import com.danaliss.queenservice.model.Queen;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class QueenService {

    private final WebClient webClient;

    public QueenService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://www.nokeynoshade.party/api").build();
    }

    public List<Queen> fetchAllQueens() {
        Mono<Queen[]> allQueens = this.webClient.get()
                .uri("/queens/all")
                .retrieve()
                .bodyToMono(Queen[].class);

        Queen[] queens = allQueens.block();
        ObjectMapper mapper = new ObjectMapper();

        List<Queen> queenList = Arrays.stream(queens)
                .map(object -> mapper.convertValue(object, Queen.class))
                .collect(Collectors.toList());

        return queenList;
    }

    // post queens to DB

}
