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

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.eclipse.sisu.launch.InjectedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DefaultVelocityComponentTest extends InjectedTest {
    @Test
    public void testBasic() {
        VelocityComponent velocity;

        VelocityContext context;

        String value;

        velocity = lookup(VelocityComponent.class);

        // test the properties
        value = (String) velocity.getEngine().getProperty("hello");

        assertNotNull(value);

        assertEquals("world", value);

        // test the rendering
        context = new VelocityContext();

        context.put("variable", "Value from context");

        Template template =
                velocity.getEngine().getTemplate("org/codehaus/plexus/velocity/DefaultVelocityComponentTest.vm");

        StringWriter writer = new StringWriter();

        template.merge(context, writer);

        assertEquals("Static text -- Value from context -- More static text", writer.toString());
    }
}
