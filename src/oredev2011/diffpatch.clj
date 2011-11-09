(ns oredev2011.diffpatch
  (:use [clojure.set]))

(defrecord Quote [bid ask symbol])

(defn diff [old new]
  (let [changed (filter (fn [k]
                          (not= (get old k) (get new k)))
                        (keys new))]
    (select-keys new changed)))
    
(defn patch [old df]
  (merge old df))


(comment
  (diff {:bid 1.45, :ask 1.46, :symbol :eurusd}
        {:bid 1.44, :ask 1.47, :symbol :eurusd})
  )

(comment
  ;; For extra points, tag the diff and patch
  ;; with the fields that are changed
  ;; and the ones that have been deleted
  
  (defn diff-plus [old new]
    (let [changed (remove (fn [[k new-v]] (= new-v (get old k))) (seq new))
          deleted (difference (set (keys old)) (set (keys new)))]
      {:changed changed, :deleted deleted}))
  
  (defn patch-plus [old df]
    (-> (merge old (:changed df))
        (dissoc (:deleted df))))

  )

