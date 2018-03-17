package jp.tinyport.gradle.versioning

import org.gradle.api.tasks.TaskAction

class ShowVersionTask extends AbstractVersioningTask {
    int getVersionCode() {
        appVersion.versionCode
    }

    String getVersionName() {
        appVersion.versionName
    }

    @TaskAction
    void showVersion() {
        def version = appVersion
        logger.quiet("versionName=${version == null ? 'N/A' : version}\n" +
                "  - major=${version == null ? 'N/A' : version.major}\n" +
                "  - brahch=${version == null ? 'N/A' : version.branch}\n" +
                "  - minor=${version == null ? 'N/A' : version.minor}\n" +
                "  - revision=${version == null ? 'N/A' : version.revision}\n" +
                "versionCode=${version == null ? 'N/A' : version.versionCode}")
    }
}
