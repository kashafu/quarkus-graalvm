package org.acme.getting.started;

import io.quarkus.amazon.lambda.runtime.QuarkusStreamHandler;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

    public String greeting(String name) {
        return "hello " + name;
    }

}
