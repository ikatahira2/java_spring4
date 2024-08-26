FROM gitpod/workspace-full

# Instalar o JDK 17
RUN sudo apt-get update && sudo apt-get install -y openjdk-17-jdk
