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

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.support.SpringFactoriesLoader;

/**
 * springboot 应用运行监听器
 * {@link org.springframework.boot.context.event.EventPublishingRunListener} 做为实现类
 */
public interface SpringApplicationRunListener {

    /**
     * 开始进行: 在run方法首次启动时立即调用。可用于非常早的初始化
     */
    default void starting() {
    }

    /**
     * 应用环境准备: 在这之前一旦环境准备好
     */
    default void environmentPrepared(ConfigurableEnvironment environment) {
    }

    /**
     * 应用上下文准备: 在创建并准备{@link ApplicationContext}之后，但在加载源之前调用
     */
    default void contextPrepared(ConfigurableApplicationContext context) {
    }

    /**
     * 应用上下文加载: 在加载应用程序上下文后刷新之前调用
     */
    default void contextLoaded(ConfigurableApplicationContext context) {
    }

    /**
     * 上下文已刷新，应用程序已启动，但尚未调用{@link CommandLineRunner CommandLineRunners}和
     * {@link ApplicationRunner ApplicationRunners}
     */
    default void started(ConfigurableApplicationContext context) {
    }

    /**
     * 在run方法完成之前调用，此时应用程序上下文已刷新并且所有{@link CommandLineRunner CommandLineRunners}和
     * {@link ApplicationRunner ApplicationRunners}都已调用
     */
    default void running(ConfigurableApplicationContext context) {
    }

    /**
     * 当一个失败的事物运行时呼叫
     */
    default void failed(ConfigurableApplicationContext context, Throwable exception) {
    }

}
