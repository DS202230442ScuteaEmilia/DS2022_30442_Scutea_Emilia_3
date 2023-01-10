package assignment1.grpc_impl;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class ServerImpl {
    public static void main(String[] args) throws IOException, InterruptedException {
        final int PORT = 9090;

        //create a new server to listen on port 9090
        Server server = ServerBuilder.forPort(PORT)
                .addService(new GreetServiceImpl())
                .build();

        //start the server
        server.start();

        //server threads are running in the background
        System.out.println("Server started...");
        // don't exit the main thread, wait until server is terminated
        server.awaitTermination();
    }
}
