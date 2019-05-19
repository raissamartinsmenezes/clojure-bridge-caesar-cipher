(ns cipher.core-test
  (:require [clojure.test :refer :all]
            [cipher.core :as cipher]))

(deftest test-to-int
  (is (= 0 (cipher/to-int \a)))
  (is (= 1 (cipher/to-int \b))))


(deftest test-to-char
  (is (= \a (cipher/to-char 0)))
  (is (= \b (cipher/to-char 1))))


(deftest test-shift
  (is (= (cipher/shift \a 1 +) \b))
  (is (= (cipher/shift \z 1 +) \a))
  (is (= (cipher/shift \x 3 +) \a))
  (is (= (cipher/shift \b 1 -) \a))
  (is (= (cipher/shift \a 1 -) \z))
  (is (= (cipher/shift \a 3 -) \x)))


(deftest test-caesar-encrypt
  (is (= (cipher/caesar-encrypt "apple" 20) "ujjfy")))


(deftest test-caesar-decrypt
  (is (= (cipher/caesar-decrypt "ujjfy" 20) "apple")))
