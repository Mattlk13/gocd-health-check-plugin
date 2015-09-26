/**
 * Copyright (c) 2015 the original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.jmnarloch.cd.go.plugin.healthcheck;

import com.thoughtworks.go.plugin.api.annotation.Extension;
import io.jmnarloch.cd.go.plugin.api.config.AnnotatedEnumConfigurationProvider;
import io.jmnarloch.cd.go.plugin.api.dispatcher.ApiRequestDispatcher;
import io.jmnarloch.cd.go.plugin.api.dispatcher.ApiRequestDispatcherBuilder;
import io.jmnarloch.cd.go.plugin.api.task.AbstractDispatchingTask;

/**
 *
 */
@Extension
public class HealthCheckTask extends AbstractDispatchingTask {

    @Override
    protected ApiRequestDispatcher buildDispatcher() {

        return ApiRequestDispatcherBuilder.dispatch()
                .toExecutor(new HealthCheckTaskExecutor())
                .toValidator(new HealthCheckTaskValidator())
                .toConfiguration(new AnnotatedEnumConfigurationProvider<>(HealthCheckTaskConfig.class))
                .toView(new HealthCheckTaskView())
                .build();
    }
}
