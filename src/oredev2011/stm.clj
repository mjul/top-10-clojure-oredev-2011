(ns oredev2011.stm)

(defn post [account amount msg]
  (conj account {:amount amount, :msg msg}))

(defn transfer [from to amount msg]
  (dosync
   (alter from post (- amount) msg)
   (alter to post amount msg)))

(defn balance [account]
  (reduce + 0 (map :amount account)))
