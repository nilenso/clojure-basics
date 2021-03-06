(defproject repl-debugging "0.1.0-SNAPSHOT"
  :url "https://github.com/nilenso/clojure-basics"
  :license {:name "Unlicense"
            :url  "https://unlicense.org/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [ring "1.8.1"] ; github.com/ring-clojure/ring
                 [bidi "2.1.6"] ; github.com/juxt/bidi

                 [cheshire "5.10.0"]

                 [seancorfield/next.jdbc "1.1.547"]
                 [org.postgresql/postgresql "42.2.14"]

                 [ring/ring-json "0.5.0"]]
  :repl-options {:init-ns repl-debugging.core}
  :main repl-debugging.core)
