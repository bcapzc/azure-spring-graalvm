package com.azure.spring.experimental;

import com.oracle.svm.core.annotate.AutomaticFeature;
import org.graalvm.nativeimage.hosted.Feature;
import org.graalvm.nativeimage.hosted.RuntimeReflection;

@AutomaticFeature
public class TestGraalVMFeature implements Feature {

    @Override
    public void beforeAnalysis(final BeforeAnalysisAccess access) {
        System.out.println("==================================");
        System.out.println("In GraalVM Feature: beforeAnalysis");
        System.out.println("==================================");
        Feature.super.beforeAnalysis(access);
        // access.findClassByName();
    }

    // @Override
    // public void duringAnalysis(DuringAnalysisAccess access) {
    //     System.out.println("==================================");
    //     System.out.println("In GraalVM Feature: duringAnalysis");
    //     Feature.super.duringAnalysis(access);
    //     System.out.println("getApplicationModulePath");
    //     System.out.println(access.getApplicationModulePath());
    //     System.out.println("==================================");
    // }
    //
    // @Override
    // public void afterAnalysis(AfterAnalysisAccess access) {
    //     System.out.println("=================================");
    //     System.out.println("In GraalVM Feature: afterAnalysis");
    //     Feature.super.afterAnalysis(access);
    //     System.out.println("=================================");
    // }
}
