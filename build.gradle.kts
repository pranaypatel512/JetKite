plugins {
    id(BuildPlugins.KOTLINTER) version BuildPlugins.KOTLINTER_VERSION apply true
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        maven("https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath(BuildPlugins.TOOLS_BUILD_GRADLE)
        classpath(BuildPlugins.DAGGER_HILT_PLUGIN)
        classpath(BuildPlugins.KOTLIN_GRADLE_PLUGIN)
        classpath(BuildPlugins.KTLINT_GRADLE_PLUGIN)
        classpath(BuildPlugins.TWITTER_COMPOSE_RULES)
    }
}
subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    apply(plugin = BuildPlugins.KOTLINTER)
}
allprojects {
    repositories {
        google()
        mavenCentral()
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
        kotlinOptions.freeCompilerArgs += listOf(
            "-Xopt-in=kotlin.RequiresOptIn",
            "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi"
        )
        kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

tasks.register("clean").configure {
    delete(rootProject.buildDir)
}

tasks.register("installGitHook", Copy::class) {
    from("${rootProject.rootDir}/scripts/git-hooks")
    into("${rootProject.rootDir}/.git/hooks")
    fileMode = 7 * 64 + 7 * 8 + 7
}

tasks.register("check").configure {
    dependsOn("installKotlinterPrePushHook")
}

kotlinter {
    ignoreFailures = false
    reporters = arrayOf("checkstyle", "html", "plain")
    experimentalRules = true
    disabledRules = emptyArray()
    // disabledRules = arrayOf("experimental:argument-list-wrapping", "no-wildcard-imports")
}
