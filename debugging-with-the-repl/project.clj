(defproject repl-debugging "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [ring "1.8.1"] ; github.com/ring-clojure/ring
                 [bidi "2.1.6"] ; github.com/juxt/bidi

                 [cheshire "5.10.0"]

                 [seancorfield/next.jdbc "1.1.547"]
                 [org.postgresql/postgresql "42.2.14"]

                 [ring/ring-json "0.5.0"]]
  :repl-options {:init-ns repl-debugging.core}
  :main repl-debugging.core)
