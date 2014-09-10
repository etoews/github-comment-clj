(ns comment.core
  (:gen-class)
  (:use [clojure.pprint :only (pprint)])
  (:use [environ.core :only (env)])
  (:require
    [tentacles.repos :as repos]
    [tentacles.issues :as issues]))

(defn -main
  "Small app to comment on a GitHub pull request with Clojure.
  Usage: github-comment-clj USERNAME REPO PR_NUMBER COMMENT
  Example: github-comment-clj everett-toews blobstore-save-clj 87 \"Thanks for the PR. We tweeted about it!\""
  [& args]
  ;; Normally we would use clojure.tools.cli to parse-opts but
  ;; that's overkill for this example
  (def username (nth args 0))
  (def repo (nth args 1))
  (def pr-num (nth args 2))
  (def comment (nth args 3))
  (def github-creds {:oauth-token (env :github-oauth-token)})
  (issues/create-comment username repo pr-num comment github-creds))
