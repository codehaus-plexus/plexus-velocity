# Plexus Velocity

[![Maven Central](https://img.shields.io/maven-central/v/org.codehaus.plexus/plexus-velocity.svg?label=Maven%20Central)](https://central.sonatype.com/artifact/org.codehaus.plexus/plexus-velocity)
[![GitHub CI](https://github.com/codehaus-plexus/plexus-velocity/actions/workflows/maven.yml/badge.svg)](https://github.com/codehaus-plexus/plexus-velocity/actions/workflows/maven.yml)
[![Reproducible Builds](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/jvm-repo-rebuild/reproducible-central/master/content/org/codehaus/plexus/plexus-velocity/badge.json)](https://github.com/jvm-repo-rebuild/reproducible-central/blob/master/content/org/codehaus/plexus/plexus-velocity/README.md)
[![License](https://img.shields.io/github/license/codehaus-plexus/plexus-velocity.svg?label=License)](https://www.apache.org/licenses/LICENSE-2.0)

A ready-configured [Apache Velocity](https://velocity.apache.org/) engine as an injectable component, so a
plugin can render a template without setting up Velocity itself.

## Status

Maintained, quietly. It is a thin wrapper over Velocity; most changes here are Velocity upgrades.

## Using it

```xml
<dependency>
  <groupId>org.codehaus.plexus</groupId>
  <artifactId>plexus-velocity</artifactId>
</dependency>
```

Check the badge above for the current version.

```java
@Inject
VelocityComponent velocityComponent;

VelocityContext context = new VelocityContext();
Template template = velocityComponent.getEngine().getTemplate( "path/to/template.vm" );
StringWriter writer = new StringWriter();
template.merge( context, writer );
```

Check the badge above for the current version.

The default configuration is meant to be customised: provide a `VelocityComponentConfigurator`
implementation and it will be picked up. It is optional. See the
[Velocity configuration reference](https://velocity.apache.org/engine/2.4.1/configuration.html) for what
can be set.

## Requirements

Java 8 or later.

## Documentation

- [Project site](https://codehaus-plexus.github.io/plexus-velocity/)
- [Javadoc](https://javadoc.io/doc/org.codehaus.plexus/plexus-velocity)
- [Release notes](https://github.com/codehaus-plexus/plexus-velocity/releases)

## Contributing

See [CONTRIBUTING.md](https://github.com/codehaus-plexus/.github/blob/master/CONTRIBUTING.md). In short:
`mvn verify` builds, and run `mvn spotless:apply` before pushing or CI will fail on formatting.

Please report security vulnerabilities privately — see
[SECURITY.md](https://github.com/codehaus-plexus/.github/blob/master/SECURITY.md), not a public issue.
