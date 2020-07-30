(ns isbn-verifier)

(defn isbn-mod-total [i l]
    (loop [multiplier 10
           indx 0
           acc 0]
      (if (= 9 indx)
        (+ acc l)
        (recur (dec multiplier)
               (inc indx)
               (+ acc (* (- (int (get i indx)) 48) multiplier))
               )
        )
      )
  )

(defn isbn? [isbn]
  (let [isbn-vector (into [] (remove #{\-}) isbn)
        isbn-last (if
                    (= \X (last isbn-vector))
                    10
                    (- (int (last isbn-vector)) 48)
                    )]
    (and
      (not= nil (re-matches #"^[xX0-9\-]+$" isbn))
      (= 10 (count isbn-vector))
      (= 0 (mod (isbn-mod-total isbn-vector isbn-last) 11))
      ))
  )
