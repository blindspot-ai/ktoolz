/**
 * The properties needed by build and read from `ktoolz.properties` file or environment variables.
 */
object Props {
    val bintrayUser = PropertyEntry.create(propertyName = "bintray.user", environmentName = "BINTRAY_USER")
    val bintrayApiKey = PropertyEntry.create(propertyName = "bintray.apiKey", environmentName = "BINTRAY_API_KEY")
}
