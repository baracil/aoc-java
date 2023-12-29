package fpc.aoc.input;

import fpc.aoc.api.Day;
import fpc.aoc.api.RawInput;
import fpc.aoc.api.Year;
import fpc.aoc.common.AOCException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@RequiredArgsConstructor
public class AOCWebsite implements RawInput {

  private final Year year;
  private final Day day;
  private final String sessionId;

  @Override
  public @NonNull List<String> read() {
    try (final var client = HttpClient.newHttpClient()) {
      final var request = createRequest();
      return client.send(request, HttpResponse.BodyHandlers.ofLines()).body().toList();
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new AOCException("Request interrupted", e);
    }
  }

  private HttpRequest createRequest() {
    final var uri = URI.create("https://adventofcode.com/%d/day/%d/input".formatted(year.numericalValue(), day.numericalValue()));
    return HttpRequest.newBuilder(uri)
        .GET()
        .setHeader("Cookie", "session=%s".formatted(sessionId))
        .build();
  }
}
