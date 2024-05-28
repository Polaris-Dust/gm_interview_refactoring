package ch.gma.vente.interview.refactoring.resources;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
  path = "/hello",
  produces = MediaType.APPLICATION_JSON_VALUE
)
@Slf4j
public class HelloWordController {

  @GetMapping("world")
  public String world() {
    log.debug("Producing message");
    return "Hello world";
  }

  @GetMapping("cruel-world")
  public String cruelWorld() {
    log.debug("Producing failure message");
    throw new IllegalStateException("Expected failure");
  }
}
