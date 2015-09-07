package org.activiti.manager;

import java.util.List;
import java.util.Map;

import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.HistoricTaskInstanceQueryImpl;
import org.activiti.engine.impl.persistence.entity.HistoricTaskInstanceEntity;
import org.activiti.engine.impl.persistence.entity.data.HistoricTaskInstanceDataManager;

/**
 * @author Joram Barrez
 */
public class InMemoryHistoricTaskInstanceDataManager extends AbstractInMemoryDataManager<HistoricTaskInstanceEntity> implements HistoricTaskInstanceDataManager {

  public List<HistoricTaskInstanceEntity> findHistoricTaskInstanceByProcessInstanceId(String processInstanceId) {
    throw new UnsupportedOperationException();
  }

  public long findHistoricTaskInstanceCountByQueryCriteria(HistoricTaskInstanceQueryImpl historicTaskInstanceQuery) {
    throw new UnsupportedOperationException();
  }

  public List<HistoricTaskInstance> findHistoricTaskInstancesByQueryCriteria(HistoricTaskInstanceQueryImpl historicTaskInstanceQuery) {
    throw new UnsupportedOperationException();
  }

  public List<HistoricTaskInstance> findHistoricTaskInstancesAndVariablesByQueryCriteria(HistoricTaskInstanceQueryImpl historicTaskInstanceQuery) {
    throw new UnsupportedOperationException();
  }

  public List<HistoricTaskInstance> findHistoricTaskInstancesByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
    throw new UnsupportedOperationException();
  }

  public long findHistoricTaskInstanceCountByNativeQuery(Map<String, Object> parameterMap) {
    throw new UnsupportedOperationException();
  }

}
