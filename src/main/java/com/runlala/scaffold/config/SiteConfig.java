package com.runlala.scaffold.config;

import lombok.Data;
import org.mapstruct.Named;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@ConfigurationProperties(prefix = "site")
@Data
public class SiteConfig {
    private String staticBaseUrl;

    @Named("completeStaticUrl")
    public String getStaticBaseUrl(String uri) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(staticBaseUrl);
        builder.pathSegment(uri);
        return builder.build().toUriString();
    }
}
