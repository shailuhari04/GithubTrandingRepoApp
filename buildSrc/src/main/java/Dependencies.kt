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
    const val RETROFIT_COROUTINES_ADAPTER = "0.9.2"

    const val OKHTTP = "3.10.0"
    const val GLIDE = "4.9.0"
    const val JUNIT = "4.12"
    const val JUNIT_EXT = "1.1.0"
    const val MOCKITO_HELPER = "1.6.0"
    const val MOCKITO = "3.2.0"
    const val MOSHI = "1.6.0"

    //koin(DI)
    const val KOIN = "1.0.2"
    const val KOIN_ARCHITECTURE = "0.9.3"

    // androidX
    const val ANDROIDX = "1.0.0"
    const val MAERIAL_DESIGN = "1.2.0-alpha04"
    const val ANDROIDX_LIFECYCLE = "2.0.0"
    const val ANDROIDX_PERSISTENCE = "2.2.0-alpha01"
    const val ANDROIDX_TEST = "1.1.0"
    const val ANDROIDX_CONSTRAINTLAYOUT = "1.1.3"
    const val ANDROIDX_VIEWMODEL_KTX = "2.1.0"


    const val ANDROID_GRADLE_PLUGIN = "3.5.3"
    const val ESPRESSO = "3.1.0"


    const val ASSERTJ = "3.11.1"
    const val ANDROID_DEBUG_DATABASE = "1.0.6"

    //simmerLayout
    const val SIMMERLAYOUT = "2.1.0"
}

object Libs {

    //GLIDE(IMAGE LOADING)
    const val GLIDE = "com.github.bumptech.glide:glide:${Versions.GLIDE}"


    //DI(Koin)
    const val KOIN_CORE = "org.koin:koin-core:${Versions.KOIN}"
    const val KOIN_ANDROID = "org.koin:koin-android:${Versions.KOIN}"
    const val KOIN_VIEWMODEL = "org.koin:koin-androidx-viewmodel:${Versions.KOIN}"
    const val KOIN_TEST = "org.koin:koin-test:${Versions.KOIN}"
    const val KOIN_SCOPE = "org.koin:koin-android-scope:${Versions.KOIN}"
    const val KOIN_ARCHITECTURE = "org.koin:koin-android-architecture:${Versions.KOIN_ARCHITECTURE}"

    //AndroidX
    const val ANDROIDX_MATERIAL = "com.google.android.material:material:${Versions.MAERIAL_DESIGN}"
    const val ANDROIDX_RECYCLERVIEW = "androidx.recyclerview:recyclerview:${Versions.ANDROIDX}"
    const val ANDROIDX_APPCOMPAT_V7 = "androidx.appcompat:appcompat:${Versions.ANDROIDX}"
    const val ANDROIDX_SUPPORT_V4 = "androidx.legacy:legacy-support-v4:${Versions.ANDROIDX}"
    const val androidx_annotations = "androidx.annotation:annotation:${Versions.ANDROIDX}"
    const val ANDROIDX_CONSTRAINTLAYOUT =
        "androidx.constraintlayout:constraintlayout:${Versions.ANDROIDX_CONSTRAINTLAYOUT}"

    //ARCHITECTURE COMPONENTS
    const val ANDROIDX_PERSISTENCE_ROOM_RUNTIME =
        "androidx.room:room-runtime:${Versions.ANDROIDX_PERSISTENCE}" // Room
    const val ANDROIDX_PERSISTENCE_ROOM_KAPT =
        "androidx.room:room-compiler:${Versions.ANDROIDX_PERSISTENCE}" // Annotation Processor
    const val ANDROIDX_LIFECYCLE_LIVEDATA_CORE =
        "androidx.lifecycle:lifecycle-livedata-core:${Versions.ANDROIDX_LIFECYCLE}"
    const val ANDROIDX_LIFECYCLE_COMPILER =
        "androidx.lifecycle:lifecycle-compiler:${Versions.ANDROIDX_LIFECYCLE}"
    const val ANDROIDX_LIFECYCLE_VIEWMODEL_KTX =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.ANDROIDX_VIEWMODEL_KTX}"
    const val ANDROIDX_LIFECYCLE_EXT =
        "androidx.lifecycle:lifecycle-extensions:${Versions.ANDROIDX_VIEWMODEL_KTX}"
    const val ANDROIDX_PERSISTENCE_ROOM_KTX =
        "androidx.room:room-ktx:${Versions.ANDROIDX_PERSISTENCE}" // optional - Kotlin Extensions and Coroutines support for Room

    //NETWORKING
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val RETROFIT_MOSHI_CONVERTER =
        "com.squareup.retrofit2:converter-moshi:${Versions.RETROFIT}"
    const val OKHTTP = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP}"
    const val OKHTTP_LOGGING_INTERCEPTOR =
        "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"
    const val OKHTTP_MOCKWEBSERVER = "com.squareup.okhttp3:mockwebserver:${Versions.OKHTTP}"
    const val MOSHI = "com.squareup.moshi:moshi:${Versions.MOSHI}"
    const val MOSHI_KOTLIN = "com.squareup.moshi:moshi-kotlin:${Versions.MOSHI}"
    const val RETROFIT_COROUTINES_ADAPTER =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.RETROFIT_COROUTINES_ADAPTER}"

    //KOTLIN STDLIBS AND COROUTINES
    const val KOTLIN_STD_LIB = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.KOTLIN}"
    const val KOTLIN_COROUTINES =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.KOTLIN_COROUTINES}"
    const val KOTLIN_COROUTINES_ANDROID =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.KOTLIN_COROUTINES}"
    const val COROUTINES =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.KOTLIN_COROUTINES}"
    const val COROUTINES_ANDROID =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.KOTLIN_COROUTINES}"


    //SHIMMER LAYOUT
    const val SIMMERLAYOUT =
        "io.supercharge:shimmerlayout:${Versions.SIMMERLAYOUT}"

}

object TestLibs {
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
    const val ESPRESSO_CONTRIB =
        "androidx.test.espresso:espresso-contrib:${Versions.ESPRESSO}"
    const val ANDROIDX_TEST_RUNNER = "androidx.test:runner:${Versions.ANDROIDX_TEST}"
    const val ANDROIDX_TEST_RULES = "androidx.test:rules:${Versions.ANDROIDX_TEST}"
    const val JUNIT = "junit:junit:${Versions.JUNIT}"
    const val JUNIT_EXT = "androidx.test.ext:junit:${Versions.JUNIT_EXT}"
    const val ASSERTJ = "org.assertj:assertj-core:${Versions.ASSERTJ}"
    const val ANDROIDX_PERSISTENCE_ROOM_TEST =
        "androidx.room:room-testing:${Versions.ANDROIDX_PERSISTENCE}" // Test helpers
    const val TEST_CORE = "androidx.test:core:${Versions.ANDROIDX_TEST}"
    const val MOCKITO_HELPER = "com.nhaarman:mockito-kotlin:${Versions.MOCKITO_HELPER}"
    const val MOCKITO = "org.mockito:mockito-android:${Versions.MOCKITO}"
    const val COROUTINES_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.KOTLIN_COROUTINES}"
    const val ANDROIDX_ARCH_CORE_TEST = "androidx.arch.core:core-testing:${Versions.ANDROIDX_VIEWMODEL_KTX}"
}

object GradlePlugins {
    const val ANDROID = "com.android.tools.build:gradle:${Versions.ANDROID_GRADLE_PLUGIN}"
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
}