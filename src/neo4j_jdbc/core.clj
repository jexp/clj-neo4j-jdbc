(ns neo4j-jdbc.core
    (:use [ring.adapter.jetty] [clojure.data.json])
    (:require [clj-http.client :as client]))

(defn forward [body]
	(client/post "http://localhost:7474/db/data/cypher" 
   		{:accept :json :content-type :json  :body body }))
)
(defn forward [request]
	(let [res (forward (json-str {:query "start n=node(0) return n"}))]
    	(println res)
    	{:status 200 :headers {"Content-Type" "text/html"} :body res}
	)
)

(defn -main []
    (let [port (Integer/parseInt (or (System/getenv "PORT") "3000"))]
      (run-jetty forward {:port port})
    )
)
