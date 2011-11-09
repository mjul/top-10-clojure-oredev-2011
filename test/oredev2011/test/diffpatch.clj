(ns oredev2011.test.diffpatch
  (:use [oredev2011.diffpatch :reload :all]
        [clojure.test]))

(deftest diff-tests
  (testing "Diff with same should be empty."
    (let [data {:key "val"}]
      (is (empty? (diff data data)))))
  (testing "Diff should return changed field only."
    (is (= {:changed "after"}
           (diff {:same "same", :changed "before"}
                 {:same "same", :changed "after"})))))

(deftest patch-tests
  (testing "Empty patch should do nothing."
    (let [data {:key "val"}]
      (is (= data (patch data {})))))
  (testing "Patch should overwrite fields with new values."
    (is (= {:a "unchanged", :b "new b", :c "new c"}
           (patch {:a "unchanged", :b :b, :c :c}
                  {:b "new b", :c "new c"})))))

(deftest diff-patch-integration-tests
  (testing "Applying diff patch should map old to new"
    (let [ab {:a "a", :b "b"}
          xy {:a "x", :b "y"}]
      (testing "for no change"
        (is (= ab (patch ab (diff ab ab)))))
      (testing "for changed fields"
        (is (= xy (patch ab (diff ab xy))))))))
