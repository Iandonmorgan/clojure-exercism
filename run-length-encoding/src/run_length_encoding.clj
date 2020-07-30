(ns run-length-encoding)

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text]
  (clojure.string/join (filter #(not= "1" %)
                               (map str (mapcat #(list (count %) (first %))
                                                (partition-by identity plain-text)))))
  )

;decoding solution from m1kal using re-find function with parenthesized groups in the pattern.
;match returns a vector with ["original string value" "number" "letter" "rest"]
;repetitions grabs the numeric value for number of repetitions, can be empty
;occurences accounts for empty repetitions
;char binds the character from the returned match vector
;remainder binds the remaining portion of the string

(defn parse [string]
  (let [match (re-find #"^(\d*)(.)(.*)" string)
        repetitions (nth match 1)
        occurences (if (empty? repetitions) 1 (read-string repetitions))
        char (nth match 2)
        remainder (nth match 3)
        ]
    [(clojure.string/join (repeat occurences char)) remainder]
    )
  )

(defn run-length-decode
  "decodes a run-length-encoded string"
  [cipher-text]
  (loop [substring cipher-text decoded ""]
    (if (empty? substring)
      decoded
      (let [parsed (parse substring)]
        (recur (last parsed) (str decoded (first parsed)))
        )
      )
    )
  )
