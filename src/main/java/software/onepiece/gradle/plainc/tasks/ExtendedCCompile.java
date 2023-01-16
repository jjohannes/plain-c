package software.onepiece.gradle.plainc.tasks;

import org.gradle.api.provider.MapProperty;
import org.gradle.api.tasks.CacheableTask;
import org.gradle.api.tasks.Input;
import org.gradle.language.c.tasks.CCompile;
import org.gradle.nativeplatform.toolchain.internal.NativeCompileSpec;

import java.util.List;

@CacheableTask
public abstract class ExtendedCCompile extends CCompile {

    @Input
    public abstract MapProperty<String, List<String>> getPerFileCompilerArgs();

    @Override
    protected NativeCompileSpec createCompileSpec() {
        return new ExtendedCCompileSpec();
    }

    @Override
    protected void configureSpec(NativeCompileSpec spec) {
        super.configureSpec(spec);
        ExtendedCCompileSpec extendedCCompileSpec = (ExtendedCCompileSpec) spec;
        extendedCCompileSpec.getPerFileCompilerArgs().putAll(getPerFileCompilerArgs().get());
    }
}
