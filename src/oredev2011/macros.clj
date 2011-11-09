(ns oredev2011.macros)

;; Actually this is the Clojure core when-not macro:

(defmacro unless
  "Evaluates test. If logical false, evaluates body in an implicit do."
  [test & body]
  (list 'if test nil (cons 'do body)))


(comment
  (macroexpand-1 '(unless (neg? x)
                          (println "x is non-neg")))

  ;; expands to
  (if (neg? x) nil (do (println "x is non-neg")))
  
  )

