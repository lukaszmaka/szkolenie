package com.aptitude.spring2;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class EmployeeBatchScheduler {
	
	private JobLauncher jobLauncher;
	private Job jdbcToCsvJob;
	
	@Autowired
	public EmployeeBatchScheduler(JobLauncher jobLauncher, Job jdbcToCsvJob) {
		this.jobLauncher = jobLauncher;
		this.jdbcToCsvJob = jdbcToCsvJob;
	}
	
	@Scheduled(fixedDelay=10000)
	public void scheduledJobRun() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		jobLauncher.run(jdbcToCsvJob, new JobParametersBuilder().addDate("launch-date", new Date())
																.toJobParameters());
	}
}
