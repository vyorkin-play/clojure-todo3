(defproject
  todo
  "0.1.0-SNAPSHOT"
  :description
  "FIXME: write description"
  :ring
  {:handler todo.handler/app,
   :init todo.handler/init,
   :destroy todo.handler/destroy}
  :ragtime
  {:migrations ragtime.sql.files/migrations,
   :database
   "jdbc:postgresql://localhost/todo?user=db_user_name_here&password=db_user_password_here"}
  :plugins
  [[lein-ring "0.8.10"]
   [lein-environ "0.5.0"]
   [ragtime/ragtime.lein "0.3.6"]]
  :url
  "http://example.com/FIXME"
  :profiles
  {:uberjar {:aot :all},
   :production
   {:ring
    {:open-browser? false, :stacktraces? false, :auto-reload? false}},
   :dev
   {:dependencies
    [[ring-mock "0.1.5"]
     [ring/ring-devel "1.3.0"]
     [pjstadig/humane-test-output "0.6.0"]],
    :injections
    [(require 'pjstadig.humane-test-output)
     (pjstadig.humane-test-output/activate!)],
    :env {:dev true}}}
  :dependencies
  [[log4j
    "1.2.17"
    :exclusions
    [javax.mail/mail
     javax.jms/jms
     com.sun.jdmk/jmxtools
     com.sun.jmx/jmxri]]
   [selmer "0.6.8"]
   [com.taoensso/timbre "3.2.1"]
   [noir-exception "0.2.2"]
   [markdown-clj "0.9.44"]
   [environ "0.5.0"]
   [korma "0.3.2"]
   [org.clojure/clojure "1.6.0"]
   [ring-server "0.3.1"]
   [postgresql/postgresql "9.1-901-1.jdbc4"]
   [com.taoensso/tower "2.0.2"]
   [ragtime "0.3.6"]
   [lib-noir "0.8.4"]]
  :repl-options
  {:init-ns todo.repl}
  :min-lein-version "2.0.0")
