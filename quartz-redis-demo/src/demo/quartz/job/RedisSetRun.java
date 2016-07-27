package demo.quartz.job;

import static org.quartz.JobBuilder.newJob;
import org.apache.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import demo.quartz.common.Constant;
import demo.quartz.util.PropertyUtil;

public class RedisSetRun {

	private static final Logger logger = Logger.getLogger(RedisSetRun.class);

	public void run() throws Exception {
		// 通过SchedulerFactory获取一个调度器实例
		SchedulerFactory sf = new StdSchedulerFactory();

		Scheduler sched = sf.getScheduler();

		// 通过过JobDetail封装LogStorageJob，同时指定Job在Scheduler中所属组及名称，这里，组名为LogStorageGroup，而名称为LogStorageJob。
		JobDetail job = newJob(RedisSetJob.class).withIdentity(
				"RedisSetJob", "RedisSetGroup").build();

		// 创建一个SimpleTrigger实例，指定该Trigger在Scheduler中所属组及名称。
		CronTrigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity("RedisSetTrigger", "RedisSetGroup")
				.withSchedule(
						CronScheduleBuilder.cronSchedule(PropertyUtil
								.readValueByCron(Constant.CRON_REDISSET)))
				.build();

		// 注册并进行调度
		sched.scheduleJob(job, trigger);

		// 启动调度器
		sched.start();
		logger.info("-> 入库任务启动！");

	}

	/**
	 * 测试运行
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		new RedisSetRun().run();
	}
}
