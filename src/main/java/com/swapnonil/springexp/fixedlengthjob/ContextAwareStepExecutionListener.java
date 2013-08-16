package com.swapnonil.springexp.fixedlengthjob;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class ContextAwareStepExecutionListener implements StepExecutionListener
{

	public void beforeStep(StepExecution stepExecution)
	{
		stepExecution.getExecutionContext().put("stepExecutionId", stepExecution.getId());
	}

	public ExitStatus afterStep(StepExecution stepExecution)
	{
		return null;
	}

}
