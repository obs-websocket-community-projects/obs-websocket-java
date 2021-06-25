# Based on ubuntu:20.04
FROM ubuntu@sha256:aba80b77e27148d99c034a987e7da3a287ed455390352663418c0f2ed40417fe

# Install dependencies
RUN export DEBIAN_FRONTEND=noninteractive \
    && apt-get -y update \ 
    && apt-get install -y \
        tzdata \
        software-properties-common \
        ffmpeg \
        xvfb

# Install OBS
RUN add-apt-repository ppa:obsproject/obs-studio \
    && apt install -y obs-studio

# Copy the Ubuntu package into the container, and install it
COPY obs-websocket-plugin obs-websocket-plugin
RUN mv obs-websocket-plugin/**.deb obs-websocket-plugin/plugin.deb
RUN apt install -y ./obs-websocket-plugin/plugin.deb

# Expose websocket port
EXPOSE 4444

# Run OBS through xvfb (headless UI)
CMD xvfb-run obs