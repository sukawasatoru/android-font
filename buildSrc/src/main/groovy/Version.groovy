class Version {
    static final arch = new Arch()
    static final errorprone = '2.2.0'
    static final dagger = '2.14.1'
    static final gradle = new Gradle()
    static final glide = '4.5.0'
    static final kotlin = '1.2.20'
    static final leakcanary = '1.5.1'
    static final manifest = new Manifest()
    static final orma = '4.2.5'
    static final rx = new Rx()
    static final support = new Support()

    static class Arch {
        final live = '1.1.0'
    }

    static class Gradle {
        final android = '3.0.1'
        final androidCacheFix = '0.3.6'
        final errorprone = '0.0.13'
    }

    static class Manifest {
        final compileSdk = 27
        final buildTools = '27.0.3'
        final minSdk = 21
        final targetSdk = 27
    }

    static class Rx {
        final java = '2.1.8'
        final android = '2.0.1'
    }

    static class Support {
        final support = '27.0.2'
        final constraint = '1.0.2'
    }
}
