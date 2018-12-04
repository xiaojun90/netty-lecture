package com.joyxj.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * GRPC服务端
 * @author: xiaojun
 * @version: 2018/12/4
 */
public class GrpcServer {

    private Server server;

    private void start() throws IOException {
        int port = 50051;
        server = ServerBuilder.forPort(port).addService(new StudentServiceImpl())
                .build().start();
        System.out.println("server started,listen port is " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                GrpcServer.this.stop();
                System.out.println("*** server shut down");
            }
        });

    }

    private void blockUntilShutdown() throws InterruptedException {
        if (null != server) {
            server.awaitTermination(); //等待中止
        }
    }

    private void stop() {
        if (null != null) {
            server.shutdown();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        GrpcServer grpcServer = new GrpcServer();
        grpcServer.start();
        grpcServer.blockUntilShutdown(); //让server服务一直开启，不关闭
    }
}
