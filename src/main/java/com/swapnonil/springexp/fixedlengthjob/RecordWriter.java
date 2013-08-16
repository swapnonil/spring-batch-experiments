package com.swapnonil.springexp.fixedlengthjob;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class RecordWriter implements ItemWriter<Record>
{
	public List<Record> records = new ArrayList<Record>();

	public List<Record> getProducts()
	{
		return records;
	}

	public void write(List<? extends Record> items) throws Exception
	{
		System.out.println(items);
	}
}
