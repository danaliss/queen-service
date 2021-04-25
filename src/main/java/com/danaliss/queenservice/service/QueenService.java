package com.danaliss.queenservice.service;

import com.danaliss.queenservice.model.Queen;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class QueenService {

    private final WebClient webClient;

    public QueenService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://www.nokeynoshade.party/api").build();
    }

    public Mono<Queen[]> fetchAllQueens() {
        Mono<Queen[]> allQueens;
        allQueens = this.webClient.get().uri("/queens/all")
                .retrieve().bodyToMono(Queen[].class);
        log.info(String.valueOf(allQueens));
        return allQueens;
    }
}
