package jp.tinyport.gradle.versioning

import org.gradle.api.Project

class AppVersion {
    static final PROPERTY_FILE_NAME = 'version.properties'
    static final KEY_VERSION_CODE = 'version_code'
    static final KEY_VERSION_NAME = 'version_name'

    int major

    void setMajor(int major) {
        if (major < 0 || 125 < major) {
            throw new IllegalAccessError("major=0..125")
        }

        this.major = major
    }

    char branch

    void setBranch(char branch) {
        if (branch < 'A'.toCharacter() || 'Z'.toCharacter() < branch) {
            throw new IllegalArgumentException("branch=A..Z")
        }

        this.branch = branch
    }

    int minor

    void setMinor(int minor) {
        if (minor < 0 || 695 < minor) {
            throw new IllegalArgumentException("minor=0..695")
        }

        this.minor = minor
    }

    int revision

    void setRevision(int revision) {
        if (revision < 0 || 1280 < revision) {
            throw new IllegalArgumentException("revision=0..1280")
        }

        this.revision = revision
    }

    AppVersion(String versionName) {
        def versionList = versionName.split("\\.")

        if (versionList.size() < 4) {
            throw new IllegalArgumentException("version_name=<(0..125).(A..Z).(0..695).(0..1280)>")
        }

        setMajor(versionList[0].toInteger())
        setBranch(versionList[1].toCharacter())
        setMinor(versionList[2].toInteger())
        setRevision(versionList[3].toInteger())
    }

    @Override
    String toString() {
        "$major.$branch.$minor.$revision"
    }

    static def loadAppVersion(Project project) {
        def propFile = loadPropFile(project)
        def prop = new Properties()
        prop.load(propFile.newDataInputStream())
        new AppVersion(prop.getProperty(KEY_VERSION_NAME))
    }

    int getVersionCode() {
        (major << 24) + (minor << 12) + revision
    }

    String getVersionName() {
        toString()
    }

    void saveAppVersion(Project project) {
        def propFile = loadPropFile(project)
        def prop = new Properties()
        prop.load(propFile.newDataInputStream())
        prop.setProperty(KEY_VERSION_CODE, versionCode.toString())
        prop.setProperty(KEY_VERSION_NAME, toString())
        prop.store(propFile.newOutputStream(), null)
    }

    private static def loadPropFile(Project project) {
        def propFile = new File(project.rootDir, PROPERTY_FILE_NAME)
        if (!propFile.exists()) {
            propFile.createNewFile()
        }
        propFile
    }
}
