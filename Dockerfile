FROM tomcat:8.5.37-jre8
COPY ./angular/news/dist/. /usr/local/tomcat/webapps/news
COPY ./service/news/target/news-1.war /usr/local/tomcat/webapps
