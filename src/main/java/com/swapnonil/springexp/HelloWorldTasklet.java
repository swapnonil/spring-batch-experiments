package com.swapnonil.springexp;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class HelloWorldTasklet implements Tasklet
{

	public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception
	{
		System.out.println("HELLO_WORLD");
		return RepeatStatus.FINISHED;
	}
}
