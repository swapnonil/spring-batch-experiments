package com.swapnonil.springexp;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionBatchJobLauncher
{
	public static void main(String[] args)
	{
		String[] config =
		{ "transaction-batch-job.xml" };

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
		JobLauncher jobLauncher = (JobLauncher) applicationContext.getBean("jobLauncher");
		Job job = (Job) applicationContext.getBean("transaction-batch-job");

		try
		{
			long t1 = System.currentTimeMillis();
			// Launch a job with timestamp so that it can be started multiple
			// times
			JobExecution execution = jobLauncher.run(job,
					new JobParametersBuilder().addLong("timestamp", System.currentTimeMillis()).toJobParameters());
			System.out.println("Exit Status : " + execution.getStatus());
			long t2 = System.currentTimeMillis();
			System.out.println(t2 - t1);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}
