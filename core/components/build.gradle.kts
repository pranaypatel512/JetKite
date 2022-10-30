plugins {
    id(BuildPlugins.ANDROID_LIBRARY_PLUGIN)
    id(BuildPlugins.KOTLIN_ANDROID_PLUGIN)
    id(BuildPlugins.KOTLIN_PARCELABLE_PLUGIN)
    id(BuildPlugins.KOTLIN_KAPT)
}

android {
    namespace = "com.pranay.jetkite.components"
    compileSdk = (ProjectProperties.COMPILE_SDK)

    defaultConfig {
        minSdk = (ProjectProperties.MIN_SDK)
        targetSdk = (ProjectProperties.TARGET_SDK)
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        dataBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Lib.Android.COMPOSE_COMPILER_VERSION
    }
    packagingOptions {
        resources.excludes.add("META-INF/LICENSE.txt")
        resources.excludes.add("META-INF/NOTICE.txt")
        resources.excludes.add("LICENSE.txt")
        resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":core:designsystem"))
    /* Android Designing and layout */
    implementation(Lib.Android.MATERIAL_DESIGN)
    implementation(Lib.Android.ACCOMPANIST_SYSTEM_UI_CONTROLLER)
    implementation(Lib.Material3.MATERIAL_3)
    implementation(Lib.Kotlin.KTX_CORE)
    implementation(Lib.Android.COMPOSE_TOOLING_PREVIEW)
    debugImplementation(Lib.Android.COMPOSE_TOOLING)

}
