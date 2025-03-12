plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.db_alon"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.db_alon"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
dependencies {
    // Room dependencies with exclusion of the conflicting annotations version
    implementation("androidx.room:room-runtime:2.6.1") {
        exclude(group = "com.intellij", module = "annotations")  // Exclude the older version of annotations
    }
    annotationProcessor("androidx.room:room-compiler:2.6.1") { // Ensure annotation processor is included
        exclude(group = "com.intellij", module = "annotations")  // Exclude the older version of annotations
    }

    // Force the usage of the correct annotations version (13.0)
    implementation("org.jetbrains:annotations:13.0")

    // Your other dependencies
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
