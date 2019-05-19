(ns cipher.core)

(defn to-int [char]
  (- (int char) (int \a)))


(defn to-char [i]
  (char (+ i 97)))


(defn shift [c n o]
  (to-char (mod (o (to-int c) n) 26)))


#_(defn unshift [c n]
    (to-char (mod (- (to-int c) n) 26)))


#_(defn caesar-encrypt [banana n]
    (clojure.string/join (mapv #(shift % n +) (seq banana))))


(defn caesar-encrypt [banana n]
  (->> banana
       seq
       (mapv #(shift % n +))
       clojure.string/join))

(defn caesar-decrypt [banana n]
  (clojure.string/join (mapv #(shift % n -) (seq banana))))


#_(defn caesar-decrypt [banana n]
   (clojure.string/join (mapv #(unshift % n) (seq banana))))
