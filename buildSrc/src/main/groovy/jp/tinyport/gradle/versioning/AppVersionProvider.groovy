package jp.tinyport.gradle.versioning

import org.gradle.api.Project
import org.gradle.api.provider.PropertyState
import org.gradle.api.provider.Provider

class AppVersionProvider implements PropertyState<AppVersion> {
    private final Project project

    private AppVersion appVersion

    AppVersionProvider(Project project) {
        this.project = project
    }

    @Override
    void set(AppVersion appVersion) {
        this.appVersion = appVersion
    }

    @Override
    void set(Provider<? extends AppVersion> provider) {
        appVersion = provider.getOrNull()
    }

    @Override
    AppVersion get() {
        return appVersion ?: AppVersion.loadAppVersion(project)
    }

    @Override
    AppVersion getOrNull() {
        return appVersion
    }

    @Override
    boolean isPresent() {
        return appVersion != null
    }
}
