(ns oredev2011.test.stm
  (:use [oredev2011.stm :reload :all]
        [clojure.test]))


(deftest transfer-tests
  (testing "Transfer between accounts"
    (let [a (ref [])
          b (ref [])]
      (transfer a b 10 "message")
      (is (= [{:amount -10, :msg "message"}] @a))
      (is (= [{:amount 10, :msg "message"}] @b)))))


(deftest balance-tests
  (testing "Balance for empty account"
    (is (= 0 (balance []))))
  (testing "Balance for account with one entry."
    (let [amt 100]
      (is (= amt (balance [{:amount amt, :msg "Message"}])))))
  (testing "Balance for account with multiple entries should be sum."
    (is (= 300 (balance [{:amount 100, :msg "m1"}, {:amount 200 :msg "m2"}])))))
      
      