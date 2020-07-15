(ns scientific-debugging.handler
  (:require [bidi.ring :as br]
            [next.jdbc :as jdbc]
            [next.jdbc.result-set :as rs]
            [ring.middleware.json :refer [wrap-json-response]]
            [ring.util.response :as response]))

(def db-spec {:dbtype "postgresql"
              :dbname "books"
              :host   "localhost"
              :port   5432})

(defn- to-int [s]
  (Integer/parseInt s))

(defn- lookup-book-name-in-db [id]
  (let [ds (jdbc/get-datasource db-spec)]
    (:name (first
             (jdbc/execute! ds
                            ["select * from books where id = ?" id]
                            {:builder-fn rs/as-unqualified-lower-maps})))))

(defn fetch-book-name [{:keys [route-params]}]
  (response/response {:name (-> route-params
                                :id
                                to-int
                                lookup-book-name-in-db)}))

(def routes [["/book-names/" :id] fetch-book-name])

(def ring-handler (-> (br/make-handler routes)
                      wrap-json-response))
