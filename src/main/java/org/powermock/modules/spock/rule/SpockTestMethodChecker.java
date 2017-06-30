/*
 *   Copyright 2016 the original author or authors.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package org.powermock.modules.spock.rule;

import java.lang.reflect.Method;

import org.powermock.modules.junit4.common.internal.impl.JUnit4TestMethodChecker;
import org.spockframework.runtime.model.FeatureMetadata;

/**
 * add test method filtering for spock feature
 * @author qixiang.mft
 */
public class SpockTestMethodChecker extends JUnit4TestMethodChecker {
    private final Class<?> testClass;
    private final Method potentialTestMethod;

    public SpockTestMethodChecker(Class<?> testClass, Method potentialTestMethod) {
        super(testClass,potentialTestMethod);
        this.testClass = testClass;
        this.potentialTestMethod = potentialTestMethod;
    }

    @Override
    public boolean isTestMethod() {
        return isJUnit3TestMethod() || isJUnit4TestMethod() || isSpockFeatureMethod();
    }

    /**
     * 正确判断 spock 中的测试方法
     * @return
     */
    protected boolean isSpockFeatureMethod() {
        return potentialTestMethod.isAnnotationPresent(FeatureMetadata.class);
    }
}
