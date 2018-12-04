package com.joyxj.grpc;

import com.joyxj.proto.*;
import io.grpc.stub.StreamObserver;

/**
 * Student Service实现类
 * @author: xiaojun
 * @version: 2018/12/4
 */
public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {

    @Override
    public void getRealNameByUserName(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        System.out.println("客户端请求信息:" + request.getUsername());
        //返回信息
        MyResponse myResponse = MyResponse.newBuilder().setRealname("张三").build();
        responseObserver.onNext(myResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void getStudentsByAge(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {

        System.out.println("客户端请求信息:" + request.getAge());
        responseObserver.onNext(StudentResponse.newBuilder().setName("张三").setAge(25).setCity("深圳").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("李四").setAge(35).setCity("广州").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("王五").setAge(20).setCity("上海").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("刘麻子").setAge(25).setCity("北京").build());
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<StudentRequest> getStudentWrapperByAges(StreamObserver<StudentListResponse> responseObserver) {

        return new StreamObserver<StudentRequest>() {
            @Override
            public void onNext(StudentRequest studentRequest) {
                //客户端每发次一个流式数据就会执行一次onNext方法
                System.out.println("onNext value:" + studentRequest.getAge());
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("error");
            }

            @Override
            public void onCompleted() {
                //客户端以流式的方式把数据全部发送完之后，就会执行onCompleted方法
                StudentResponse response1 = StudentResponse.newBuilder().setName("张三").setAge(25).setCity("深圳").build();
                StudentResponse response2 = StudentResponse.newBuilder().setName("李四").setAge(35).setCity("广州").build();
                StudentResponse response3 = StudentResponse.newBuilder().setName("王五").setAge(20).setCity("上海").build();
                StudentResponse response4 = StudentResponse.newBuilder().setName("刘麻子").setAge(25).setCity("北京").build();
                StudentListResponse studentListResponse = StudentListResponse.newBuilder()
                        .addStudentResonse(response1)
                        .addStudentResonse(response2)
                        .addStudentResonse(response3)
                        .addStudentResonse(response4)
                        .build();
                responseObserver.onNext(studentListResponse);
                responseObserver.onCompleted();
            }
        };
    }
}
