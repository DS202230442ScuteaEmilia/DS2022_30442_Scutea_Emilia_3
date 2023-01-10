package assignment1.grpc_impl;


import assignment1.grpc.grpc.*;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;

public class GreetServiceImpl extends GreetServiceGrpc.GreetServiceImplBase {

    List<Greeting> messages = new ArrayList<>();
    @Override
    public void greet(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {
        System.out.println("you are in the greet method of the greet service");

        // we get the greeting object from the request
        Greeting greeting = request.getGreeting();
        String result = "From: " + greeting.getFrom() + "To: " + greeting.getTo() + "Message:"+ greeting.getMessage();

        //build our response
        GreetResponse response = GreetResponse.newBuilder()
                .setResult(result)
                .build();

        messages.add(greeting);

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getMessages(Empty request, StreamObserver<Messages> responseObserver) {
        Messages response = Messages.newBuilder().addAllMessages(messages).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
