package com.tripoin.batch.processor;

import org.springframework.batch.item.ItemProcessor;

import com.tripoin.test.dto.Report;

public class CustomItemProcessor implements ItemProcessor<Report, Report> {

	@Override
	public Report process(Report item) throws Exception {
		
		System.out.println("Processing..." + item);
		return item;
	}

}