package com.swapnonil.springexp.fixedlengthjob;

import org.springframework.batch.core.listener.SkipListenerSupport;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * This class will only be called after the Step Execution completes.
 * 
 * @author C5028813
 *
 */
public class ProcessorExceptionSkipListener extends SkipListenerSupport<Record, Throwable>
{
	private JdbcTemplate jdbcTemplate;
	private String filterSQL;
	private String jobName;
	private int jobInstanceId;
	private int jobExecutionId;
	private int stepExecutionId;
	private String filename;

	@Override
	public void onSkipInProcess(Record item, Throwable t)
	{
		jdbcTemplate.update(filterSQL, item.getId(), item.getName(), item.getBankAccountId(), jobName, jobInstanceId,
				jobExecutionId, stepExecutionId, filename);
	}

	public JdbcTemplate getJdbcTemplate()
	{
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}

	public String getFilterSQL()
	{
		return filterSQL;
	}

	public void setFilterSQL(String filterSQL)
	{
		this.filterSQL = filterSQL;
	}

	public String getJobName()
	{
		return jobName;
	}

	public void setJobName(String jobName)
	{
		this.jobName = jobName;
	}

	public int getJobInstanceId()
	{
		return jobInstanceId;
	}

	public void setJobInstanceId(int jobInstanceId)
	{
		this.jobInstanceId = jobInstanceId;
	}

	public int getJobExecutionId()
	{
		return jobExecutionId;
	}

	public void setJobExecutionId(int jobExecutionId)
	{
		this.jobExecutionId = jobExecutionId;
	}

	public int getStepExecutionId()
	{
		return stepExecutionId;
	}

	public void setStepExecutionId(int stepExecutionId)
	{
		this.stepExecutionId = stepExecutionId;
	}

	public String getFilename()
	{
		return filename;
	}

	public void setFilename(String filename)
	{
		this.filename = filename;
	}

}
