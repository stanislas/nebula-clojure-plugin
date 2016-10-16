/*-
 * Copyright 2009-2015 © Meikel Brandmeyer.
 * All rights reserved.
 *
 * Licensed under the EUPL V.1.1 (cf. file EUPL-1.1 distributed with the
 * source code.) Translations in other european languages available at
 * https://joinup.ec.europa.eu/software/page/eupl.
 *
 * Alternatively, you may choose to use the software under the MIT license
 * (cf. file MIT distributed with the source code).
 */

package nebula.plugin.clojuresque

import org.gradle.api.Project

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class ClojurePluginDeprecatedConvention {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClojurePluginConvention)
    private final Project project

    public ClojurePluginDeprecatedConvention(Project project) {
        this.project = project
    }

    public void setCompileMode(String f) {
        Util.deprecationWarning(LOGGER, "compileMode", "clojure.compileMode")
        project.clojure.compileMode = f
    }

    public boolean getCompileMode() {
        Util.deprecationWarning(LOGGER, "compileMode", "clojure.compileMode")
        return project.clojure.compileMode
    }

    public void setWarnOnReflection(boolean f) {
        Util.deprecationWarning(LOGGER, "warnOnReflection", "clojure.warnOnReflection")
        project.clojure.warnOnReflection = f
    }

    public boolean getWarnOnReflection() {
        Util.deprecationWarning(LOGGER, "warnOnReflection", "clojure.warnOnReflection")
        return project.clojure.warnOnReflection
    }
}
