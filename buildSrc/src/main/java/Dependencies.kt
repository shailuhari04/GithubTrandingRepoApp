object Versions {
    const val RETROFIT = "2.3.0"
    const val SOURCE_COMPAT = "1.8"
    const val TARGET_COMPAT = "1.8"
    const val MIN_SDK = 21
    const val TARGET_SDK = 28
    const val COMPILE_SDK = 28
    const val BUILD_TOOLS = "28.0.3"

    // Kotlin
    const val KOTLIN = "1.3.61"
    const val KOTLIN_COROUTINES = "1.2.2"
    const val APACHE_COMMONS = "2.4"
    const val RETROFIT_COROUTINES_ADAPTER = "0.9.2"

    const val STETHO = "1.5.0"
    const val OKHTTP = "3.10.0"
    const val GLIDE = "4.9.0"
    const val JUNIT = "4.12"
    const val JUNIT_EXT = "1.1.0"
    const val WIRERE_MOKE = "2.18.0"
    const val TIMBER = "4.5.1"
    const val MOSHI = "1.6.0"

    //koin(DI)
    const val KOIN = "1.0.2"

    // android
    const val ANDROIDX = "1.0.0"
    const val ANDROIDX_LIFECYCLE = "2.0.0"
    const val ANDROIDX_PERSISTENCE = "2.2.0-alpha01"
    const val ANDROIDX_TEST = "1.1.0"
    const val ANDROIDX_CONSTRAINTLAYOUT = "1.1.3"

    const val ANDROID_GRADLE_PLUGIN = "3.5.3"
    const val ESPRESSO = "3.1.1"
    const val TEST_SUPPORT_LIB = "1.0.1"

    const val ASSERTJ = "3.11.1"
    const val ANDROID_DEBUG_DATABASE = "1.0.6"
}

object Libs {
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val GLIDE = "com.github.bumptech.glide:glide:${Versions.GLIDE}"
    const val RETROFIT_MOSHI_CONVERTER =
        "com.squareup.retrofit2:converter-moshi:${Versions.RETROFIT}"

    //DI(Koin)
    const val KOIN_CORE = "org.koin:koin-core:${Versions.KOIN}"
    const val KOIN_ANDROID = "org.koin:koin-android:${Versions.KOIN}"
    const val KOIN_ARCHITECTURE = "org.koin:koin-androidx-viewmodel:${Versions.KOIN}"
    const val KOIN_TEST = "org.koin:koin-test:${Versions.KOIN}"

    //AndroidX
    const val ANDROIDX_MATERIAL = "com.google.android.material:material:${Versions.ANDROIDX}"
    const val ANDROIDX_RECYCLERVIEW = "androidx.recyclerview:recyclerview:${Versions.ANDROIDX}"
    const val ANDROIDX_APPCOMPAT_V7 = "androidx.appcompat:appcompat:${Versions.ANDROIDX}"
    const val ANDROIDX_SUPPORT_V4 = "androidx.legacy:legacy-support-v4:${Versions.ANDROIDX}"
    const val androidx_annotations = "androidx.annotation:annotation:${Versions.ANDROIDX}"
    const val ANDROIDX_CONSTRAINTLAYOUT =
        "androidx.constraintlayout:constraintlayout:${Versions.ANDROIDX_CONSTRAINTLAYOUT}"


    const val ANDROIDX_PERSISTENCE_ROOM_RUNTIME =
        "androidx.room:room-runtime:${Versions.ANDROIDX_PERSISTENCE}" // Room
    const val ANDROIDX_PERSISTENCE_ROOM_KAPT =
        "androidx.room:room-compiler:${Versions.ANDROIDX_PERSISTENCE}" // Annotation Processor

    const val ANDROIDX_LIFECYCLE_LIVEDATA_CORE =
        "androidx.lifecycle:lifecycle-livedata-core:${Versions.ANDROIDX_LIFECYCLE}"

    const val ANDROIDX_PERSISTENCE_ROOM_KTX =
        "androidx.room:room-ktx:${Versions.ANDROIDX_PERSISTENCE}" // optional - Kotlin Extensions and Coroutines support for Room

    const val ANDROIDX_PERSISTENCE_ROOM_TEST =
        "androidx.room:room-testing:${Versions.ANDROIDX_PERSISTENCE}" // Test helpers
    const val ANDROIDX_TEST_RUNNER = "androidx.test:runner:${Versions.ANDROIDX_TEST}"
    const val ANDROIDX_TEST_RULES = "androidx.test:rules:${Versions.ANDROIDX_TEST}"

    const val OKHTTP = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP}"
    const val OKHTTP_LOGGING_INTERCEPTOR =
        "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"
    const val OKHTTP_MOCKWEBSERVER = "com.squareup.okhttp3:mockwebserver:${Versions.OKHTTP}"
    const val RETROFIT_CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
    const val MOSHI = "com.squareup.moshi:moshi:${Versions.MOSHI}"
    const val MOSHI_KOTLIN = "com.squareup.moshi:moshi-kotlin:${Versions.MOSHI}"
    const val WIRERE_MOKE = "com.github.tomakehurst:wiremock:${Versions.WIRERE_MOKE}"
    const val KOTLIN_STD_LIB = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.KOTLIN}"
    const val KOTLIN_COROUTINES =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.KOTLIN_COROUTINES}"
    const val KOTLIN_COROUTINES_ANDROID =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.KOTLIN_COROUTINES}"
    const val RETROFIT_COROUTINES_ADAPTER =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.RETROFIT_COROUTINES_ADAPTER}"
    const val KOTLIN_REFLECT = "org.jetbrains.kotlin:kotlin-reflect:${Versions.KOTLIN}"
    const val COROUTINES =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.KOTLIN_COROUTINES}"
    const val COROUTINES_ANDROID =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.KOTLIN_COROUTINES}"
    const val APACHE_HTTP_CLIENT_ANDROID = "org.apache.httpcomponents:httpclient-android:4.3.5.1"

    const val TIMBER = "com.jakewharton.timber:timber:${Versions.TIMBER}"
    const val STETHO = "com.facebook.stetho:stetho:${Versions.STETHO}"
    const val STETHO_OKHTTP3 = "com.facebook.stetho:stetho-okhttp3:${Versions.STETHO}"
    const val APACHE_COMMONS = "commons-io:commons-io:${Versions.APACHE_COMMONS}"
    const val ANDROID_DEBUG_DATABASE =
        "com.amitshekhar.android:debug-db:${Versions.ANDROID_DEBUG_DATABASE}"

}

object TestLibs {
    const val RUNNER = "com.android.support.test:runner:${Versions.TEST_SUPPORT_LIB}"
    const val ORCHESTRATOR = "com.android.support.test:orchestrator:${Versions.TEST_SUPPORT_LIB}"
    const val ESPRESSO_CORE = "com.android.support.test.espresso:espresso-core:${Versions.ESPRESSO}"
    const val ESPRESSO_CONTRIB =
        "com.android.support.test.espresso:espresso-contrib:${Versions.ESPRESSO}"
    const val ANDROID_TEST_RUNNER = "com.android.support.test:runner:${Versions.TEST_SUPPORT_LIB}"
    const val TEST_RULES = "com.android.support.test:rules:${Versions.TEST_SUPPORT_LIB}"
    const val JUNIT = "junit:junit:${Versions.JUNIT}"
    const val JUNIT_EXT = "androidx.test.ext:junit:${Versions.JUNIT_EXT}"
    const val ASSERTJ = "org.assertj:assertj-core:${Versions.ASSERTJ}"
}

object GradlePlugins {
    const val ANDROID = "com.android.tools.build:gradle:${Versions.ANDROID_GRADLE_PLUGIN}"
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
}