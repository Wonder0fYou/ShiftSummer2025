plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.ksp)
    id("com.google.protobuf") version "0.9.1"

}

android {
    namespace = "ru.shift.data_store"
    compileSdk = 36

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(project(":core:di"))

    implementation(libs.dagger)
    ksp(libs.dagger.compiler)
    implementation("androidx.datastore:datastore-preferences:1.1.3")
    implementation("androidx.datastore:datastore-core:1.1.3")
    implementation("com.google.protobuf:protobuf-javalite:3.18.0")
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.21.7"
    }

    generateProtoTasks {
        all().forEach {
            it.builtins {
                create("java") {
                    option("lite")
                }
            }
        }
    }
}