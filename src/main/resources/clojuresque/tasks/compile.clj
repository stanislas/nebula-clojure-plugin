(ns clojuresque.tasks.compile)

(refer 'clojuresque.util :only '[deftask namespaces])

(deftask main
  [{:keys [compile-mode warn-on-reflection source-files]}]
  (let [mode (condp = compile-mode
               "compile" clojure.core/compile
               "require" clojure.core/require
               "noop" clojure.core/identity
               (throw
                 (Exception. (str "You must choose a mode: compile, require or noop; got " compile-mode))))
        namespaces (namespaces source-files)]
    (binding [*warn-on-reflection* warn-on-reflection
              *compile-path*       (System/getProperty "clojure.compile.path")]
      (doseq [nspace namespaces]
        (mode nspace))))
  true)
