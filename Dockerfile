FROM ubuntu:latest
LABEL authors="dotin"

ENTRYPOINT ["top", "-b"]