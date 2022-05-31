(ns nanit-onboarding.models.post
  (:require [honeysql-postgres.helpers :refer [returning]]
            [honeysql.core :as sql]
            [honeysql.helpers :refer [from insert-into limit order-by select values]]
            [nanit-onboarding.db.core :as db]
            ))

(def ^:private allowed-create-keys #{:title :content})
(def table-name :posts)


(defn create
  ([params]
   (create params nil))
  ([params connection]
   (let [post (-> params
                  (select-keys allowed-create-keys))
         created-post (-> (insert-into table-name)
                          (values [post])
                          (returning :*)
                          sql/format
                          (db/execute-one! connection))]
     created-post)))

(defn count*
  ([]
   (:post :count (-> (select :%count.*)
                                 (from table-name)
                                 sql/format
                                 db/execute-one!
                                 :count))))