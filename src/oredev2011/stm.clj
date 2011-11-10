(ns oredev2011.stm)

(defn post
  "Post an amount to the account."
  [account amount msg]
  (conj account {:amount amount, :msg msg}))

(defn transfer
  "Transfer an amount between two accounts."
  [from to amount msg]
  (dosync
   (alter from post (- amount) msg)
   (alter to post amount msg)))

(defn balance [account]
  (reduce + 0 (map :amount account)))
