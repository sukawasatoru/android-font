package jp.tinyport.gradle.versioning

import org.gradle.api.DefaultTask
import org.gradle.api.provider.PropertyState

abstract class AbstractVersioningTask extends DefaultTask {
    private final PropertyState<AppVersion> mAppVersion

    AbstractVersioningTask() {
        mAppVersion = project.extensions.getByType(VersioningPluginExtension).appVersion
    }

    AppVersion getAppVersion() {
        mAppVersion.get()
    }

    void setAppVersion(AppVersion newAppVersion) {
        mAppVersion.set(newAppVersion)
    }
}
