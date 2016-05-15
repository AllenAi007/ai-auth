package org.ai.sso;

import com.sun.net.httpserver.HttpServer;
import org.ai.sso.resource.AuthResource;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * Main class.
 */
@Component
@ApplicationPath("")
public class SsoApplication extends ResourceConfig {

    private static final Logger LOG = LoggerFactory.getLogger(SsoApplication.class);

    // Base URI the JDK HTTP server will listen on
    @Value("${sso.baseUri}")
    public String baseUri = "http://localhost:8080/";

    public final static String BASE_URI = "http://localhost:8080/";

    public static HttpServer server;

    public SsoApplication() {
        register(JacksonFeature.class);
        packages(AuthResource.class.getPackage().getName());

        // Optionally remove existing handlers attached to j.u.l root logger
        SLF4JBridgeHandler.removeHandlersForRootLogger();  // (since SLF4J 1.6.5)

        // add SLF4JBridgeHandler to j.u.l's root logger, should be done once during
        // the initialization phase of your application
        SLF4JBridgeHandler.install();
    }

    public static void main(String args[]) {
        startJdkHttpServer();
    }

    public static HttpServer startJdkHttpServer() {
        URI baseUri = UriBuilder.fromUri(BASE_URI).build();
        server = JdkHttpServerFactory.createHttpServer(baseUri, new SsoApplication());
        LOG.info("Server started on : {}", baseUri.toString());
        return server;
    }


}

