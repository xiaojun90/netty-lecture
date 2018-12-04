package com.joyxj.grpc;

import com.joyxj.proto.MyRequest;
import com.joyxj.proto.MyResponse;
import com.joyxj.proto.StudentServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author: xiaojun
 * @version: 2018/12/4
 */
public class GrpcClient {

    private final ManagedChannel channel;

    private final StudentServiceGrpc.StudentServiceBlockingStub blockingStub;

    public GrpcClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host,port).usePlaintext().build());

    }

    public GrpcClient(ManagedChannel channel) {
        this.channel = channel;
        this.blockingStub = StudentServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        if (null != channel) {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始连接服务器...");
        long startTime = System.currentTimeMillis();
        GrpcClient client = new GrpcClient("localhost",50051);
        System.out.println("连接成功,花费" + (System.currentTimeMillis() - startTime));
        try {
            client.getRealNameByUserName("zhangsan");
        } finally {
            client.shutdown();
        }

    }

    public void getRealNameByUserName(String name) {
        MyRequest myRequest = MyRequest.newBuilder().setUsername(name).build();
        MyResponse myResponse = blockingStub.getRealNameByUserName(myRequest);
        System.out.println("服务器端返回信息:" + myResponse.getRealname());

    }
}
