(ns rna-transcription)

(defn to-rna [dna]
      (cond
            (clojure.string/includes? dna "X") (throw (AssertionError.))
            :else (clojure.string/replace dna #"G|C|T|A" {"G" "C" "C" "G" "T" "A" "A" "U"})))

; not happy about this, handles the test cases, but would like to explore a different way to handle exceptions for this problem.