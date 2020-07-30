(ns word-count)

(defn word-count [s]
      (let [string (clojure.string/lower-case s)
            strings (re-seq #"[a-zA-Z\d]+" string)
            strings-freq (frequencies strings)
            strings-freq-map (map #(vector (first %) (second %)) strings-freq)]
      (into (sorted-map) strings-freq-map))
      )


; OTHER REALLY CLEAN SOLUTION... NEED TO LOOK INTO HOW I CAN
; THINK LIKE THIS...
;
; (ns word-count
;  (:require [clojure.string :refer [lower-case]]))
;
;(defn word-count [s]
;  (->> s
;       (re-seq #"[A-Za-z0-9]+")
;       (map lower-case)
;       (frequencies)))
;
;