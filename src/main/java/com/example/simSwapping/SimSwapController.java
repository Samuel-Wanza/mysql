package com.example.simSwapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class SimSwapController {

    @Autowired
    private SimSwapService simSwapService;

    @GetMapping("/simSwap")
    public Mono<String> simSwapCheck(@RequestParam String username, @RequestParam String phoneNumber) {
        return simSwapService.checkSimSwap(username, phoneNumber);
    }
}

