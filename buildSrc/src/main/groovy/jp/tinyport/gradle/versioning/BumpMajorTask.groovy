package jp.tinyport.gradle.versioning

import org.gradle.api.tasks.TaskAction

class BumpMajorTask extends AbstractVersioningTask {
    @TaskAction
    void bumpMajor() {
        appVersion.major++
        appVersion.saveAppVersion(project)
    }
}
