package org.activiti;

import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.interceptor.CommandInterceptor;
import org.activiti.engine.impl.persistence.StrongUuidGenerator;
import org.activiti.manager.InMemoryDeploymentDataManager;
import org.activiti.manager.InMemoryEventSubscriptionDataManager;
import org.activiti.manager.InMemoryExecutionDataManager;
import org.activiti.manager.InMemoryHistoricActivityInstanceDataManager;
import org.activiti.manager.InMemoryHistoricProcessInstanceDataManager;
import org.activiti.manager.InMemoryHistoricTaskInstanceDataManager;
import org.activiti.manager.InMemoryIdentityLinkDataManager;
import org.activiti.manager.InMemoryJobDataManager;
import org.activiti.manager.InMemoryProcessDefinitionDataManager;
import org.activiti.manager.InMemoryResourceDataManager;
import org.activiti.manager.InMemoryTaskDataManager;
import org.activiti.manager.InMemoryVariableInstanceDataManager;
import org.activiti.transaction.NoopTransactionContextFactory;

public class InMemoryProcessEngineConfiguration extends ProcessEngineConfigurationImpl {
  
  public InMemoryProcessEngineConfiguration() {
    this.usingRelationalDatabase = false;
    this.idGenerator = new StrongUuidGenerator();
  }

  @Override
  protected CommandInterceptor createTransactionInterceptor() {
    return null;
  }
  
  @Override
  protected void initTransactionContextFactory() {
    if (transactionContextFactory == null) {
      transactionContextFactory = new NoopTransactionContextFactory();
    }
  }
  
  @Override
  protected void initDataManagers() {
    
    this.deploymentDataManager = new InMemoryDeploymentDataManager(this);
    this.resourceDataManager = new InMemoryResourceDataManager(this);
    this.processDefinitionDataManager = new InMemoryProcessDefinitionDataManager(this);
    this.jobDataManager = new InMemoryJobDataManager(this);
    this.executionDataManager = new InMemoryExecutionDataManager(this);
    this.historicProcessInstanceDataManager = new InMemoryHistoricProcessInstanceDataManager(this);
    this.historicActivityInstanceDataManager = new InMemoryHistoricActivityInstanceDataManager(this);
    this.taskDataManager = new InMemoryTaskDataManager(this);
    this.historicTaskInstanceDataManager = new InMemoryHistoricTaskInstanceDataManager(this);
    this.identityLinkDataManager = new InMemoryIdentityLinkDataManager(this);
    this.variableInstanceDataManager = new InMemoryVariableInstanceDataManager(this);
    this.eventSubscriptionDataManager = new InMemoryEventSubscriptionDataManager(this);
    
  }

}
