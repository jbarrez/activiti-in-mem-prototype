package org.activiti;

import java.util.HashMap;

import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.interceptor.CommandInterceptor;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.activiti.engine.impl.persistence.GenericManagerFactory;
import org.activiti.engine.impl.persistence.StrongUuidGenerator;
import org.activiti.engine.impl.persistence.cache.EntityCache;
import org.activiti.engine.impl.persistence.cache.EntityCacheImpl;
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
    
    this.validateSchemaOnBoot = false;
    
    this.idGenerator = new StrongUuidGenerator();
    
    this.databaseSchemaUpdate = null; // Setting it to null avoid the on-boot check for schema
    this.jdbcDriver = null;
    this.jdbcUrl = null;
    this.jdbcUsername = null;
    this.jdbcPassword = null;
    this.dataSource = null;
  }

  @Override
  protected CommandInterceptor createTransactionInterceptor() {
    return null;
  }
  
  @Override
  public void initDatabaseType() {
  }
  
  @Override
  protected void initSqlSessionFactory() {
  }
  
  @Override
  protected void initTransactionContextFactory() {
    if (transactionContextFactory == null) {
      transactionContextFactory = new NoopTransactionContextFactory();
    }
  }
  
  protected void initSessionFactories() {
    if (sessionFactories == null) {
      
      sessionFactories = new HashMap<Class<?>, SessionFactory>();
      
      // remove dbsqlsession
      
      addSessionFactory(new GenericManagerFactory(EntityCache.class, EntityCacheImpl.class));
    }

    if (customSessionFactories != null) {
      for (SessionFactory sessionFactory : customSessionFactories) {
        addSessionFactory(sessionFactory);
      }
    }
  }
  
  @Override
  protected void initDataManagers() {
    
    this.deploymentDataManager = new InMemoryDeploymentDataManager();
    this.resourceDataManager = new InMemoryResourceDataManager();
    this.processDefinitionDataManager = new InMemoryProcessDefinitionDataManager();
    this.jobDataManager = new InMemoryJobDataManager();
    this.executionDataManager = new InMemoryExecutionDataManager();
    this.historicProcessInstanceDataManager = new InMemoryHistoricProcessInstanceDataManager();
    this.historicActivityInstanceDataManager = new InMemoryHistoricActivityInstanceDataManager();
    this.taskDataManager = new InMemoryTaskDataManager();
    this.historicTaskInstanceDataManager = new InMemoryHistoricTaskInstanceDataManager();
    this.identityLinkDataManager = new InMemoryIdentityLinkDataManager();
    this.variableInstanceDataManager = new InMemoryVariableInstanceDataManager();
    this.eventSubscriptionDataManager = new InMemoryEventSubscriptionDataManager();
    
  }

}
