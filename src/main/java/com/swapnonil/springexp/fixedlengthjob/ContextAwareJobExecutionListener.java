package com.swapnonil.springexp.fixedlengthjob;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class ContextAwareJobExecutionListener implements JobExecutionListener
{
	public void beforeJob(JobExecution jobExecution)
	{
		String jobName = jobExecution.getJobInstance().getJobName();		
		Long jobInstanceId = jobExecution.getJobInstance().getId().longValue();
		Long jobExecutionId = jobExecution.getId().longValue();
		
		jobExecution.getExecutionContext().put("jobName", jobName);
		jobExecution.getExecutionContext().put("jobInstanceId", jobInstanceId);		
		jobExecution.getExecutionContext().put("jobExecutionId", jobExecutionId);		
	}

	public void afterJob(JobExecution jobExecution)
	{
	}
}
