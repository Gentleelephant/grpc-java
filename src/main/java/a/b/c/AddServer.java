package a.b.c;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class AddServer extends AddServiceGrpc.AddServiceImplBase{

    public static void main(String[] args) {

        Server build = ServerBuilder.forPort(9999)
                .addService(new AddServer())
                .build();
        try {
            build.start();
            System.out.println("=====》server started...");
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true){

        }

    }

    @Override
    public void add(AddRequest request, StreamObserver<AddReply> responseObserver) {

        int a = request.getA();
        int b = request.getB();
        int res = myAdd(a,b);
        System.out.printf("请求参数：%d和%d",a,b);
        responseObserver.onNext(AddReply.newBuilder().setRes(res).build());
        responseObserver.onCompleted();

    }

    private int myAdd(int a,int b){
        return a + b;
    }
}
// Path: src/main/java/a/b/c/AddServer.java