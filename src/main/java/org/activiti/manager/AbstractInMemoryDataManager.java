package org.activiti.manager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.db.Entity;
import org.activiti.engine.impl.persistence.AbstractManager;
import org.activiti.engine.impl.persistence.entity.data.DataManager;

public abstract class AbstractInMemoryDataManager<EntityImpl extends Entity> extends AbstractManager implements DataManager<EntityImpl>  {

  public AbstractInMemoryDataManager(ProcessEngineConfigurationImpl processEngineConfiguration) {
    super(processEngineConfiguration);
  }

  protected Map<String, EntityImpl> entities = new ConcurrentHashMap<String, EntityImpl>();
  
  public EntityImpl findById(String entityId) {
    if (entityId == null) {
      return null;
    }
    return entities.get(entityId);
  }

  public void insert(EntityImpl entity) {
    if (entity.getId() == null) {
      entity.setId(getProcessEngineConfiguration().getIdGenerator().getNextId());
    }
    entities.put(entity.getId(), entity);
  }

  public EntityImpl update(EntityImpl entity) {
    throw new UnsupportedOperationException();
  }

  public void delete(String id) {
    entities.remove(id);
  }

  public void delete(EntityImpl entity) {
    delete(entity.getId());
  }
  
  
}
