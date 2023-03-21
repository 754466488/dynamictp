package com.dzw.dynamic;

import com.dtp.common.em.QueueTypeEnum;
import com.dtp.common.em.RejectedTypeEnum;
import com.dtp.core.support.ThreadPoolBuilder;
import com.dtp.core.support.ThreadPoolCreator;
import com.dtp.core.thread.DtpExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description Description
 * @Author lyb
 * @Date Created in 2023/2/3
 */
@Configuration
public class ThreadPoolConfiguration {
	@Bean
	public DtpExecutor dtpExecutor() {
		return ThreadPoolCreator.createDynamicFast("dynamic-tp-test-1");
	}

	@Bean
	public ThreadPoolExecutor dynamicExecutor() {
		return ThreadPoolBuilder.newBuilder()
				.threadPoolName("dynamicExecutor")
				.corePoolSize(2)
				.maximumPoolSize(2)
				.keepAliveTime(6000L)
				.timeUnit(TimeUnit.MILLISECONDS)
				.workQueue(QueueTypeEnum.ARRAY_BLOCKING_QUEUE.getName(), 2, true)
				.rejectedExecutionHandler(RejectedTypeEnum.DISCARD_POLICY.getName())
				.buildDynamic();
	}

	@Bean
	public ThreadPoolExecutor dynamicExecutor2() {
		return ThreadPoolBuilder.newBuilder()
				.threadPoolName("dynamicExecutor2")
				.corePoolSize(2)
				.maximumPoolSize(2)
				.keepAliveTime(6000L)
				.timeUnit(TimeUnit.MILLISECONDS)
				.workQueue(QueueTypeEnum.ARRAY_BLOCKING_QUEUE.getName(), 2, true)
				.rejectedExecutionHandler(RejectedTypeEnum.DISCARD_POLICY.getName())
				.buildDynamic();
	}
}
