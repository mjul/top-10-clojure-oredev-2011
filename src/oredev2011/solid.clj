(ns oredev2011.solid)

(deftype EnemyType [x y])

(defprotocol ClientProtocol
  (foo [this])
  (bar [this]))

(extend-type EnemyType
  ClientProtocol
  (foo [this] (str "EnemyType foo, x=" (.x this)))
  (bar [this] (str "EnemyType bar, y=" (.y this))))

(comment 
  (let [et (EnemyType. "x" "y")]
    (println (foo et))
    (println (bar et)))
  )