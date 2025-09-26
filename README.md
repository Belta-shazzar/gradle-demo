# NASA APOD Spring Boot Application

A Spring Boot application that integrates with NASA's Astronomy Picture of the Day (APOD) API to fetch stunning space images and their descriptions.

## Features

- Fetch today's Astronomy Picture of the Day
- Get APOD for any specific date
- Get a random APOD from the past year
- RESTful API endpoints
- Reactive programming with WebFlux

## API Endpoints

- `GET /api/apod/today` - Get today's APOD
- `GET /api/apod/date/{yyyy-MM-dd}` - Get APOD for a specific date
- `GET /api/apod/random` - Get a random APOD
- `GET /api/apod/info` - Get API information

## Quick Start

1. Clone the project
2. Run `./gradlew bootRun`
3. Visit `http://localhost:8080/api/apod/today`

## Example Response

```json
{
  "date": "2023-12-01",
  "explanation": "A beautiful explanation of the cosmic phenomenon...",
  "hdurl": "https://apod.nasa.gov/apod/image/2312/example_hd.jpg",
  "media_type": "image",
  "service_version": "v1",
  "title": "Amazing Space Object",
  "url": "https://apod.nasa.gov/apod/image/2312/example.jpg"
}
```

## Technologies Used

- Spring Boot 3.2.0
- Spring WebFlux (for reactive HTTP calls)
- Jackson (JSON processing)
- Gradle (build tool)
- Java 17