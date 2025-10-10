package org.codehaus.plexus.velocity.internal;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Internal <code>Nullable</code> annotation to mark parameters that can be null.
 * <p>
 * Guice allow any Nullable annotation, so this one can be used instead of adding a dependency to sisu-inject.
 * <a href="https://github.com/google/guice/wiki/UseNullable">UseNullable</a>
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface Nullable {}
