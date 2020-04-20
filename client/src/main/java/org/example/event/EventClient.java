package org.example.event;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class EventClient {

    public static void main(String[] args) {
        System.out.println("Hello Event Client");
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
        EventServiceGrpc.EventServiceBlockingStub client = EventServiceGrpc.newBlockingStub(channel);
        Event event = Event.newBuilder().setId("100").setName("Mani").setType("Test").build();
        EventRequest eventRequest = EventRequest.newBuilder().setEvent(event).build();
        EventResponse eventResponse = client.sendEvent(eventRequest);
        System.out.println("The Response is : " + eventResponse.getEvent());
        System.out.println("Shutting down channel");
        channel.shutdown();
    }

}
