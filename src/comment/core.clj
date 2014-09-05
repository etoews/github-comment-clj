(ns comment.core
  (:gen-class)
  (:use [clojure.pprint :only (pprint)])
  (:require
    [clojure.edn :as edn]
    [tentacles.repos :as repos]
    [tentacles.issues :as issues]))

(defn load-github-config
  "Load and return your GitHub configuration.
   Copy github.edn.template to github.edn and edit."
  ([] (load-github-config "resources/github.edn"))
  ([filename]
  (try
    (edn/read-string (slurp filename))
    (catch java.io.FileNotFoundException e
      (throw (java.io.FileNotFoundException.
              (str (.getMessage e) " Copy github.edn.template to github.edn and edit.")))))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (def github-config (load-github-config))
  (def github-creds {:oauth-token (:oauth-token github-config)})
  (issues/create-comment (:username github-config) "pr-to-tweet" 6 "Commenting with #clojure from tentacles" github-creds))
