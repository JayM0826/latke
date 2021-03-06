/*
 * Copyright (c) 2009-2018, b3log.org & hacpai.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.b3log.latke.ioc.main;

import java.util.Arrays;
import java.util.List;
import org.b3log.latke.ioc.bean.LatkeBean;
import org.b3log.latke.ioc.LatkeBeanManager;
import org.b3log.latke.ioc.LatkeBeanManagerImpl;
import org.b3log.latke.ioc.Lifecycle;
import org.b3log.latke.ioc.inject.Inject;
import org.b3log.latke.ioc.inject.Named;

@Named("Main")
public class Main {

    @Inject
    DependencyA dependencyA;

    /**
     * Classes package.
     */
    public static final List<Class<?>> packageClasses =
            Arrays.<Class<?>>asList(Main.class, DependencyA.class);

    public static final void main(String[] args) {
        Lifecycle.startApplication(packageClasses);

        final LatkeBeanManager beanManager = LatkeBeanManagerImpl.getInstance();

        final LatkeBean bean = beanManager.getBean(Main.class);
        final Main main = (Main) beanManager.getReference(bean);

        main.dependencyA.method1();
    }
}
