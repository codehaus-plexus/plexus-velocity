# Agent guide for plexus-velocity

`org.codehaus.plexus:plexus-velocity` provides a ready-configured Apache Velocity engine as an
injectable component, so a Maven plugin can render a template without setting up Velocity itself. It
is a thin wrapper whose changes are mostly Velocity upgrades. User docs are in `README.md` and
`src/site/markdown/index.md`.

## Build and test

- CI calls the shared `codehaus-plexus/.github` `maven.yml@master` workflow, which runs
  `mvn verify javadoc:javadoc` on JDK 8, 21 and 25 and on Linux, Windows and macOS.
- Main code must use the Java 8 API (`javaVersion` 8 from the `plexus` parent).
- Unit tests use JUnit 5 and live in `src/test/java`.
- Keep the injectable component working when upgrading Velocity: consumers obtain the engine through
  injection (`@Inject`), as the README's example shows. The defaults set in `DefaultVelocityComponent`
  are documented in the README and on the site page; keep all three in step.
- The JAR sets `Automatic-Module-Name: org.codehaus.plexus.velocity`; keep that name stable.
- Run `mvn spotless:apply` on JDK 17 to 21 before pushing; it also formats Markdown, except
  `src/site/markdown`.

## Documentation updates

A change that users or contributors can notice ships with the documentation it affects, in the same
pull request. A refactor with no visible effect needs none.

- A changed default engine property in `DefaultVelocityComponent`, or a change to
  `VelocityComponent` or `VelocityComponentConfigurator`: their Javadoc, the "Typical Configuration"
  section of `src/site/markdown/index.md` and the matching section of `README.md`.
- `src/site/markdown/index.md` is the only site page, listed as Introduction in `src/site/site.xml`
  together with the Javadoc; add a menu item there when adding a page.
- The Java requirement, or how to build and release: `README.md`.
- A new convention, build gate or test fixture: this file.

