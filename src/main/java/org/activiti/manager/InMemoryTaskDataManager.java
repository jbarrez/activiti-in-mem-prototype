package org.activiti.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.activiti.engine.impl.TaskQueryImpl;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntityImpl;
import org.activiti.engine.impl.persistence.entity.data.TaskDataManager;
import org.activiti.engine.task.Task;

/**
 * @author Joram Barrez
 */
public class InMemoryTaskDataManager extends AbstractInMemoryDataManager<TaskEntity> implements TaskDataManager {

  public InMemoryTaskDataManager(ProcessEngineConfigurationImpl processEngineConfiguration) {
    super(processEngineConfiguration);
  }

  public TaskEntity create() {
    return new TaskEntityImpl();
  }
  
  public TaskEntity findById(String taskId, boolean checkCache) {
    return findById(taskId);
  }
  
  public List<TaskEntity> findTasksByExecutionId(String executionId) {
    List<TaskEntity> results = new ArrayList<TaskEntity>();
    for (TaskEntity taskEntity : entities.values()) {
      if (taskEntity.getExecutionId() != null && taskEntity.getExecutionId().equals(executionId)) {
        results.add(taskEntity);
      }
    }
    return results;
  }

  public List<TaskEntity> findTasksByProcessInstanceId(String processInstanceId) {
    throw new UnsupportedOperationException();
  }

  public List<Task> findTasksByQueryCriteria(TaskQueryImpl taskQuery) {
    List<Task> results = new ArrayList<Task>();
    for (TaskEntity taskEntity : entities.values()) {
      
      boolean addTask = true;
      
      if (taskQuery.getName() != null
          && !taskQuery.getName().equals(taskEntity.getName())) {
        addTask = false;
      }
      
      if (taskQuery.getProcessInstanceId() != null
          && !taskQuery.getProcessInstanceId().equals(taskEntity.getProcessInstanceId())) {
        addTask = false;
      }
      
      if (addTask) {
        results.add(taskEntity);
      }
      
    }
    return results;
  }

  public List<Task> findTasksAndVariablesByQueryCriteria(TaskQueryImpl taskQuery) {
    throw new UnsupportedOperationException();
  }

  public long findTaskCountByQueryCriteria(TaskQueryImpl taskQuery) {
    throw new UnsupportedOperationException();
  }

  public List<Task> findTasksByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
    throw new UnsupportedOperationException();
  }

  public long findTaskCountByNativeQuery(Map<String, Object> parameterMap) {
    throw new UnsupportedOperationException();
  }

  public List<Task> findTasksByParentTaskId(String parentTaskId) {
    List<Task> results = new ArrayList<Task>();
    for (TaskEntity taskEntity : entities.values()) {
      if (taskEntity.getParentTaskId() != null && taskEntity.getParentTaskId().equals(parentTaskId)) {
        results.add(taskEntity);
      }
    }
    return results;
  }

  public void updateTaskTenantIdForDeployment(String deploymentId, String newTenantId) {
    throw new UnsupportedOperationException();
  }
  
}
