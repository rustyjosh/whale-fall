(ns whale-fall.core.desktop-launcher
  (:require [whale-fall.core :refer :all])
  (:import [com.badlogic.gdx.backends.lwjgl LwjglApplication]
           [org.lwjgl.input Keyboard])
  (:gen-class))

(defn -main
  []
  (LwjglApplication. whale-fall-game "whale-fall" 800 600)
  (Keyboard/enableRepeatEvents true))
