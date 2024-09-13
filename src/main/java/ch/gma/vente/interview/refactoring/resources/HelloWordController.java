package ch.gma.vente.interview.refactoring.resources;

import org.slf4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
  path = "/hello",
  produces = MediaType.APPLICATION_JSON_VALUE
)
public class HelloWordController {

  private static final Logger log = org.slf4j.LoggerFactory.getLogger(HelloWordController.class);

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
