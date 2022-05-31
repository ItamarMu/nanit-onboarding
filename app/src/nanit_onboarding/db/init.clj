(ns nanit-onboarding.db.init
    (:require [next.jdbc :as jdbc]))

(def ^:private db-spec {:dbtype "postgres" :dbname "db1" :user "user1" :password "example" :host "localhost"})

(def pool (jdbc/get-datasource db-spec))