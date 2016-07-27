package demo.quartz.common;

public class Constant {

	/**
	 * 配置文件路径
	 */
	public final static String PROFILEPATH_REDIS = "conf/redis.properties";
	public final static String PROFILEPATH_CRON = "conf/cron.properties";
	
	/*
	 * .properties file key
	 */
	public final static String REDIS_HOST = "redis.host";
	public final static String REDIS_PORT = "redis.port";
	public final static String REDIS_TIMEOUT = "redis.timeout";
	public final static String REDIS_PASSWORD = "redis.password";
	public final static String REDIS_DATABASE = "redis.database";
	
	public final static String CRON_REDISSET = "cron.RedisSetJob";
}
