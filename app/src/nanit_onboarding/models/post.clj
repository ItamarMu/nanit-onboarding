(ns nanit-onboarding.models.post
  (:require [honey.sql :as sql]
            [honey.sql.helpers :refer [returning from insert-into select values where]]
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
  []
  (-> (select :%count.*)
      (from table-name)
      sql/format
      db/execute-one!
      :count))

(defn select-all
  []
  (-> (from table-name)
      (select :*)
      sql/format
      db/execute!))

(defn upvote [id]
  (let [parsed-id (Integer. id)]
    (when-let [post (-> (select :*)
                        (from table-name)
                        (where [:= :id parsed-id])
                        sql/format
                        db/execute-one!)]
      (-> (honey.sql.helpers/update table-name)
          (honey.sql.helpers/set {:upvotes (inc (:upvotes post))})
          (where [:= :id parsed-id])
          sql/format
          db/execute-one!))))