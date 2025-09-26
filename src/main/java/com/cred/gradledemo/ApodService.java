package com.cred.gradledemo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ApodService {
  private final String nasaApodUrl;
  private final WebClient webClient;

  public ApodService(@Value("${application.nasa.apod.url}") String nasaApodUrl) {
    this.nasaApodUrl = nasaApodUrl;
    System.out.println("The URL is " + nasaApodUrl);

    this.webClient = WebClient.builder()
            .baseUrl(nasaApodUrl)
            .build();
  }

  public Mono<ApodResponse> getTodaysApod() {
    return webClient.get()
            .uri(uriBuilder -> uriBuilder
                    .queryParam("api_key", "DEMO_KEY")
                    .build())
            .retrieve()
            .bodyToMono(ApodResponse.class);
  }

  public Mono<ApodResponse> getApodByDate(String date) {
    return webClient.get()
            .uri(uriBuilder -> uriBuilder
                    .queryParam("api_key", "DEMO_KEY")
                    .queryParam("date", date)
                    .build())
            .retrieve()
            .bodyToMono(ApodResponse.class);
  }

  public Mono<ApodResponse> getRandomApod() {
    // Get a random date from the last year
    LocalDate randomDate = LocalDate.now().minusDays((long) (Math.random() * 365));
    String dateStr = randomDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

    return getApodByDate(dateStr);
  }
}
