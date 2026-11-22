---
title: Plexus Velocity Component
author: Olivier Lamy
---

# Plexus Velocity Component

A component which provides [Apache Velocity](https://velocity.apache.org/) templating engine integration.
It requires Java 8 or later.

## Typical use

A typical use:

```java
@Inject
VelocityComponent velocityComponent;

VelocityContext context = new VelocityContext();
Template template = velocityComponent.getEngine().getTemplate( "path/to/template.vm" );
StringWriter writer = new StringWriter();
template.merge( context, writer );
```

## Typical Configuration

Plexus Velocity Component comes with a default configuration: it is expected to be customized to match
local specific need. This is done by creating `VelocityComponentConfigurator` component implementation.
Presence of this component is optional. Its `configure(Properties)` method receives the defaults before
the engine starts, so it can change or replace any of them. The engine is created once and shared.

The defaults are:

- templates are looked up on the classpath first, then as files (the file loader path is empty, so a
  relative name resolves against the working directory and an absolute path works as is);
- `#include` and `#parse` resolve relative to the including template (`IncludeRelativePath`);
- invalid references are not logged, and neither is each template that is found;
- a `#macro` defined inline replaces a global one with the same name (`velocimacro.inline.replace_global`);
- `parser.space_gobbling` is `bc`.

See [Velocity Configuration](https://velocity.apache.org/engine/2.4.1/configuration.html) reference
documentation for details on available configurations.
