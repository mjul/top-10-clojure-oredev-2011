(ns oredev2011.test.stm
  (:use [oredev2011.stm :reload :all]
        [clojure.test]))

;; The post function does not care about transactions:
(deftest post-tests
  (testing "Post to empty account"
    (let [actual (post [] 1000 "Initial balance.")]
      (is (= [{:amount 1000, :msg "Initial balance."}]
             actual)))))


(deftest transfer-tests
  (testing "Transfer between accounts"
    (let [a (ref [])
          b (ref [])]
      (transfer a b 170 "Train fare")
      (is (= [{:amount -170, :msg "Train fare"}] @a))
      (is (= [{:amount 170, :msg "Train fare"}] @b)))))


(deftest balance-tests
  (testing "Balance for empty account"
    (is (= 0 (balance []))))
  (testing "Balance for account with one entry."
    (let [amt 100]
      (is (= amt (balance [{:amount amt, :msg "Message"}])))))
  (testing "Balance for account with multiple entries should be sum."
    (is (= 300 (balance [{:amount 100, :msg "m1"},
                         {:amount 200 :msg "m2"}])))))
      
      