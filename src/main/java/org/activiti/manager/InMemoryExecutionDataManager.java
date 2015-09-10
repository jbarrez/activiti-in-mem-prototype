package org.activiti.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.activiti.engine.impl.ExecutionQueryImpl;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.ProcessInstanceQueryImpl;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ExecutionEntityImpl;
import org.activiti.engine.impl.persistence.entity.data.ExecutionDataManager;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * @author Joram Barrez
 */
public class InMemoryExecutionDataManager extends AbstractInMemoryDataManager<ExecutionEntity> implements ExecutionDataManager {
  
  public InMemoryExecutionDataManager(ProcessEngineConfigurationImpl processEngineConfiguration) {
    super(processEngineConfiguration);
  }

  public ExecutionEntity create() {
    return new ExecutionEntityImpl();
  }
  
  public ExecutionEntity findSubProcessInstanceBySuperExecutionId(String superExecutionId) {
    for (ExecutionEntity executionEntity : entities.values()) {
      if (executionEntity.getSuperExecutionId() != null && executionEntity.getSuperExecutionId().equals(superExecutionId)) {
        return executionEntity;
      }
    }
    return null;
  }

  public List<ExecutionEntity> findChildExecutionsByParentExecutionId(String parentExecutionId) {
    List<ExecutionEntity> results = new ArrayList<ExecutionEntity>();
    for (ExecutionEntity executionEntity : entities.values()) {
      if (executionEntity.getParentId() != null && executionEntity.getParentId().equals(parentExecutionId)) {
        results.add(executionEntity);
      }
    }
    return results;
  }

  public List<ExecutionEntity> findChildExecutionsByProcessInstanceId(String processInstanceId) {
    List<ExecutionEntity> results = new ArrayList<ExecutionEntity>();
    for (ExecutionEntity executionEntity : entities.values()) {
      if (executionEntity.getProcessInstanceId() != null && executionEntity.getProcessInstanceId().equals(processInstanceId)
          && !executionEntity.getProcessInstanceId().equals(executionEntity.getId())) {
        results.add(executionEntity);
      }
    }
    return results;
  }

  public List<ExecutionEntity> findExecutionsByParentExecutionAndActivityIds(String parentExecutionId, Collection<String> activityIds) {
    throw new UnsupportedOperationException();
  }

  public long findExecutionCountByQueryCriteria(ExecutionQueryImpl executionQuery) {
    throw new UnsupportedOperationException();
  }

  public List<ExecutionEntity> findExecutionsByQueryCriteria(ExecutionQueryImpl executionQuery, Page page) {
    throw new UnsupportedOperationException();
  }

  public long findProcessInstanceCountByQueryCriteria(ProcessInstanceQueryImpl executionQuery) {
    throw new UnsupportedOperationException();
  }

  public List<ProcessInstance> findProcessInstanceByQueryCriteria(ProcessInstanceQueryImpl executionQuery) {
    throw new UnsupportedOperationException();
  }

  public List<ExecutionEntity> findExecutionsByRootProcessInstanceId(String rootProcessInstanceId) {
    List<ExecutionEntity> results = new ArrayList<ExecutionEntity>();
    for (ExecutionEntity executionEntity : entities.values()) {
      if (executionEntity.getRootProcessInstanceId() != null && executionEntity.getRootProcessInstanceId().equals(rootProcessInstanceId)) {
        results.add(executionEntity);
      }
    }
    return results;
  }

  public List<ExecutionEntity> findExecutionsByProcessInstanceId(String processInstanceId) {
    throw new UnsupportedOperationException();
  }

  public List<ProcessInstance> findProcessInstanceAndVariablesByQueryCriteria(ProcessInstanceQueryImpl executionQuery) {
    throw new UnsupportedOperationException();
  }

  public List<ExecutionEntity> findEventScopeExecutionsByActivityId(String activityRef, String parentExecutionId) {
    throw new UnsupportedOperationException();
  }

  public Collection<ExecutionEntity> findInactiveExecutionsByActivityId(String activityId) {
    throw new UnsupportedOperationException();
  }

  public Collection<ExecutionEntity> findInactiveExecutionsByProcessInstanceId(String processInstanceId) {
    throw new UnsupportedOperationException();
  }

  public Collection<ExecutionEntity> findInactiveExecutionsByActivityIdAndProcessInstanceId(String activityId, String processInstanceId) {
    throw new UnsupportedOperationException();
  }

  public List<String> findProcessInstanceIdsByProcessDefinitionId(String processDefinitionId) {
    throw new UnsupportedOperationException();
  }

  public List<Execution> findExecutionsByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
    throw new UnsupportedOperationException();
  }

  public List<ProcessInstance> findProcessInstanceByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
    throw new UnsupportedOperationException();
  }

  public long findExecutionCountByNativeQuery(Map<String, Object> parameterMap) {
    throw new UnsupportedOperationException();
  }

  public void updateExecutionTenantIdForDeployment(String deploymentId, String newTenantId) {
    throw new UnsupportedOperationException();    
  }

  public void updateProcessInstanceLockTime(String processInstanceId, Date lockDate, Date expirationTime) {
    throw new UnsupportedOperationException();    
  }

  public void clearProcessInstanceLockTime(String processInstanceId) {
    throw new UnsupportedOperationException();
  }

  

}
