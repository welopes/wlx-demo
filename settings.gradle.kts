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
        val gprUser = providers.gradleProperty("gpr.user").orNull ?: System.getenv("GPR_USER")
        val gprKey = providers.gradleProperty("gpr.key").orNull ?: System.getenv("GPR_TOKEN")
        maven {
            url = uri("https://maven.pkg.github.com/welopes/wlx-logger")
            credentials {
                username = gprUser
                password = gprKey
            }
        }
    }
}

rootProject.name = "WLX Demo"
include(":app")
include(":modules:journey:login")
