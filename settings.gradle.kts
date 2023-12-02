pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "cashsense"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
include(":core:common")
include(":core:database")
include(":core:datastore")
include(":core:datastore-proto")
include(":core:data")
include(":core:designsystem")
include(":core:model")
include(":core:ui")

include(":feature:home")
include(":feature:categories")
include(":feature:subscriptions")
include(":feature:transactions")
include(":feature:wallet")
include(":feature:settings")