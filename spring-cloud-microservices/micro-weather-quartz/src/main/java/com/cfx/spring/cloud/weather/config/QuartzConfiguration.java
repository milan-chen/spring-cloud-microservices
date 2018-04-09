package com.cfx.spring.cloud.weather.config;

import com.cfx.spring.cloud.weather.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: cfx
 * @Description: Quartz配置类
 * @Date: Created in 2018/4/5 19:54
 */
@Configuration
public class QuartzConfiguration {

    private static final int TIME = 1800;//更新频率

    //JobDetail
    @Bean
    public JobDetail weatherDataSyncJobDetail() {
        return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJob")
        .storeDurably().build();
    }
    //Trigger触发器
    //还可以使用CronScheduleBuilder来自定义cron表达式，更加灵活
    @Bean
    public Trigger weatherDataSyncTrigger() {
        SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(TIME).repeatForever();

        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail())
                .withIdentity("weatherDataSyncTrigger").withSchedule(schedBuilder).build();
    }

}
