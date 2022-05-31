(ns nanit-onboarding.web.router
    (:require [compojure.core :refer [defroutes GET POST]]
              [nanit-onboarding.models.post :as post]
      [ring.middleware
       [json :refer [wrap-json-params wrap-json-response]]
       [content-type :refer [wrap-content-type]]
       [keyword-params :refer [wrap-keyword-params]]
       [params :refer [wrap-params]]
       ]))

(defroutes all-routes
           (GET "/ping" []
                {:status 200
                 :headers {"Content-Type" "text/html"}
                 :body "pong"})
           (POST "/posts" req
             {:status  200
              :headers {"Content-Type" "text/html"}
              :body    (post/create (:params req))}
             )
           (GET "/posts" []
             {:status  200
              :headers {"Content-Type" "application/json"}
              :body    (post/select-all)}
             ))

(def app
  (-> all-routes
      wrap-content-type
      wrap-keyword-params
      wrap-params
      wrap-json-params
      wrap-json-response))

