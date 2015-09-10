package org.activiti.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.ProcessDefinitionQueryImpl;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntityImpl;
import org.activiti.engine.impl.persistence.entity.data.ProcessDefinitionDataManager;
import org.activiti.engine.repository.ProcessDefinition;

/**
 * @author Joram Barrez
 */
public class InMemoryProcessDefinitionDataManager extends AbstractInMemoryDataManager<ProcessDefinitionEntity> implements ProcessDefinitionDataManager {

  protected Map<String, List<ProcessDefinitionEntity>> processDefinitionsByKeyMap = new ConcurrentHashMap<String, List<ProcessDefinitionEntity>>();
  
  public ProcessDefinitionEntity create() {
    return new ProcessDefinitionEntityImpl();
  }
  
  @Override
  public void insert(ProcessDefinitionEntity entity) {
    super.insert(entity); 
    
    // TODO: the delete also needs to keep this in sync
    String key = entity.getKey();
    if (key != null) {
      if (!processDefinitionsByKeyMap.containsKey(key)) {
        processDefinitionsByKeyMap.put(key, new ArrayList<ProcessDefinitionEntity>());
      }
      processDefinitionsByKeyMap.get(key).add(entity);
    }
  }
  
  public ProcessDefinitionEntity findLatestProcessDefinitionByKey(String processDefinitionKey) {
    ProcessDefinitionEntity result = null;
    if (processDefinitionsByKeyMap.containsKey(processDefinitionKey)) {
      for (ProcessDefinitionEntity processDefinitionEntity : processDefinitionsByKeyMap.get(processDefinitionKey)) {
        if (result == null || result.getVersion() < processDefinitionEntity.getVersion()) {
          result = processDefinitionEntity;
        }
      }
    }
    return result;
  }

  public ProcessDefinitionEntity findLatestProcessDefinitionByKeyAndTenantId(String processDefinitionKey, String tenantId) {
    throw new UnsupportedOperationException();
  }

  public void deleteProcessDefinitionsByDeploymentId(String deploymentId) {
    throw new UnsupportedOperationException();
  }

  public List<ProcessDefinition> findProcessDefinitionsByQueryCriteria(ProcessDefinitionQueryImpl processDefinitionQuery, Page page) {
    throw new UnsupportedOperationException();
  }

  public long findProcessDefinitionCountByQueryCriteria(ProcessDefinitionQueryImpl processDefinitionQuery) {
    throw new UnsupportedOperationException();
  }

  public ProcessDefinitionEntity findProcessDefinitionByDeploymentAndKey(String deploymentId, String processDefinitionKey) {
    throw new UnsupportedOperationException();
  }

  public ProcessDefinitionEntity findProcessDefinitionByDeploymentAndKeyAndTenantId(String deploymentId, String processDefinitionKey, String tenantId) {
    throw new UnsupportedOperationException();
  }

  public ProcessDefinitionEntity findProcessDefinitionByKeyAndVersion(String processDefinitionKey, Integer processDefinitionVersion) {
    throw new UnsupportedOperationException();
  }

  public ProcessDefinitionEntity findProcessDefinitionByKeyAndVersionAndTenantId(String processDefinitionKey, Integer processDefinitionVersion, String tenantId) {
    throw new UnsupportedOperationException();
  }

  public List<ProcessDefinition> findProcessDefinitionsByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
    throw new UnsupportedOperationException();
  }

  public long findProcessDefinitionCountByNativeQuery(Map<String, Object> parameterMap) {
    throw new UnsupportedOperationException();
  }

  public void updateProcessDefinitionTenantIdForDeployment(String deploymentId, String newTenantId) {
    throw new UnsupportedOperationException();    
  }



}
