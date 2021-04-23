@echo off
ffmpeg -framerate 25 -i "%temp%/time-lapse/captured/%%3d.png" output.mp4