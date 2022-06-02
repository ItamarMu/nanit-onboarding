(ns nanit-onboarding.core
    (:require [org.httpkit.server :refer [run-server]]
      [nanit-onboarding.web.router :refer [app]])
    (:gen-class))

(defn -main
      [& args]
      (run-server app {:port 3000}))

