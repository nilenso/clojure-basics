(ns repl-debugging.core
  (:require [ring.adapter.jetty :as raj]
            [repl-debugging.handler :as handler])
  (:gen-class))

(defonce server (atom nil))

(defn- start-server []
  (reset! server (raj/run-jetty handler/ring-handler
                                {:port 3000 :join? false})))

(defn- stop-server []
  (when @server (.stop @server))
  (reset! server nil))

(defn- restart-server []
  (stop-server)
  (start-server))

(defn -main []
  (start-server))
