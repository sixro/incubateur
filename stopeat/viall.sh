#!/bin/bash
vi $(find src -name "*.java") $(find res -name "*.xml" | grep -v "values-") pom.xml AndroidManifest.xml
