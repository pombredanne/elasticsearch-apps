/*
 * Licensed to ElasticSearch and Shay Banon under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. ElasticSearch licenses this
 * file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.river;

import org.elasticsearch.apps.AppService;
import org.elasticsearch.common.inject.AbstractModule;
import org.elasticsearch.common.inject.Module;
import org.elasticsearch.common.inject.PreProcessModule;
import org.elasticsearch.common.settings.Settings;

/**
 * A module that simply calls the {@link PluginsService#processModule(org.elasticsearch.common.inject.Module)}
 * in order to allow plugins to pre process specific river modules.
 */
public class RiversPluginsModule extends AbstractModule implements PreProcessModule {

    private final Settings settings;

    private final AppService appService;

    public RiversPluginsModule(Settings settings, AppService appService) {
        this.settings = settings;
        this.appService = appService;
    }

    @Override
    public void processModule(Module module) {
        appService.processModule(module);
    }

    @Override
    protected void configure() {
    }
}