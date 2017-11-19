// See https://github.com/eed3si9n/sbt-assembly
addSbtPlugin("com.eed3si9n"                      % "sbt-assembly"      % "0.14.5")

// See https://github.com/ThoughtWorksInc/sbt-api-mappings
addSbtPlugin("com.thoughtworks.sbt-api-mappings" % "sbt-api-mappings"  % "1.1.0")

// See https://github.com/sbt/sbt-bintray
addSbtPlugin("org.foundweekends"                 % "sbt-bintray"       % "0.5.1")

// See https://stackoverflow.com/a/27858890/553865
evictionWarningOptions in update :=
  EvictionWarningOptions
    .default
    .withWarnTransitiveEvictions(false)
    .withWarnDirectEvictions(false)
    .withWarnScalaVersionEviction(false)