package demo.quartz.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import demo.quartz.service.RedisService;

public class RedisSetJob implements Job {

	private static final Logger logger = Logger.getLogger(RedisSetJob.class);

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		logger.info("-> ########## begin ##########");
		RedisService redisService = new RedisService();
		String key = "nowDate";
		String val = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		redisService.set(key, val);
		logger.info("-> get, result : { " + key + " : " + redisService.get(key)
				+ " }");
		logger.info("-> ##########  end  ##########");
	}
}
