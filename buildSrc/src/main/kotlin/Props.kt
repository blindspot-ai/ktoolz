/**
 * The properties needed by build and read from `ktoolz.properties` file or environment variables.
 */
object Props {
    val githubActor = PropertyEntry.create(propertyName = "github.actor", environmentName = "GITHUB_ACTOR")
    val githubToken = PropertyEntry.create(propertyName = "github.token", environmentName = "GITHUB_TOKEN")
}
