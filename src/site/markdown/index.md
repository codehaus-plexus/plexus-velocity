---
title: Plexus Velocity Component
author: Olivier Lamy
---

# Plexus Velocity Component

A component which provides [Apache Velocity](https://velocity.apache.org/) templating engine integration.

## Typical use

A typical use:

```java
VelocityContext context = new VelocityContext();
VelocityComponent velocityComponent = lookup( VelocityComponent.class );
Template template = velocityComponent.getEngine().getTemplate( "path to your template" );
StringWriter writer = new StringWriter();
template.merge( context, writer );
```

## Typical Configuration

Plexus Velocity Component comes with a default configuration: it is expected to be customized to match
local specific need. This is done by creating `VelocityComponentConfigurator` component implementation.
Presence of this component is optional.

See [Velocity Configuration](https://velocity.apache.org/engine/2.4.1/configuration.html) reference
documentation for details on available configurations.
