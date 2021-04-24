@echo off
dir /s /b "%temp%/time-lapse/captured/"
echo please wait...
del "%temp%/time-lapse/captured/\*.png"
echo all clean
pause