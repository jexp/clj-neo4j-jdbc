(ns neo4j-jdbc.core
   (:use ring.adapter.jetty)
)

(defn hello [request]
    {:status 200 :headers {"Content-Type" "text/html"} :body "Hello World"}
)

(defn -main []
    (let [port (Integer/parseInt (or (System/getenv "PORT") "3000"))]
      (run-jetty hello {:port port})
    )
)
