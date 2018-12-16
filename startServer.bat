cd java-client
mvn clean install
cd ..
cd dojo-server
mvn clean -DMAVEN_OPTS=-Xmx1024m jetty:run