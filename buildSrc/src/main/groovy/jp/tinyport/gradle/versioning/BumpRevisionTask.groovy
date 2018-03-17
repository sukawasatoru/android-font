package jp.tinyport.gradle.versioning

import org.gradle.api.tasks.TaskAction

class BumpRevisionTask extends AbstractVersioningTask {
    @TaskAction
    void bumpRevision() {
        appVersion.revision++
        appVersion.saveAppVersion(project)
    }
}
