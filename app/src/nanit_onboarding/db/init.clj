(ns nanit-onboarding.db.init
    (:require [next.jdbc :as jdbc]))

(def ^:private db-spec {:dbtype "postgres" :dbname "db1" :user "user1" :password "example" :host (System/getenv "DB_HOST") :port 5432
                        })

(def pool (jdbc/get-datasource db-spec))