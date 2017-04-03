(ns whale-fall.core
  (:require [play-clj.core :refer :all]
            [play-clj.g2d :refer :all]))


(defn move
  [entity direction]
  (case direction
    :down (update entity :y (fn [z] (- z 5)))
    :up (update entity :y (fn [z] (+ z 5)))
    :left (update entity :x (fn [z] (- z 5)))
    :right (update entity :x (fn [z] (+ z 5)))
    nil))


(defscreen main-screen
  :on-show
  (fn [screen entities]
    (add-timer! screen :spawn-enemy 10)
    (update! screen :renderer (stage) :camera (orthographic))
    (assoc (texture "fish.png") 
      :x 570 :y 0 :width 45 :height 45))

  
  :on-render
  (fn [screen entities]
    (clear!)
    (render! screen entities))
  
  :on-key-down  
  (fn [screen entities]
    (cond
      (= (:key screen) (key-code :dpad-up))
      (move (first entities) :up)
      (= (:key screen) (key-code :dpad-down))
      (move (first entities) :down)
      (= (:key screen) (key-code :dpad-right))
      (move (first entities) :right)
      (= (:key screen) (key-code :dpad-left))
      (move (first entities) :left)))
  
  :on-resize
  (fn [screen entities]
    (height! screen 600)))

(defgame whale-fall-game
  :on-create
  (fn [this]
    (set-screen! this main-screen)))
