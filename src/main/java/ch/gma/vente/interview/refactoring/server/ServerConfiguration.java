package ch.gma.vente.interview.refactoring.server;

import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ServerConfiguration implements WebMvcConfigurer {

  private final List<HandlerInterceptor> interceptors;

  public ServerConfiguration(List<HandlerInterceptor> interceptors) {
    this.interceptors = interceptors;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    interceptors.forEach(registry::addInterceptor);
  }
}
