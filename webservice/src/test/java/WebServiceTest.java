import com.haotu369.client.WorkFlowService;
import com.haotu369.client.WorkFlowServiceService;
import org.junit.Test;

/**
 * @author : Jian Shen
 * @version : V1.0
 * @date : 2018/7/13
 */
public class WebServiceTest {

    @Test
    public void testWebService() {
        WorkFlowServiceService workFlowServiceService = new WorkFlowServiceService();
        WorkFlowService workFlowService = workFlowServiceService.getWorkFlowServicePort();
        workFlowService.execute();
    }
}
