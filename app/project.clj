(defproject nanit-onboarding "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [http-kit "2.5.3"]
                 [compojure "1.7.0"]
                 [ring/ring-core "1.8.0"]
                 [ring/ring-json "0.5.0"]
                 [ring/ring-mock "0.4.0"]
                 [org.clojure/data.json "0.2.7"]
                 [com.github.seancorfield/honeysql "2.2.891"]
                 [com.github.seancorfield/next.jdbc "1.2.780"]
                 [org.postgresql/postgresql "42.1.3"]]
  :main ^:skip-aot nanit-onboarding.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
