package com.ahmed.book.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Log4j2
public class PriceSchedule {
		
	@Scheduled(fixedRate = 200000)
//	@SchedulerLock(name = "bookComputePrice")
	@Async
	public void computePrice () throws InterruptedException {
	
		Thread.sleep(4000);
		
		log.info("compute price >> " + LocalDateTime.now());
	}
	
	
	@Scheduled(fixedRate = 200000)
//	@SchedulerLock(name = "bookComputeDiscount")
	@Async
	public void computeDiscount () throws InterruptedException {
	
		Thread.sleep(4000);
		
		log.info("compute discount >> " + LocalDateTime.now());
	}

}
