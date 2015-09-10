package org.activiti.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.activiti.engine.impl.JobQueryImpl;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.persistence.entity.JobEntity;
import org.activiti.engine.impl.persistence.entity.MessageEntity;
import org.activiti.engine.impl.persistence.entity.MessageEntityImpl;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.persistence.entity.TimerEntity;
import org.activiti.engine.impl.persistence.entity.TimerEntityImpl;
import org.activiti.engine.impl.persistence.entity.data.JobDataManager;
import org.activiti.engine.runtime.Job;

/**
 * @author Joram Barrez
 */
public class InMemoryJobDataManager extends AbstractInMemoryDataManager<JobEntity> implements JobDataManager {

  public InMemoryJobDataManager(ProcessEngineConfigurationImpl processEngineConfiguration) {
    super(processEngineConfiguration);
  }

  public MessageEntity createMessage() {
    return new MessageEntityImpl();
  }
  
  public TimerEntity createTimer() {
    return new TimerEntityImpl();
  }
  
  public JobEntity create() {
    // Superclass cannot be created
    throw new UnsupportedOperationException();
  }
  
  public List<JobEntity> findNextJobsToExecute(Page page) {
    throw new UnsupportedOperationException();
  }

  public List<JobEntity> findNextTimerJobsToExecute(Page page) {
    throw new UnsupportedOperationException();
  }

  public List<JobEntity> findAsyncJobsDueToExecute(Page page) {
    throw new UnsupportedOperationException();
  }

  public List<JobEntity> findJobsByLockOwner(String lockOwner, int start, int maxNrOfJobs) {
    throw new UnsupportedOperationException();
  }

  public List<JobEntity> findJobsByExecutionId(String executionId) {
    List<JobEntity> results = new ArrayList<JobEntity>();
    for (JobEntity jobEntity : entities.values()) {
      if (jobEntity.getExecutionId() != null && jobEntity.getExecutionId().equals(executionId)) {
        results.add(jobEntity);
      }
    }
    return results;
  }

  public List<JobEntity> findExclusiveJobsToExecute(String processInstanceId) {
    throw new UnsupportedOperationException();
  }

  public List<TimerEntity> findUnlockedTimersByDuedate(Date duedate, Page page) {
    throw new UnsupportedOperationException();
  }

  public List<TimerEntity> findTimersByExecutionId(String executionId) {
    throw new UnsupportedOperationException();
  }

  public List<Job> findJobsByQueryCriteria(JobQueryImpl jobQuery, Page page) {
    throw new UnsupportedOperationException();
  }

  public List<Job> findJobsByTypeAndProcessDefinitionIds(String jobHandlerType, List<String> processDefinitionIds) {
    throw new UnsupportedOperationException();
  }

  public List<Job> findJobsByTypeAndProcessDefinitionKeyNoTenantId(String jobHandlerType, String processDefinitionKey) {

    ProcessDefinitionEntity processDefinitionEntity = getProcessDefinitionEntityManager().findLatestProcessDefinitionByKey(processDefinitionKey);
    
    List<Job> results = new ArrayList<Job>();
    for (JobEntity jobEntity : entities.values()) {
      if (jobHandlerType.equals(jobEntity.getJobHandlerType()) 
          && processDefinitionEntity.getId().equals(jobEntity.getProcessDefinitionId())
          && jobEntity.getTenantId() == null) {
        results.add(jobEntity);
      }
    }
    return results;
  }

  public List<Job> findJobsByTypeAndProcessDefinitionKeyAndTenantId(String jobHandlerType, String processDefinitionKey, String tenantId) {
    throw new UnsupportedOperationException();
  }

  public List<Job> findJobsByTypeAndProcessDefinitionId(String jobHandlerType, String processDefinitionId) {
    throw new UnsupportedOperationException();
  }

  public long findJobCountByQueryCriteria(JobQueryImpl jobQuery) {
    throw new UnsupportedOperationException();
  }

  public void updateJobTenantIdForDeployment(String deploymentId, String newTenantId) {
    throw new UnsupportedOperationException();
  }

}
