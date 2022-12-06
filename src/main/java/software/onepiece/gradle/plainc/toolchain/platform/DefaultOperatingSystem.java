package software.onepiece.gradle.plainc.toolchain.platform;

import org.gradle.api.NonNullApi;
import org.gradle.nativeplatform.platform.OperatingSystem;
import org.gradle.nativeplatform.platform.internal.OperatingSystemInternal;

import javax.annotation.Nullable;

@NonNullApi
public class DefaultOperatingSystem implements OperatingSystem, OperatingSystemInternal {

    public static final DefaultOperatingSystem DEFAULT = new DefaultOperatingSystem();

    @Override
    public String getName() {
        return "default_os";
    }

    @Override
    public String getDisplayName() {
        return getName();
    }

    @Override
    public String toFamilyName() {
        return getName();
    }

    @Override
    public boolean isCurrent() {
        return false;
    }

    @Override
    public boolean isWindows() {
        return false;
    }

    @Override
    public boolean isMacOsX() {
        return false;
    }

    @Override
    public boolean isLinux() {
        return false;
    }

    @Override
    public boolean isSolaris() {
        return false;
    }

    @Override
    public boolean isFreeBSD() {
        return false;
    }

    @Override
    @Nullable
    public org.gradle.internal.os.OperatingSystem getInternalOs() {
        return null;
    }
}
