package org.activiti.transaction;

import org.activiti.engine.impl.cfg.TransactionContext;
import org.activiti.engine.impl.cfg.TransactionContextFactory;
import org.activiti.engine.impl.interceptor.CommandContext;

/**
 * @author Joram Barrez
 */
public class NoopTransactionContextFactory implements TransactionContextFactory {
  
  public TransactionContext openTransactionContext(CommandContext commandContext) {
    return new NoopTransactionContext();
  }

}
