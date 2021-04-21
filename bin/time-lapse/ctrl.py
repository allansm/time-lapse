from os import chdir
from os import system
from glob import glob

def list(path,extension):
    return glob(path+"/"+extension)

def run():
    frames = list("captured","*png")

    higher = 0

    try:
        for frame in frames:
            f = int(frame.split("\\")[1].split(".")[0])

            if higher < f:
                higher = f
    except:
        print("...")

    chdir("captured")

    system("\"..\\timelapse.exe\" "+str(higher+1))

run()
