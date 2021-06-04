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

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.codehaus.plexus.personality.plexus.lifecycle.phase.Initializable;
import org.codehaus.plexus.personality.plexus.lifecycle.phase.InitializationException;
import org.codehaus.plexus.logging.AbstractLogEnabled;

/**
 * <p>
 * A simple velocity component implementation.
 * </p>
 * A typical configuration will look like this:
 * <pre>
 *      &lt;configuration&gt;
 *        &lt;properties&gt;
 *          &lt;property&gt;
 *            &lt;name&gt;resource.loader&lt;/name&gt;
 *            &lt;value&gt;classpath&lt;/value&gt;
 *          &lt;/property&gt;
 *          &lt;property&gt;
 *            &lt;name&gt;classpath.resource.loader.class&lt;/name&gt;
 *            &lt;value&gt;org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader&lt;/value&gt;
 *          &lt;/property&gt;
 *        &lt;/properties&gt;
 *      &lt;/configuration&gt;
 * </pre>
 */
public class DefaultVelocityComponent
    extends AbstractLogEnabled
    implements VelocityComponent, Initializable
{
    private VelocityEngine engine;

    private Properties properties;

    // ----------------------------------------------------------------------
    //
    // ----------------------------------------------------------------------

    public void initialize()
        throws InitializationException
    {
        engine = new VelocityEngine();
        // avoid "unable to find resource 'VM_global_library.vm' in any resource loader."
        engine.setProperty( RuntimeConstants.VM_LIBRARY, "" );
        if ( properties != null )
        {
            engine.setProperties( properties );
        }

        try
        {
            engine.init();
        }
        catch ( Exception e )
        {
            throw new InitializationException( "Cannot start the Velocity engine", e );
        }
    }

    public VelocityEngine getEngine()
    {
        return engine;
    }

}
