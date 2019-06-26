package com.example.demo.utils;

import org.activiti.engine.*;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivitiUtils {

    public static ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
    public static Logger log = LoggerFactory.getLogger(ActivitiUtils.class);

    /**
     * 发布流程
     *
     * @param pName    ：流程名称
     * @param fileName ：resource下流程文件名[xxx.bpmn]
     * @return
     */
    public static void deployProcess(String pName, String fileName) {
        RepositoryService repositoryService = processEngine.getRepositoryService();
        DeploymentBuilder builder = repositoryService.createDeployment();
        builder.name(pName);
        builder.addClasspathResource(fileName);
        Deployment deployment = builder.deploy();
        log.debug("Process ID: {}, Process name: {}", deployment.getId(), deployment.getName());
    }

    /**
     * 启动一个流程实例
     *
     * @param pKey      : 流程实例 KEY_
     * @param paramsMap : 参数
     *                  As shown as fallow
     *                  "employeeName", "Eric Lee"
     *                  "numberOfDays", 20
     *                  "vacationMotivation", "The world is so big, I want to see it."
     */
    public static RuntimeService startProccess(String pKey, Map paramsMap) {
        RuntimeService runtimeService = processEngine.getRuntimeService();
        runtimeService.startProcessInstanceByKey(pKey, paramsMap);
        return runtimeService;
    }


    /**
     * Fetch all tasks for the user group specified
     *
     * @param userId
     * @return
     */
    public static List<Task> fetchAllTasks(String userId) {
        TaskService taskService = processEngine.getTaskService();
        return taskService.createTaskQuery().taskAssignee(userId).list();
    }

    /**
     * @param taskId
     * @param variables
     */
    public static void competeTast(String taskId, Map<String, Object> variables) {
        TaskService taskService = processEngine.getTaskService();
        taskService.complete(taskId, variables);
    }

    /**
     * 获取一个结束的流程的历史数据
     *
     * @param pId ： 流程实例ID
     * @return
     */
    public static List<HistoricActivityInstance> fetchAllHisTasks(String pId) {
        return processEngine.getHistoryService().createHistoricActivityInstanceQuery() // 创建历史活动实例查询
                .processInstanceId(pId)
                .finished()
                .list();
    }
}
