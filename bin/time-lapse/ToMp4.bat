@echo off
ffmpeg -framerate 60 -i "%temp%/time-lapse/captured/%%3d.png" output.mp4