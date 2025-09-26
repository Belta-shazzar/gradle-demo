package com.cred.gradledemo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
//@CrossOrigin(origins = "*")
@RequestMapping("/api/apod")
public class ApodController {
  private final ApodService nasaApodService;

  @GetMapping("/today")
  public Mono<ApodResponse> getTodaysApod() {
    return nasaApodService.getTodaysApod();
  }

  @GetMapping("/date/{date}")
  public Mono<ApodResponse> getApodByDate(@PathVariable String date) {
    return nasaApodService.getApodByDate(date);
  }

  @GetMapping("/random")
  public Mono<ApodResponse> getRandomApod() {
    return nasaApodService.getRandomApod();
  }

  @GetMapping("/info")
  public String getInfo() {
    return "NASA Astronomy Picture of the Day API endpoints:\n" +
            "- GET /api/apod/today - Get today's APOD\n" +
            "- GET /api/apod/date/{yyyy-MM-dd} - Get APOD for specific date\n" +
            "- GET /api/apod/random - Get random APOD from the last year";
  }
}
