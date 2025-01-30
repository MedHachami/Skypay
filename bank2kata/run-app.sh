#!/bin/bash

# Exit immediately if a command exits with a non-zero status
set -e

echo "🚀 Cleaning and packaging the application..."
mvn clean package

echo "✅ Build successful!"

echo "🔄 Running the application..."
mvn exec:java -Dexec.mainClass="com.skypay.bank2kata.App"

echo "🎉 Application executed successfully!"
