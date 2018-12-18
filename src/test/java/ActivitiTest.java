import com.example.demo.task.SendEmail;
import com.example.demo.utils.ActivitiUtils;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivitiTest {

    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
    private static final Log logger = LogFactory.getLog(ActivitiTest.class);


    /**
     * 初始化数据库
     */
    @Test
    public void testCreateProcessEngineByCfgXml() {
        ProcessEngineConfiguration pec = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        pec.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);// 创建数据库规则：如果表结构存在则更新
    }

    /**
     * 发布流程
     * RepositoryService
     * 测试的话，如果找不到bpmn文件，请将文件放到test/resources下面
     */
    @Test
    public void deployProcess() {
        ActivitiUtils.deployProcess("vocation", "leave.bpmn");
    }

    /**
     * 启动流程
     * RuntimeService
     */
    @Test
    public void startProcess() {
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("employeeName", "Eric Lee");// 申请人
        variables.put("manager", "boss");// 处理人姓名
        variables.put("numberOfDays", new Integer(12));
        variables.put("vacationMotivation", "The world is so big, I want to see it too.");

        RuntimeService runtimeService = ActivitiUtils.startProccess("vacationRequest", variables);
        logger.debug("Number of process instances: " + runtimeService.createProcessInstanceQuery().count());
    }

    /**
     * 审批同意流程
     */
    @Test
    public void approvedProcess() {
        Map<String, Object> taskVariables = new HashMap<String, Object>();
        taskVariables.put("boss", "boos");
        taskVariables.put("vacationApproved", "true");
        ActivitiUtils.competeTast("5009", taskVariables);
    }

    /**
     * 重新发起流程
     */
    @Test
    public void restartProcess() {
        Map<String, Object> taskVariables = new HashMap<String, Object>();
        taskVariables.put("employeeName", "Bruce");// 申请人
        taskVariables.put("manager", "boss");
        taskVariables.put("numberOfDays", new Integer(10));
        taskVariables.put("vacationMotivation", "The world is so big, I want to see it.");
        taskVariables.put("resendRequest", "true");
        ActivitiUtils.competeTast("10005", taskVariables);
    }

    /**
     * 拒绝流程
     */
    @Test
    public void refuseProcess() {
        Map<String, Object> taskVariables = new HashMap<String, Object>();
        taskVariables.put("vacationApproved", "false");
        ActivitiUtils.competeTast("12504", taskVariables);
    }

    /**
     *
     *  查询历史任务
     *
     */
    @Test
    public void queryTask() {
        List<HistoricActivityInstance> list = ActivitiUtils.fetchAllHisTasks("5001");
        for (HistoricActivityInstance instance : list) {
            logger.debug("活动ID[" + instance.getId() + "]," +
                    "流程实例ID[" + instance.getProcessInstanceId() + "]," +
                    "活动名称[" + instance.getActivityName() + "]," +
                    "办理人[" + instance.getAssignee() + "],");
        }
    }

    /**
     * 办理任务
     */
    @Test
    public void handleTask() {
        String taskId = "17509";
        Map<String, Object> taskVariables = new HashMap<String, Object>();
        taskVariables.put("62506", "New Bee");
        taskVariables.put("resendRequest", "true");
        ActivitiUtils.competeTast(taskId, taskVariables);
    }

    /**
     * 挂起流程
     */
    @Test
    public void suspendProcess() {

    }
}
