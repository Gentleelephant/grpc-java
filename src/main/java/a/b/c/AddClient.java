package a.b.c;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class AddClient {

    ManagedChannel channel;
    AddServiceGrpc.AddServiceBlockingStub stub;
    public static void main(String[] args) {

        int a = 10;
        int b = 20;

        AddClient addClient = new AddClient();
        AddReply add = addClient.stub.add(AddRequest.newBuilder().setA(a).setB(b).build());
        System.out.println(add.getRes());


    }

    public AddClient(){
        channel = ManagedChannelBuilder
                .forAddress("localhost",9999)
                .usePlaintext()
                .build();
        stub = AddServiceGrpc.newBlockingStub(channel);
    }

}
