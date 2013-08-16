package com.swapnonil.springexp.fixedlengthjob;

import java.util.Date;

import org.springframework.batch.core.listener.SkipListenerSupport;
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.jdbc.core.JdbcTemplate;

public class ReadingSkippedLoggerListener extends SkipListenerSupport<FlatFileParseException, Record>
{
	private JdbcTemplate jdbcTemplate;
	private String insertSQL;
	private String jobName;
	private int jobInstanceId;
	private int jobExecutionId;
	private int stepExecutionId;
	private String filename;

	@Override
	public void onSkipInRead(Throwable t)
	{
		if (t instanceof FlatFileParseException)
		{
			FlatFileParseException exception = (FlatFileParseException) t;
			String line = exception.getInput();
			jdbcTemplate.update(insertSQL, jobName, jobInstanceId, jobExecutionId, stepExecutionId, line,
					exception.getLineNumber(), filename, new Date());
		}
	}

	public JdbcTemplate getJdbcTemplate()
	{
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}

	public String getInsertSQL()
	{
		return insertSQL;
	}

	public void setInsertSQL(String insertSQL)
	{
		this.insertSQL = insertSQL;
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

	public String getFilename()
	{
		return filename;
	}

	public void setFilename(String filename)
	{
		this.filename = filename;
	}		
}
