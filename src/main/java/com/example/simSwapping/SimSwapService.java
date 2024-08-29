package com.example.simSwapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
public class SimSwapService {

    @Autowired
    private WebClient webClient;

    private static final String SIM_SWAP_URL = "https://insights.sandbox.africastalking.com/v1/sim-swap";
    private static final String API_KEY = "atsk_239e760c8d83565992600f27bb224826718b370dba777b6ef97db562ce6e020038af6132";

    public Mono<String> checkSimSwap(String username, String phoneNumber) {
        // Create the request body
        String requestBody = String.format("{\"username\": \"%s\", \"phoneNumber\": [\"%s\"]}", username, phoneNumber);
        System.out.println(requestBody);

        return webClient.post()
                .uri(SIM_SWAP_URL)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header("apiKey", API_KEY)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .doOnError(WebClientResponseException.class, ex -> {
                    // Handle error response
                    System.err.println("API request failed: " + ex.getMessage());
                });
    }
}
