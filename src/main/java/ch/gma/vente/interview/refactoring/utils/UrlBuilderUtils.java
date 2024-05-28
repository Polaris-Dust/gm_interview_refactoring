package ch.gma.vente.interview.refactoring.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.util.UriComponentsBuilder;

public class UrlBuilderUtils {

  private UrlBuilderUtils() {
  }

  public static String buildUrl(String serverHost, String serverPort) {
    return buildUrl(serverHost, serverPort, null);
  }

  public static String buildUrl(String serverHost, String serverPort, String path) {
    UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(serverHost);
    if (StringUtils.isBlank(uriComponentsBuilder.build().getHost())) {
      uriComponentsBuilder = UriComponentsBuilder.newInstance()
        .host(StringUtils.defaultString(StringUtils.substringBefore(serverHost, "/"), serverHost))
        .path(StringUtils.substringAfter(serverHost, "/"));
    }
    if (StringUtils.isNotEmpty(path)) {
      uriComponentsBuilder.path(path);
    }
    if (StringUtils.isNotBlank(serverPort)) {
      uriComponentsBuilder.port(serverPort);
    }
    return StringUtils.stripStart(StringUtils.stripEnd(uriComponentsBuilder.build().toUriString(), "/"), "/");
  }

}
