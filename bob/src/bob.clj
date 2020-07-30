(ns bob)

(defn response-for [s]
  (cond
    (= true (= (clojure.string/upper-case s) s) (= (last (clojure.string/trim s)) \?) (not= "" (apply str (filter #(Character/isLetter %) s)))) "Calm down, I know what I'm doing!"
    (= (last (clojure.string/trim s)) \?) "Sure."
    (= "" (clojure.string/trim s)) "Fine. Be that way!"
    (= true (= (clojure.string/upper-case s) s) (not= "" (apply str (filter #(Character/isLetter %) s)))) "Whoa, chill out!"
    :else "Whatever."))
