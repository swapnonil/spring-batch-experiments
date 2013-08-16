package com.swapnonil.springexp.partioning;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

public class HardcodedPartioner implements Partitioner
{

	public Map<String, ExecutionContext> partition(int gridSize)
	{
		int max = 1000000; // I am assuming that file has a this many records.
		int min = 0;
		int targetSize = (max - min) / gridSize;
		Map<String, ExecutionContext> result = new HashMap<String, ExecutionContext>();
		int number = 0;
		int start = min;
		int end = start + targetSize - 1;
		while (start <= max)
		{
			ExecutionContext value = new ExecutionContext();
			result.put("partition" + number, value);
			if (end >= max)
			{
				end = max;
			}
			value.putInt("minValue", start);
			value.putInt("maxValue", end);
			start += targetSize;
			end += targetSize;
			number++;
		}
		return result;		
	}

	public static void main(String[] args)
	{
		HardcodedPartioner partioner  =new HardcodedPartioner();
		System.out.println(partioner.partition(2));
		// Get the max Id the file
		File file = new File("data.txt");
		RandomAccessFile raf = null;
		try
		{
			raf = new RandomAccessFile(file, "r");
			raf.seek(raf.length() - 28);
			System.out.println(raf.readLine());

		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				raf.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
