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

import org.apache.velocity.app.VelocityEngine;

/**
 * The VelocityComponent API to access <a href="http://velocity.apache.org/engine/">Apache Velocity Engine</a>
 * configured through Plexus.
 */
public interface VelocityComponent {
    @Deprecated
    String ROLE = VelocityComponent.class.getName();

    VelocityEngine getEngine();
}
