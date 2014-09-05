(defproject comment "0.1.0-SNAPSHOT"
  :description "Small app to comment on a GitHub pull request with Clojure"
  :url "https://github.com/everett-toews/comment-github-clj"
  :license {:name "Apache License, Version 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [log4j "1.2.13"]
                 [org.slf4j/slf4j-log4j12 "1.6.4"]
                 [tentacles "0.2.6"]]
  :main ^:skip-aot comment.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
