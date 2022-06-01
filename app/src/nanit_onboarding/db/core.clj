(ns nanit-onboarding.db.core
  (:require [nanit-onboarding.db.init :as db-config]
            [next.jdbc :as jdbc]
            [next.jdbc.result-set :as rs]))

(def ^:private opts {:builder-fn rs/as-unqualified-lower-maps})

(defn execute!
  ([q] (jdbc/execute! db-config/pool q opts))
  ([q tx] (jdbc/execute! (or tx db-config/pool) q opts)))

(defn execute-one!
  ([q] (jdbc/execute-one! db-config/pool q opts))
  ([q tx] (jdbc/execute-one! (or tx db-config/pool) q opts)))