# Use a base image compatible with GraalVM
FROM ghcr.io/graalvm/graalvm-ce:latest

# Install necessary tools and dependencies
RUN gu install native-image

# Copy the Quarkus project into the container
COPY docker /project
WORKDIR /project

# Build the native executable using GraalVM
RUN mvn package -Pnative -Dnative-image.docker-build=true

# Prepare function.zip (adjust as needed for your specific deployment)
RUN echo '#!/bin/sh' > /project/bootstrap
RUN echo './target/*-runner' >> /project/bootstrap
RUN chmod 755 /project/bootstrap
RUN zip -j /project/function.zip /project/bootstrap /project/target/*-runner

# Set the command to run your application (adjust as needed)
CMD ["./target/*-runner"]
