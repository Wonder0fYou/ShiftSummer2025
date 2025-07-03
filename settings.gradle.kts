pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "Shift Summer 2025"
include(":app")

include(":core:di")
include(":core:feature-api")
include(":core:design-system")
include(":core:data:remote")
include(":core:data:data-store")

include(":data:authorization")
include(":data:otps")
include(":data:cars")

include(":feature:authorization:authorization-api")
include(":feature:authorization:authorization-data")
include(":feature:authorization:authorization-domain")
include(":feature:authorization:authorization-impl")
 