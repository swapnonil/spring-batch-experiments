package com.swapnonil.springexp.fixedlengthjob;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.jdbc.core.JdbcTemplate;

public class FilteringItemProcessor implements ItemProcessor<Record, Record>
{

	private JdbcTemplate jdbcTemplate;
	private String filterSQL;
	private String jobName;
	private int jobInstanceId;
	private int jobExecutionId;
	private int stepExecutionId;
	private String filename;

	/**
	 * To filter out a reord from being written out by the ItemWriter, simply
	 * return a null from this method. IF however an exception is thrown, then
	 * Spring Batch resubmits the entire chunk again to this processor, except
	 * for the record for which the exception was thrown.
	 * 
	 * Filter is the best way to identify and filter out those records that are
	 * not faulty but still should not be written out through the item writer.
	 * During the processing phase faulty records should be verified using
	 * Validators. Validators will then throw Validation Exceptions which will
	 * be used by skip listners to write out the faulty record.
	 */
	public Record process(Record item) throws Exception
	{
		// accept only those record where the id is an odd number
		if ((item.getId() % 2) == 0)
		{
			// you may want other records to be pushed other records to an error
			// log, from where they can be taken up for further processing
			jdbcTemplate.update(filterSQL, item.getId(), item.getName(), item.getBankAccountId(), jobName,
					jobInstanceId, jobExecutionId, stepExecutionId, filename);			
		}
		else
		{
			return item;
		}
		return null;
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
