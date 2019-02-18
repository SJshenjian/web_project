package online.shenjian.webservice;

import online.shenjian.webservice.wsimport.client.WorkFlowService;
import online.shenjian.webservice.wsimport.client.WorkFlowServiceService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;

/**
 * @author : Jian Shen
 * @version : V1.0
 * @date : 2018/7/13
 */
public class WebServiceTest {

    @Test
    public void testWebServiceByWSImport() {
        WorkFlowServiceService workFlowServiceService = new WorkFlowServiceService();
        WorkFlowService workFlowService = workFlowServiceService.getWorkFlowServicePort();
        workFlowService.execute();
    }

    @Test
    public void testWebServiceByCXF() {
        String address = "http://127.0.0.1:9082/cxf/service/workflow";
        JaxWsProxyFactoryBean proxyFactoryBean = new JaxWsProxyFactoryBean();
        proxyFactoryBean.setAddress(address);
        proxyFactoryBean.setServiceClass(online.shenjian.webservice.cxf.client.WorkFlowService.class);
        online.shenjian.webservice.cxf.client.WorkFlowService workFlowService = (online.shenjian.webservice.cxf.client.WorkFlowService) proxyFactoryBean.create();
        workFlowService.execute();
    }
}
