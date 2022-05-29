(ns nanit-onboarding.core
    (:require [org.httpkit.server :refer [run-server]]
      [nanit-onboarding.web.router :refer [all-routes]])
    (:gen-class))

(defn app [req]
      {:status  200
       :headers {"Content-Type" "text/html"}
       :body    "hello HTTP!"})

;(run-server app {:port 8080})

(defn -main
      [& args]
      (run-server all-routes {:port 8080}))

