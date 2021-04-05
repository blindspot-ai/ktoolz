/**
 * The list of libraries used by ktoolz.
 */
object Libs {
    // development libraries
    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}" // kotlin standard library

    const val slf4j = "org.slf4j:slf4j-api:${Versions.slf4j}" // logging DSL
    const val kotlinLogging = "io.github.microutils:kotlin-logging:${Versions.kotlinLogging}" // logging DSL

    // QA dependencies
    const val detektPlugin = "io.gitlab.arturbosch.detekt:detekt-formatting:${Versions.detekt}"
}
