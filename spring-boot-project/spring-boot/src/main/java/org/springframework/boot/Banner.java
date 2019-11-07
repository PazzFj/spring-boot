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

package org.springframework.boot;

import java.io.PrintStream;

import org.springframework.core.env.Environment;

/**
 * 用于以编程方式编写横幅的接口类
 */
@FunctionalInterface
public interface Banner {

	/**
	 * 将横幅打印到指定的打印流
	 */
	void printBanner(Environment environment, Class<?> sourceClass, PrintStream out);

	/**
	 * 用于配置横幅的可能值的枚举
	 */
	enum Mode {

		/**
		 * 禁止打印横幅
		 */
		OFF,

		/**
		 * 将横幅打印到System.out
		 */
		CONSOLE,

		/**
		 * 将横幅打印到日志文件
		 */
		LOG

	}

}
