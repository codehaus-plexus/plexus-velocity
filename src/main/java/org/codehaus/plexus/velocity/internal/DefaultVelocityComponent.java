package org.codehaus.plexus.velocity.internal;

/*
 * Copyright 2001-2016 Codehaus Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import java.util.Properties;

import org.apache.velocity.app.VelocityEngine;
import org.codehaus.plexus.velocity.VelocityComponent;
import org.codehaus.plexus.velocity.VelocityComponentConfigurator;

/**
 * Default component implementation. The presence of {@link VelocityComponentConfigurator} is optional.
 */
@Singleton
@Named
public class DefaultVelocityComponent implements VelocityComponent {
    private final VelocityEngine engine;

    @Inject
    public DefaultVelocityComponent(@Nullable VelocityComponentConfigurator componentConfigurator) {
        Properties properties = new Properties();

        // fill in defaults
        properties.setProperty("resource.loaders", "classpath,file");
        properties.setProperty(
                "resource.loader.classpath.class",
                "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        properties.setProperty(
                "resource.loader.file.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
        properties.setProperty("resource.loader.file.path", "");
        properties.setProperty("runtime.log.log_invalid_references", "false");
        properties.setProperty("resource.manager.log_when_found", "false");
        properties.setProperty(
                "event_handler.include.class", "org.apache.velocity.app.event.implement.IncludeRelativePath");
        properties.setProperty("velocimacro.inline.replace_global", "true");
        properties.setProperty("parser.space_gobbling", "bc");

        // customize if needed
        if (componentConfigurator != null) {
            componentConfigurator.configure(properties);
        }

        VelocityEngine engine = new VelocityEngine();
        engine.setProperties(properties);
        engine.init();

        this.engine = engine;
    }

    @Override
    public VelocityEngine getEngine() {
        return engine;
    }
}
