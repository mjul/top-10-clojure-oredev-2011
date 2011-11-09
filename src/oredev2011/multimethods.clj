(ns oredev2011.multimethods)

;; Some terrible code that we got from a third party.
(deftype LegacyMenuItemClass [pszName])

;; Our new native menu-item
(defrecord MenuItem [name type price])
(defn menu-item [name type price]
  (MenuItem. name type price))

;; Polymorphic functions based on dispatch-fn

;; Static dispatch based on the class of the argument
(defmulti menu-item? class)
(defmethod menu-item? MenuItem [x] true)
(defmethod menu-item? LegacyMenuItemClass [x] true)
(defmethod menu-item? :default [x] false)


;; Polymorphism on the value of the :type member
(defmulti description :type)
(defmethod description :beverage [x]  (str "Drink a wonderful " (:name x)))
(defmethod description :food [x]   (str "Savour a tasty " (:name x)))


(comment

  (def fish-and-chips (LegacyMenuItemClass. "Fish and Chips"))
  (def espresso (menu-item "Espresso" :beverage 12))
  (def cortado (menu-item "Cortado" :beverage 16))
  (def royale (menu-item "Burger Royale" :food 100))
  (def big-kahuna (menu-item "Big Kahuna Burger" :food 100))

  ;; They are all menu items
  (menu-item? "Hello, World!")
  (menu-item? royale)
  (menu-item? fish-and-chips)

  ;; And the description adapts to the value of :type
  (description big-kahuna)
 
)
