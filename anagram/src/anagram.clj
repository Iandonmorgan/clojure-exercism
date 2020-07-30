(ns anagram)

(defn anagrams-for [word prospect-list]
      (let [lower  (clojure.string/lower-case word)
            ws (sort lower)
            match? (fn [prospect]
                           (let [pl (clojure.string/lower-case prospect)]
                                 (and
                                       (not= lower pl)
                                       (= ws (sort pl)))))]
            (filter match? prospect-list)))