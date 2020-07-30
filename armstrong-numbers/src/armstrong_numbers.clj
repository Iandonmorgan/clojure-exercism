(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num]
      (loop [x (count (str num))
             acc 0]
        (if (>= 0 x)
          (= num acc)
          (recur (dec x) (+ acc (exp (Integer/parseInt (apply str (list (nth (str num) (- x 1))))) (count (str num)))))
          )
        )
)
