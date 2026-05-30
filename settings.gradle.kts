pluginManagement {
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

rootProject.name = "CloneMaster"
include(":app")
include(":business_ability")
include(":business_ability:clone_create")
include(":business_ability:clone_manage")
include(":system_kernel")
include(":system_kernel:sandbox_isolate")
include(":system_kernel:process_control")
