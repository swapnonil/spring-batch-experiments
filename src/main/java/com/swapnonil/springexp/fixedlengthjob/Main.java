package com.swapnonil.springexp.fixedlengthjob;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{
	public static void main(String[] args)
	{
		String[] config =
		{ "fixed-length-job.xml" };

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
		JobLauncher jobLauncher = (JobLauncher) applicationContext.getBean("jobLauncher");
		Job job = (Job) applicationContext.getBean("fixed-length-job");

		try
		{
			long t1 = System.currentTimeMillis();
			// Launch a job with timestamp so that it can be started multiple
			// times
			JobExecution execution = jobLauncher.run(
					job,
					new JobParametersBuilder()
							.addString("timestamp", new SimpleDateFormat("dd/MM/yyyy").format(new Date()) + "-06")
							.addString("filename", "fixed-length.txt").toJobParameters());
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
