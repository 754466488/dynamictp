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

	@GetMapping("/dtp-example/test")
	public String test() {
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
