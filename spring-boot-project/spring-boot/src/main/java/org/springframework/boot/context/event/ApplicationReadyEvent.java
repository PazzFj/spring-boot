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
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 尽可能晚地发布事件，以表明应用程序已准备好为请求提供服务。
 * 事件的来源是{@link SpringApplication}本身，
 * 但是要注意修改它的内部状态，因为到那时所有的初始化步骤都已经完成了
 */
@SuppressWarnings("serial")
public class ApplicationReadyEvent extends SpringApplicationEvent {

	private final ConfigurableApplicationContext context;

	public ApplicationReadyEvent(SpringApplication application, String[] args, ConfigurableApplicationContext context) {
		super(application, args);
		this.context = context;
	}

	public ConfigurableApplicationContext getApplicationContext() {
		return this.context;
	}

}
