plugins {
    alias(libs.plugins.cashsense.android.library)
    alias(libs.plugins.cashsense.android.hilt)
}

android {
    namespace = "ru.resodostudios.cashsense.core.notifications"
}

dependencies {
    api(projects.core.model)

    implementation(projects.core.common)

    compileOnly(platform(libs.androidx.compose.bom))
    compileOnly(libs.androidx.compose.runtime)
}
