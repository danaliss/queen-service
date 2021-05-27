package com.danaliss.queenservice;

import com.danaliss.queenservice.dao.QueenRepository;
import com.danaliss.queenservice.model.ClientQueen;
import com.danaliss.queenservice.model.Queen;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Component
@Slf4j
public class Service {

    // field name needs to be the same name in order to use Config @Bean
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private QueenRepository queenRepository;

    private WebClient webClient;

    @PostConstruct
    public void postConstruct() {
        webClient = webClientBuilder.baseUrl("http://www.nokeynoshade.party/api").build();
    }

    public List<Queen> fetchAllQueens() {
        Mono<ClientQueen[]> allQueens = webClient.get()
                .uri("/queens/all")
                .retrieve()
                .bodyToMono(ClientQueen[].class);

        return Optional.ofNullable(allQueens.block())
                .map(clientQueens -> Arrays.stream(clientQueens)
                        .map(object -> Queen.of(object))
                        .collect(Collectors.toList()))
                .orElse((List<Queen>) (Collections.EMPTY_LIST));
    }

    // post queens to DB
    public List<Queen> addQueensToDb() {
        List<Queen> queens = new ArrayList<>();
        for (Queen queen : fetchAllQueens()) {
            log.info(queen.toString());
            queens.add(queenRepository.save(queen));
        }
        return queens;
    }

}
