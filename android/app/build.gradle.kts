import java.util.Properties
import java.io.FileInputStream

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("dev.flutter.flutter-gradle-plugin")
}

android {
    namespace = "com.erevu.omniclip"
    compileSdk = flutter.compileSdkVersion
    ndkVersion = flutter.ndkVersion

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    defaultConfig {
        applicationId = "com.erevu.omniclip"
        minSdk = flutter.minSdkVersion
        targetSdk = flutter.targetSdkVersion
        versionCode = flutter.versionCode
        versionName = flutter.versionName
    }

    val keystorePropertiesFile = rootProject.file("key.properties")
    val keystoreProperties = Properties()
    if (keystorePropertiesFile.exists()) {
        keystoreProperties.load(FileInputStream(keystorePropertiesFile))
    }

    signingConfigs {
        getByName("debug") {
            storeFile = file("../debug.keystore")
        }
        
        create("release") {
            val sFile = keystoreProperties.getProperty("storeFile")
            
            this.storeFile = if (sFile != null) file(sFile) else file("../omniclip.keystore")
            this.storePassword = keystoreProperties.getProperty("storePassword")
            this.keyAlias = keystoreProperties.getProperty("keyAlias")
            this.keyPassword = keystoreProperties.getProperty("keyPassword")
        }
    } 
    buildTypes {
        getByName("release") {
            signingConfig = signingConfigs.getByName("release")
        }
    }

    flutter {
        source = "../.."
    }
}