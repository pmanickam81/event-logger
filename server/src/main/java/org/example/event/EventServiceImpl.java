package org.example.event;

import io.grpc.stub.StreamObserver;

public class EventServiceImpl extends EventServiceGrpc.EventServiceImplBase{
    @Override
    public void sendEvent(EventRequest request, StreamObserver<EventResponse> responseObserver) {
        System.out.println("Inside EventServiceImpl");
        Event event = request.getEvent();
        EventResponse response = EventResponse.newBuilder().setEvent(event).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
