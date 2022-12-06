package software.onepiece.gradle.plainc.toolchain.platform;

import org.gradle.api.NonNullApi;
import org.gradle.nativeplatform.platform.Architecture;
import org.gradle.nativeplatform.platform.internal.ArchitectureInternal;

@NonNullApi
public class DefaultArchitecture implements Architecture, ArchitectureInternal {

    public static final DefaultArchitecture DEFAULT = new DefaultArchitecture();

    @Override
    public String getName() {
        return "default_arch";
    }

    @Override
    public String getDisplayName() {
        return getName();
    }

    @Override
    public boolean isI386() {
        return false;
    }

    @Override
    public boolean isAmd64() {
        return false;
    }

    @Override
    public boolean isIa64() {
        return false;
    }

    @Override
    public boolean isArm() {
        return false;
    }
}
