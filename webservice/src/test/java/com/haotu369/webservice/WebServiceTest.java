package com.haotu369.webservice;

import com.haotu369.webservice.wsimport.client.WorkFlowService;
import com.haotu369.webservice.wsimport.client.WorkFlowServiceService;
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
        proxyFactoryBean.setServiceClass(com.haotu369.webservice.cxf.client.WorkFlowService.class);
        com.haotu369.webservice.cxf.client.WorkFlowService workFlowService = (com.haotu369.webservice.cxf.client.WorkFlowService) proxyFactoryBean.create();
        workFlowService.execute();
    }
}
