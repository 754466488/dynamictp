package com.dzw.dynamic;

import com.dtp.core.DtpRegistry;
import com.dtp.core.thread.DtpExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description Description
 * @Author lyb
 * @Date Created in 2023/2/3
 */
@Slf4j
@RestController
public class TestController {
	@Autowired
	private ThreadPoolExecutor threadPoolExecutor;

	/**
	 * @Description: 测试自定义线程池
	 * @Author: lyb
	 * @Date: 2023/2/6 11:18 上午
	 * @Version: 1.0
	 * @Return:
	 */
	@GetMapping("/thread/customize/test")
	public String busThreadTest() {
		new Thread(() -> {
			try {
				task();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		return "success";
	}

	public void task() throws InterruptedException {
		for (int i = 0; i < 100; i++) {
			threadPoolExecutor.execute(() -> {
				try {
					log.info("i am dynamic-tp-test-2 task");
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}
	}
}
