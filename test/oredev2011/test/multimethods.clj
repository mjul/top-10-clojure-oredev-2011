(ns oredev2011.test.multimethods
  (:use [oredev2011.multimethods :reload :all]
        [clojure.test])
  (:import [oredev2011.multimethods LegacyMenuItemClass]))

(deftest menu-item?-tests
  (testing "Should recognize new menu-item record."
    (is (menu-item? (menu-item "Espresso" :drink 12))))
  (testing "Should recognize legacy menu items"
    (is (menu-item? (LegacyMenuItemClass. "Fish and Chips"))))
  (testing "Should not accept unknown types as menu items."
    (is (not (menu-item? 42)))
    (is (not (menu-item? "some weird string")))))


  