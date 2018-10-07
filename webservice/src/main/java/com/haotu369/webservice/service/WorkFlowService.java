package com.haotu369.webservice.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * @author : Jian Shen
 * @version : V1.0
 * @date : 2018/7/12
 */
@WebService
public class WorkFlowService {

    @WebMethod
    public void execute() {
        System.out.println("执行流程中心");
    }

    public static void main(String[] args) {
        Endpoint endpoint = Endpoint.publish("http://127.0.0.1:9081/service/workflow", new WorkFlowService());
        if (endpoint.isPublished()) {
            System.out.println("webservice 发布成功");
        }
    }
}
