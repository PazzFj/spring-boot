/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.context;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 如果系统文件编码与环境中设置的期望值不匹配，{@link ApplicationListener}将停止应用程序启动。
 */
public class FileEncodingApplicationListener
		implements ApplicationListener<ApplicationEnvironmentPreparedEvent>, Ordered {

	private static final Log logger = LogFactory.getLog(FileEncodingApplicationListener.class);

	@Override
	public int getOrder() {
		return Ordered.LOWEST_PRECEDENCE;
	}

	@Override
	public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
		ConfigurableEnvironment environment = event.getEnvironment();
		if (!environment.containsProperty("spring.mandatory-file-encoding")) {
			return;
		}
		String encoding = System.getProperty("file.encoding");
		String desired = environment.getProperty("spring.mandatory-file-encoding");
		if (encoding != null && !desired.equalsIgnoreCase(encoding)) {
			if (logger.isErrorEnabled()) {
				logger.error("System property 'file.encoding' is currently '" + encoding + "'. It should be '" + desired
						+ "' (as defined in 'spring.mandatoryFileEncoding').");
				logger.error("Environment variable LANG is '" + System.getenv("LANG")
						+ "'. You could use a locale setting that matches encoding='" + desired + "'.");
				logger.error("Environment variable LC_ALL is '" + System.getenv("LC_ALL")
						+ "'. You could use a locale setting that matches encoding='" + desired + "'.");
			}
			throw new IllegalStateException("The Java Virtual Machine has not been configured to use the "
					+ "desired default character encoding (" + desired + ").");
		}
	}

}
