FROM alpine

ARG VERSION=5.3.1.31

MAINTAINER Deepak Dhayatker - Head Front Consulting <deepakcdo@gmail.com>

ADD http://devnull.crankuptheamps.com/releases/amps/$VERSION/AMPS-$VERSION-Release-Linux.tar.gz /binaries/AMPS.tar
RUN ls -l /
RUN ls -l /binaries
RUN tar xvf /binaries/AMPS.tar
RUN mv AMPS-$VERSION-Release-Linux AMPS
RUN ls -l /

# expose All  tcp ports
EXPOSE 8001
EXPOSE 8002
EXPOSE 9001
EXPOSE 9002

# expose All websocket ports
EXPOSE 8008
EXPOSE 9008


# expose All admin port
EXPOSE 8199
EXPOSE 8198

# expose reports port expose both
EXPOSE 18085
EXPOSE 19085



