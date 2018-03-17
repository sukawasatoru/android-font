package jp.tinyport.gradle.versioning

import org.gradle.api.tasks.TaskAction

class BumpBranchTask extends AbstractVersioningTask {
    @TaskAction
    void bumpBranch() {
        appVersion.branch++
        appVersion.saveAppVersion(project)
    }
}
