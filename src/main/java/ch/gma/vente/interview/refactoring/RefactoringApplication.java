package ch.gma.vente.interview.refactoring;

import java.time.Clock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
public class RefactoringApplication {

  public static void main(String[] args) {
    SpringApplication.run(RefactoringApplication.class, args);
  }

  @Bean
  public Clock systemClock() {
    return Clock.systemUTC();
  }

}
