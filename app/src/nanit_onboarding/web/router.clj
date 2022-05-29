(ns nanit-onboarding.web.router
    (:require [compojure.core :refer [defroutes GET POST DELETE ANY context]]))

(defroutes all-routes
           (GET "/ping" [] {:body "pong"}))