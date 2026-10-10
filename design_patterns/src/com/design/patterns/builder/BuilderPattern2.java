package com.design.patterns.builder;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


final class HttpRequest {

    // 1. All fields are private and final to guarantee Immutability
    private final String url;
    private final String method;
    private final Map<String, String> headers;
    private final String body;
    private final int connectTimeoutMs;
    private final int readTimeoutMs;

    // 2. Private constructor: Enforces creation ONLY via the Builder
    private HttpRequest(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.headers = Collections.unmodifiableMap(new HashMap<>(builder.headers));
        this.body = builder.body;
        this.connectTimeoutMs = builder.connectTimeoutMs;
        this.readTimeoutMs = builder.readTimeoutMs;
    }

    // Getters only - No Setters!
    public String getUrl() { return url; }
    public String getMethod() { return method; }
    public Map<String, String> getHeaders() { return headers; }
    public String getBody() { return body; }
    public int getConnectTimeoutMs() { return connectTimeoutMs; }
    public int getReadTimeoutMs() { return readTimeoutMs; }

    // 3. Static Nested Builder Class
    public static class Builder {
        // Mandatory fields
        private final String url;
        private final String method;

        // Optional fields initialized with sensible defaults
        private Map<String, String> headers = new HashMap<>();
        private String body = "";
        private int connectTimeoutMs = 3000;
        private int readTimeoutMs = 5000;

        // Mandatory fields enforced via Builder Constructor
        public Builder(String url, String method) {
            if (url == null || url.isBlank()) {
                throw new IllegalArgumentException("URL cannot be null or empty");
            }
            if (method == null || method.isBlank()) {
                throw new IllegalArgumentException("Method cannot be null or empty");
            }
            this.url = url;
            this.method = method.toUpperCase();
        }

        // Fluent chainable methods for optional fields
        public Builder header(String key, String value) {
            this.headers.put(key, value);
            return this; // Return 'this' for method chaining
        }

        public Builder body(String body) {
            this.body = body != null ? body : "";
            return this;
        }

        public Builder connectTimeoutMs(int connectTimeoutMs) {
            if (connectTimeoutMs <= 0) {
                throw new IllegalArgumentException("Timeout must be greater than 0");
            }
            this.connectTimeoutMs = connectTimeoutMs;
            return this;
        }

        // Final validation before object creation
        public HttpRequest build() {
            return new HttpRequest(this);
        }
    }
}

public class BuilderPattern2 {
	public static void main(String[] args) {
        HttpRequest request = new HttpRequest.Builder("https://api.example.com/v1/orders", "POST")
                .header("Authorization", "Bearer token_xyz")
                .header("Content-Type", "application/json")
                .body("{\"item\": \"Laptop\", \"qty\": 1}")
                .connectTimeoutMs(2000)
                .build();

        System.out.println("Executing " + request.getMethod() + " to " + request.getUrl());
    }
}
