#!/bin/bash

# Stop and remove any existing container
if [ "$(docker ps -q -f name=nasa-apod-app)" ]; then
    docker stop nasa-apod-app
    docker rm nasa-apod-app
fi

# Remove old image
if [ "$(docker images -q nasa-apod-app)" ]; then
    docker rmi nasa-apod-app
fi

# Load new image from tar file
docker load < nasa-apod-app.tar

# Run the new container
docker run -d --name nasa-apod-app -p 8080:8080 nasa-apod-app

echo "Deployment completed successfully!"