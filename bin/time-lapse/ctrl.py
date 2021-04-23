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
    
    print("note: time increse depending hardware")
    print("speed 1 = 1 frame per 33ms,\n2 = 1 frame per 66ms,\n ...")
    system("\"..\\timelapse.exe\" "+str(higher+1)+" "+input("speed (default 1):"))

run()
