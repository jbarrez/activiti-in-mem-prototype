package org.activiti.manager;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.persistence.entity.IdentityLinkEntity;
import org.activiti.engine.impl.persistence.entity.IdentityLinkEntityImpl;
import org.activiti.engine.impl.persistence.entity.data.IdentityLinkDataManager;

/**
 * @author Joram Barrez
 */
public class InMemoryIdentityLinkDataManager extends AbstractInMemoryDataManager<IdentityLinkEntity> implements IdentityLinkDataManager {

  public InMemoryIdentityLinkDataManager(ProcessEngineConfigurationImpl processEngineConfiguration) {
    super(processEngineConfiguration);
  }

  public IdentityLinkEntity create() {
    return new IdentityLinkEntityImpl();
  }
  
  public List<IdentityLinkEntity> findIdentityLinksByTaskId(String taskId) {
    List<IdentityLinkEntity> results = new ArrayList<IdentityLinkEntity>();
    for (IdentityLinkEntity identityLinkEntity : entities.values()) {
      if (identityLinkEntity.getTaskId() != null && identityLinkEntity.getTaskId().equals(taskId)) {
        results.add(identityLinkEntity);
      }
    }
    return results;
  }

  public List<IdentityLinkEntity> findIdentityLinksByProcessInstanceId(String processInstanceId) {
    List<IdentityLinkEntity> results = new ArrayList<IdentityLinkEntity>();
    for (IdentityLinkEntity identityLinkEntity : entities.values()) {
      if (identityLinkEntity.getProcessInstanceId() != null && identityLinkEntity.getProcessInstanceId().equals(processInstanceId)) {
        results.add(identityLinkEntity);
      }
    }
    return results;
  }

  public List<IdentityLinkEntity> findIdentityLinksByProcessDefinitionId(String processDefinitionId) {
    throw new UnsupportedOperationException();
  }

  public List<IdentityLinkEntity> findIdentityLinkByTaskUserGroupAndType(String taskId, String userId, String groupId, String type) {
    throw new UnsupportedOperationException();
  }

  public List<IdentityLinkEntity> findIdentityLinkByProcessInstanceUserGroupAndType(String processInstanceId, String userId, String groupId, String type) {
    throw new UnsupportedOperationException();
  }

  public List<IdentityLinkEntity> findIdentityLinkByProcessDefinitionUserAndGroup(String processDefinitionId, String userId, String groupId) {
    throw new UnsupportedOperationException();
  }

  public void deleteIdentityLinksByProcDef(String processDefId) {
    throw new UnsupportedOperationException();    
  }

  

}
