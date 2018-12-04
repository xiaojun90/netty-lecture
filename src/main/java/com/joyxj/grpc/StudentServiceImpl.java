package com.joyxj.grpc;

import com.joyxj.proto.MyRequest;
import com.joyxj.proto.MyResponse;
import com.joyxj.proto.StudentServiceGrpc;
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
}
