package org.activiti.manager;

import java.util.List;

import org.activiti.engine.impl.persistence.entity.ResourceEntity;
import org.activiti.engine.impl.persistence.entity.ResourceEntityImpl;
import org.activiti.engine.impl.persistence.entity.data.ResourceDataManager;

/**
 * @author Joram Barrez
 */
public class InMemoryResourceDataManager extends AbstractInMemoryDataManager<ResourceEntity> implements ResourceDataManager {

  public ResourceEntity create() {
    return new ResourceEntityImpl();
  }
  
  public void deleteResourcesByDeploymentId(String deploymentId) {
    throw new UnsupportedOperationException();
  }

  public ResourceEntity findResourceByDeploymentIdAndResourceName(String deploymentId, String resourceName) {
    throw new UnsupportedOperationException();
  }

  public List<ResourceEntity> findResourcesByDeploymentId(String deploymentId) {
    throw new UnsupportedOperationException();
  }


}
