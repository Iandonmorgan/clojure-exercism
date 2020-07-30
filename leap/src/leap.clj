(ns leap)

(defn ed [year num]
  "Function to determine if year is evenly divisible by number"
    (= java.lang.Long (type (/ year num))))

(defn leap-year? [year]
  "Function to determine if year is a leap year"
  (= true (ed year 4) (= (ed year 100) (ed year 400)))
)
