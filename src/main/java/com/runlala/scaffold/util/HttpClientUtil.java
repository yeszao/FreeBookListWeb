package com.runlala.scaffold.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Objects;

@Slf4j
public class HttpClientUtil {
    static ObjectMapper objectMapper = new ObjectMapper();
    static HttpClient client;

    public static HttpClient getHttpClient() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
        if (Objects.isNull(client)) {
            client = HttpClient.newBuilder().sslContext(sslContext).build();
        }
        return client;
    }

    public static <T> T get(String url, Map<String, String> params, String apiKey, TypeReference<T> responseType) throws IOException, InterruptedException, NoSuchAlgorithmException, KeyManagementException {
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(url + buildParams(params)))
                .GET()
                .header("Accept", "application/json")
                .header("X-API-Key", apiKey)
                .build();
        HttpResponse<String> httpResponse = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(httpResponse.body(), responseType);
    }

    public static HttpResponse<InputStream> getStream(String url, Map<String, String> params, String apiKey) throws IOException, InterruptedException, NoSuchAlgorithmException, KeyManagementException {
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(url + buildParams(params)))
                .GET()
                .header("Accept", "application/json")
                .header("X-API-Key", apiKey)
                .build();
        return getHttpClient().send(request, HttpResponse.BodyHandlers.ofInputStream());
    }

    private static final TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                }

                public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                }
            }
    };

    public static String buildParams(Map<String, String> params) {
        if (params == null || params.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("?");
        for (Map.Entry<String, String> entry : params.entrySet()) {
            sb.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8))
                    .append("=")
                    .append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8))
                    .append("&");
        }
        // Remove trailing '&'
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public static HttpHeaders convertHeaders(java.net.http.HttpHeaders sourceHeaders) {
        HttpHeaders targetHeaders = new HttpHeaders();
        sourceHeaders.map().forEach(targetHeaders::addAll);
        return targetHeaders;
    }
}
