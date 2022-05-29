(ns nanit-onboarding.core
    (:require [org.httpkit.server :refer [run-server]]
      [nanit-onboarding.web.router :refer [all-routes]])
    (:gen-class))

(defn -main
      [& args]
      (run-server all-routes {:port 8080}))

