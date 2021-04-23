using System.Drawing.Imaging;

using System.Drawing;
using System.Windows.Forms;
using System.IO;
using System;
using System.Threading;

public class TimeLapse{
	public static int y = SystemInformation.VirtualScreen.Height;
	public static int x = SystemInformation.VirtualScreen.Width;

	static void Capture(string filename){
		Bitmap captureBitmap = new Bitmap(x, y, PixelFormat.Format16bppRgb555);
		Rectangle captureRectangle = Screen.AllScreens[0].Bounds;
		Graphics captureGraphics = Graphics.FromImage(captureBitmap);
		captureGraphics.CopyFromScreen(captureRectangle.Left,captureRectangle.Top,0,0,captureRectangle.Size);
		captureBitmap.Save(filename+".png",ImageFormat.Png);
		captureGraphics.Dispose();
	}

	static void Run(int start,int factor){
		int name = start;
		while(true){
			Capture(name.ToString("000"));
			Console.WriteLine(name+".png");
			name++;
			System.Threading.Thread.Sleep(33*factor);
		}
	
	}

	public static void Main(String[]args){
		Run(int.Parse(args[0]),int.Parse(args[1]));
	}
}
