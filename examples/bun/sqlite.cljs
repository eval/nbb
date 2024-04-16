(ns sqlite
  (:require ["bun:sqlite$default" :as sqlite]
            [honey.sql :as sql]))

(def sqlmap {:select [:a :b :c]
             :from   [:foo]
             :where  [:= :foo.a "baz"]})

(prn (sql/format sqlmap))


(defn select []
  (let [db (new sqlite ":memory:")]
    (prn (.get (.query db "select 'Bun' as runtime")))))

(select)
