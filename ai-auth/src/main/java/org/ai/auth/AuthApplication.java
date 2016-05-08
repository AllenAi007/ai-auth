package org.ai.auth;

import com.sun.net.httpserver.HttpServer;
import org.ai.auth.resource.AuthenticationResource;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * Main class.
 */
public class AuthApplication extends ResourceConfig {

    private static final Logger LOG = LoggerFactory.getLogger(AuthApplication.class);

    // Base URI the JDK HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8080/auth/";

    public static HttpServer server ;

    public AuthApplication() {
        register(JacksonFeature.class);
        register(LoggingFilter.class);
        register(AuthenticationResource.class.getPackage());
    }

    public static void main(String args[]) {
        startJdkHttpServer();
    }

    public static HttpServer startJdkHttpServer() {
        URI baseUri = UriBuilder.fromUri(BASE_URI).build();
        server = JdkHttpServerFactory.createHttpServer(baseUri, new AuthApplication());
        LOG.info("Server started on : {}", baseUri.toString());
        return server;
    }

}

