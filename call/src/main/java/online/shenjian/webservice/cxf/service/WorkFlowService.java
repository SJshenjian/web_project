package online.shenjian.webservice.cxf.service;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author : Jian Shen
 * @version : V1.0
 * @date : 2018/10/20
 */
@WebService
public class WorkFlowService {

    @WebMethod
    public void execute() {
        System.out.println("执行流程中心");
    }

    public static void main(String[] args) {
        JaxWsServerFactoryBean serverFactoryBean = new JaxWsServerFactoryBean();
        serverFactoryBean.setAddress("http://127.0.0.1:9082/cxf/service/workflow");
        serverFactoryBean.setServiceClass(WorkFlowService.class);
        serverFactoryBean.setServiceBean(new WorkFlowService());
        Server server = serverFactoryBean.create();
        if (server.isStarted()) {
            System.out.println("webservice 发布成功");
        }
    }
}
