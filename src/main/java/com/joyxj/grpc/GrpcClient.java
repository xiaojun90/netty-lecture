package com.joyxj.grpc;

import com.joyxj.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * @author: xiaojun
 * @version: 2018/12/4
 */
public class GrpcClient {

    private final ManagedChannel channel;

    private final StudentServiceGrpc.StudentServiceBlockingStub blockingStub;

    private final StudentServiceGrpc.StudentServiceStub stub; //异步的请求

    public GrpcClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host,port).usePlaintext().build());

    }

    public GrpcClient(ManagedChannel channel) {
        this.channel = channel;
        this.blockingStub = StudentServiceGrpc.newBlockingStub(channel);
        this.stub = StudentServiceGrpc.newStub(channel);
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
            client.getStudentsByAge(28);
            client.getStudentWrapperByAges();
        } finally {
            client.shutdown();
        }

    }

    public void getRealNameByUserName(String name) {
        MyRequest myRequest = MyRequest.newBuilder().setUsername(name).build();
        MyResponse myResponse = blockingStub.getRealNameByUserName(myRequest);
        System.out.println("服务器端返回信息:" + myResponse.getRealname());
    }

    public void getStudentsByAge(int age) {
        StudentRequest request = StudentRequest.newBuilder().setAge(age).build();
        Iterator<StudentResponse> iterator = blockingStub.getStudentsByAge(request);
        while (iterator.hasNext()) {
            StudentResponse studentResponse = iterator.next();
            System.out.println(studentResponse.getName() + "," + studentResponse.getAge() + "," + studentResponse.getCity());
        }
    }

    public void getStudentWrapperByAges() {
        //接收服务端的数据
        StreamObserver<StudentListResponse> studentListResponseStreamObserver = new StreamObserver<StudentListResponse>() {
            @Override
            public void onNext(StudentListResponse studentListResponse) {
                for(StudentResponse studentResponse: studentListResponse.getStudentResonseList()) {
                    System.out.println(studentResponse.getName());
                    System.out.println(studentResponse.getAge());
                    System.out.println(studentResponse.getCity());
                }
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Completed");
            }
        };

        StreamObserver<StudentRequest> studentRequestStreamObserver = stub.getStudentWrapperByAges(studentListResponseStreamObserver);
        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(25).build());
        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(30).build());
        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(35).build());
        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(40).build());
        studentRequestStreamObserver.onCompleted();

        //下面做一个休眠处理，因为上面的异步的操作，如果不执行sleep，在异步操作没有执行完就关闭了jvm，就不会有返回结果。
       try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
