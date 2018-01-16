package com.tsystems.ch.assessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TrainTrackingApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(TrainTrackingApplication.class, args);
    }
}
