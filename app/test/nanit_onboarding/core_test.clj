(ns nanit-onboarding.core-test
  (:require [clojure.test :refer :all]
            [nanit-onboarding.models.post :as post]
            [nanit-onboarding.core :refer :all]))


(deftest create-post
  (let [count (post/count*)]
    (post/create {:title "welcome" :content "text"})
    (testing "should create new post"
      (is (= (inc count) (post/count*))))))

(deftest select-all
  (let [first-post (first (post/select-all))]
    (is (number? (:id first-post)))))