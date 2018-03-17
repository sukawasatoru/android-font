package jp.tinyport.gradle.versioning

import org.gradle.api.Plugin
import org.gradle.api.Project

class VersioningPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.extensions.create('versioning', VersioningPluginExtension, project)

        project.task('appVersion', type: ShowVersionTask)
        project.task('setVersion', type: SetAppVersionTask)
        project.task('bumpMajor', type: BumpMajorTask)
        project.task('bumpBranch', type: BumpBranchTask)
        project.task('bumpMinor', type: BumpMinorTask)
        project.task('bumpRevision', type: BumpRevisionTask)
    }
}
