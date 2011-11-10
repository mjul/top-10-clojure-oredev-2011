(ns oredev2011.islands)

;; A Clojure record is not an island
(defrecord Conference [name year])

(def oredev (Conference. "Øredev" 2011))
(def cc (Conference. "Clojure Conj" 2011))
(def confs [oredev cc])

;; Records works with common functions
(filter #(= 2011 (:year %)) confs)
(sort-by :name confs)

;; a String is a Seq, and Seqs can be counted
;; Sort by the length of the name:
(sort-by (fn [c] (count (:name c))) confs)

;; Fields can be added dynamically
(assoc oredev :rating :great)

;; Conference fields have map semantics
(:year oredev)

;; A record is also a map of its properties
(seq oredev)

(doseq [[property value] oredev]
  (println property "->" value))


(comment 
  {:name "Øredev", :year 2011}
  )
