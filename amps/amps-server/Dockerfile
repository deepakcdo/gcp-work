FROM ubuntu:20.04

ARG VERSION=5.3.1.31

MAINTAINER Deepak Dhayatker - Head Front Consulting <deepakcdo@gmail.com>
#RUN apk --update add tar
ADD http://devnull.crankuptheamps.com/releases/amps/$VERSION/AMPS-$VERSION-Release-Linux.tar.gz /binaries/AMPS.tar
RUN ls -l /
RUN ls -l /binaries
RUN tar xvf /binaries/AMPS.tar --transform='s,AMPS[^/]*/,AMPS/,'
RUN ls -l /

# expose All  tcp ports
EXPOSE 8001
EXPOSE 8002

# expose All websocket ports
EXPOSE 8008


# expose All admin port
EXPOSE 8199

# expose reports port expose both
EXPOSE 18085



