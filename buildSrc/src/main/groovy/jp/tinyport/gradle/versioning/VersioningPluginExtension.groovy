package jp.tinyport.gradle.versioning

import org.gradle.api.Project
import org.gradle.api.provider.PropertyState

class VersioningPluginExtension {
    final PropertyState<AppVersion> appVersion

    VersioningPluginExtension(Project project) {
        appVersion = new AppVersionProvider(project)
    }
}
