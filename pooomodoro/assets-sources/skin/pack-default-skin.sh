#! /bin/sh

rm -rf default
mkdir default

java -jar ../tools/runnable-texturepacker.jar ./default-skin ./default skin texturepacker.settings
cp ./default-source/* ./default/
