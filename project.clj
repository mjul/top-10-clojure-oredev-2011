(defproject oredev2011 "0.0.1-SNAPSHOT"
  :description "Top Ten Things to Learn from Clojure that will make you a better developer in any language." 
  :dependencies [[clojure "1.3.0"]
                 #_[clojure-contrib "1.2.0"]
                 ]
  :dev-dependencies [[marginalia "0.6.1"]
                     [cake-marginalia "0.6.0"]
                     [slamhound "1.2.0"]]
  :tasks [cake-marginalia.tasks]
  :cake-plugins [[cake-slamhound "0.0.1"]]
  )

