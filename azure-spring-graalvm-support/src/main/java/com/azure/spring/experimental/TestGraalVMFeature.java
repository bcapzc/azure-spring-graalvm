package com.azure.spring.experimental;

import com.oracle.svm.core.annotate.AutomaticFeature;
import org.graalvm.nativeimage.hosted.Feature;
import org.graalvm.nativeimage.hosted.RuntimeReflection;

@AutomaticFeature
public class TestGraalVMFeature implements Feature {

    @Override
    public void beforeAnalysis(final BeforeAnalysisAccess access) {
        Feature.super.beforeAnalysis(access);
        System.out.println("==================================");
        System.out.println("In GraalVM Feature: beforeAnalysis");
        System.out.println("==================================");
        // access.findClassByName();
    }

    @Override
    public void afterRegistration(AfterRegistrationAccess access) {
        Feature.super.afterRegistration(access);
        System.out.println("=====================================");
        System.out.println("In GraalVM Feature: afterRegistration");
        System.out.println("=====================================");
    }

    @Override
    public void duringSetup(DuringSetupAccess access) {
        Feature.super.duringSetup(access);
        System.out.println("===============================");
        System.out.println("In GraalVM Feature: duringSetup");
        System.out.println("===============================");
    }

    @Override
    public void duringAnalysis(DuringAnalysisAccess access) {
        Feature.super.duringAnalysis(access);
        System.out.println("==================================");
        System.out.println("In GraalVM Feature: duringAnalysis");
        System.out.println("==================================");
    }

    @Override
    public void afterAnalysis(AfterAnalysisAccess access) {
        Feature.super.afterAnalysis(access);
        System.out.println("=================================");
        System.out.println("In GraalVM Feature: afterAnalysis");
        System.out.println("=================================");
    }

    @Override
    public void onAnalysisExit(OnAnalysisExitAccess access) {
        Feature.super.onAnalysisExit(access);
        System.out.println("==================================");
        System.out.println("In GraalVM Feature: onAnalysisExit");
        System.out.println("==================================");
    }

    @Override
    public void beforeUniverseBuilding(BeforeUniverseBuildingAccess access) {
        Feature.super.beforeUniverseBuilding(access);
        System.out.println("==========================================");
        System.out.println("In GraalVM Feature: beforeUniverseBuilding");
        System.out.println("==========================================");
    }

    @Override
    public void beforeCompilation(BeforeCompilationAccess access) {
        Feature.super.beforeCompilation(access);
        System.out.println("=====================================");
        System.out.println("In GraalVM Feature: beforeCompilation");
        System.out.println("=====================================");
    }

    @Override
    public void afterCompilation(AfterCompilationAccess access) {
        Feature.super.afterCompilation(access);
        System.out.println("====================================");
        System.out.println("In GraalVM Feature: afterCompilation");
        System.out.println("====================================");
    }

    @Override
    public void afterHeapLayout(AfterHeapLayoutAccess access) {
        Feature.super.afterHeapLayout(access);
        System.out.println("===================================");
        System.out.println("In GraalVM Feature: afterHeapLayout");
        System.out.println("===================================");
    }

    @Override
    public void beforeImageWrite(BeforeImageWriteAccess access) {
        Feature.super.beforeImageWrite(access);
        System.out.println("====================================");
        System.out.println("In GraalVM Feature: beforeImageWrite");
        System.out.println("====================================");
    }

    @Override
    public void afterImageWrite(AfterImageWriteAccess access) {
        Feature.super.afterImageWrite(access);
        System.out.println("===================================");
        System.out.println("In GraalVM Feature: afterImageWrite");
        System.out.println("===================================");
    }

    @Override
    public void cleanup() {
        Feature.super.cleanup();
        System.out.println("===========================");
        System.out.println("In GraalVM Feature: cleanup");
        System.out.println("===========================");
    }
}
