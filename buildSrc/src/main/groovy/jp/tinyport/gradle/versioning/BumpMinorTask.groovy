package jp.tinyport.gradle.versioning

import org.gradle.api.tasks.TaskAction

class BumpMinorTask extends AbstractVersioningTask {
    @TaskAction
    void bumpMinor() {
        appVersion.minor++
        appVersion.saveAppVersion(project)
    }
}
