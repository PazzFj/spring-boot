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

package org.springframework.boot.context.event;

import org.springframework.boot.SpringApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

/**
 * 当{@link SpringApplication}正在启动并且{@link Environment}首先可供检查和修改时发布的事件
 */
@SuppressWarnings("serial")
public class ApplicationEnvironmentPreparedEvent extends SpringApplicationEvent {

	private final ConfigurableEnvironment environment;

	/**
	 * Create a new {@link ApplicationEnvironmentPreparedEvent} instance.
	 */
	public ApplicationEnvironmentPreparedEvent(SpringApplication application, String[] args,
			ConfigurableEnvironment environment) {
		super(application, args);
		this.environment = environment;
	}

	/**
	 * Return the environment.
	 */
	public ConfigurableEnvironment getEnvironment() {
		return this.environment;
	}

}
