package org.example.event;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class EventServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("EventServer started");
        Server server = ServerBuilder.forPort(50051).addService(new EventServiceImpl()).build();
        server.start();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Received shutdown request");
            server.shutdown();
            System.out.println("Successfully stopped the server");
        }));
        server.awaitTermination();
    }

}
