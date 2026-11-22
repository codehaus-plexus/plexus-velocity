# Plexus Velocity

[![Maven Central](https://img.shields.io/maven-central/v/org.codehaus.plexus/plexus-velocity.svg?label=Maven%20Central)](https://central.sonatype.com/artifact/org.codehaus.plexus/plexus-velocity)
[![GitHub CI](https://github.com/codehaus-plexus/plexus-velocity/actions/workflows/maven.yml/badge.svg?branch=master)](https://github.com/codehaus-plexus/plexus-velocity/actions/workflows/maven.yml?query=branch%3Amaster)
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

The engine starts with these defaults, which a `VelocityComponentConfigurator` can change or replace:

- templates are looked up on the classpath first, then as files (the file loader path is empty, so a
  relative name resolves against the working directory and an absolute path works as is);
- `#include` and `#parse` resolve relative to the including template (`IncludeRelativePath`);
- invalid references are not logged, and neither is each template that is found;
- a `#macro` defined inline replaces a global one with the same name (`velocimacro.inline.replace_global`);
- `parser.space_gobbling` is `bc`.

The default configuration is meant to be customised: provide a `VelocityComponentConfigurator`
implementation, whose `configure(Properties)` receives these defaults before the engine starts, and it will be
picked up. It is optional. The engine is created once and shared. See the
[Velocity configuration reference](https://velocity.apache.org/engine/2.4.1/configuration.html) for what
can be set.

## Requirements

Java 8 or later. Building the project needs Maven 3.9.0 or later.

## Documentation

- [Project site](https://codehaus-plexus.github.io/plexus-velocity/)
- [Javadoc](https://javadoc.io/doc/org.codehaus.plexus/plexus-velocity)
- [Release notes](https://github.com/codehaus-plexus/plexus-velocity/releases)

## Contributing

Conventions for contributors and agents are in [AGENTS.md](AGENTS.md); see also
[CONTRIBUTING.md](https://github.com/codehaus-plexus/.github/blob/master/CONTRIBUTING.md). In short:
`mvn verify` builds, and run `mvn spotless:apply` before pushing or CI will fail on formatting.

Please report security vulnerabilities privately — see
[SECURITY.md](https://github.com/codehaus-plexus/.github/blob/master/SECURITY.md), not a public issue.
