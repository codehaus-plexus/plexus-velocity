package org.codehaus.plexus.velocity;

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

import java.util.Properties;

/**
 * The VelocityComponent configuration that may configure {@link java.util.Properties} prior having them used to init
 * Velocity Engine. This component is optional, is not needed if default are sufficient.
 *
 * @since TBD
 */
public interface VelocityComponentConfigurator {
    void configure(Properties properties);
}
