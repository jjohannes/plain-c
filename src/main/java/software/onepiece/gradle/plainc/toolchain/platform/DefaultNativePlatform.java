package software.onepiece.gradle.plainc.toolchain.platform;

import org.gradle.api.NonNullApi;
import org.gradle.nativeplatform.platform.NativePlatform;
import org.gradle.nativeplatform.platform.internal.ArchitectureInternal;
import org.gradle.nativeplatform.platform.internal.NativePlatformInternal;
import org.gradle.nativeplatform.platform.internal.OperatingSystemInternal;

@NonNullApi
public class DefaultNativePlatform implements NativePlatform, NativePlatformInternal {

    public static final DefaultNativePlatform DEFAULT = new DefaultNativePlatform();

    @Override
    public String getName() {
        return "default_platform";
    }

    @Override
    public String getDisplayName() {
        return getName();
    }

    @Override
    public ArchitectureInternal getArchitecture() {
        return DefaultArchitecture.DEFAULT;
    }

    @Override
    public OperatingSystemInternal getOperatingSystem() {
        return DefaultOperatingSystem.DEFAULT;
    }

    @Override
    public void operatingSystem(String s) { }

    @Override
    public void architecture(String s) { }
}
