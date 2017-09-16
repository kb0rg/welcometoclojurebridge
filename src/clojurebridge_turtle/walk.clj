(ns clojurebridge-turtle.walk
  (:use clojure.repl)
  (:use clojurebridge-turtle.core))
(init)
(defn draw-triangle []
  (dotimes [index 3]
   (forward 50)
   (right 120)))
   
(defn draw-multi-tri [num]
  (dotimes [index num]
    (draw-triangle)
    (forward-invis 75)))

(defn prep-canvas []
  (right 90)
  (forward-invis 150)
  (left 180))
  

(prep-canvas)
#_(draw-multi-tri 5)

(add-turtle :neo)
(turtle-names)

(def sf-temps [55 54 56 57 90 48 50])
(nth sf-temps 0)
(first sf-temps)
(rest sf-temps)
(nthrest sf-temps 3)

(def all-temps {:sf sf-temps})
all-temps

all-temps

(get all-temps :sf)
(:sf all-temps)

(def all-temps2 (assoc all-temps "ny" [99 99 98 90 97 32 34]))

(get all-temps2 "sf")


all-temps
all-temps2
(count all-temps2)
(keys all-temps2)
(vals all-temps2)

(def hello {:count 1 :words "hello"})
hello
(update hello :count inc)
hello
(def hello (update hello :count inc))
hello

(def mine {:pet {:age 5 :name "able"}})
mine

(update-in mine [:pet :age] inc)
mine
(def mine (update-in mine [:pet :age] inc))
mine

(def yours {:pet {:age 10 :name "bumble"}})
(get yours :age) ; get can not find this key to get the value
(get-in yours [:pet :age]) ;get-in uses the vector as the path to the key
(update-in yours [:pet :age] inc) ; returns updates value but doesn't rebind var
yours ; confirm returned value is NOT updated
(def yours (update-in yours [:pet :age] inc)); now rebind the var
yours ; returned value is now updated
;; you can access result of previously evaluated line
(def hers {:pet {:age 2 :name "pooh"}})
(update-in hers [:pet :age] inc)
(def hers2 *1) ; but can I use it to assign?
hers2 ; not sure. don't think so?
hers


;; this is broken in the insta-repl but works in repl
(state-all)
(def states (state-all))
(first states)
(def st (first states))
st
(get st :trinity)
(get-in st [:trinity :angle])

(def me {:first "k" :last "borg" :hometown "jupiter"})
(def classmates [{:first "Al" :last "Thompson" :hometown "SF"} 
                 {:first "F" :last "O" :hometown "LA"}])
classmates
me
(conj classmates me)
(def my-classmates (conj classmates me))
my-classmates


;; re-read section on Naming functions (with info on predicate functions)

(def all-angs (map :angle [{:angle 30} {:angle 90} {:angle 50}]))
all-angs

(float (let [sum (reduce + all-angs)] 
         len (count all-angs)
         (/ sum len)))

len
sum
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; On NightCode, click Run with REPL followed by Reload File
;; for the first time. If REPL has already started, click
;; Reload File to run this code.
;;
;; Once a turtle (small triangle) appears in the center of window,
;; type code in REPL.
;;
;; Alternatively, you may type code in this editor. To evaluate:
;; - pieces of code: select code fragment and Reload Selection
;; - whole file: click Reload File
;;
;; [Exercise]
;; write some functions under these comment lines
;; and evalute those
;;
;; for example
;; (forward 30)
;; (right 90)
;; (forward 30)
;; (right 90)
;;
;; see how the turtle walks
;;
