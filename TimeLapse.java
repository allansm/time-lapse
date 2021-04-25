import java.awt.image.BufferedImage;
import java.awt.Toolkit;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Rectangle;
import java.awt.Robot;
import java.text.DecimalFormat;

public class TimeLapse{

	public static void capture(String name) throws Exception{
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage capture = new Robot().createScreenCapture(screenRect);

		File imageFile = new File(name+".png");
		ImageIO.write(capture, "png", imageFile );
		System.out.println(name+".png");
	}

	public static void run(String[]args) throws Exception{
		int i = getLast(args[0])+1;

		DecimalFormat df = new DecimalFormat("#000");
		while(true){
			capture(args[0]+"/"+df.format(i++)+"");
			Thread.sleep(33*Integer.parseInt(args[1]));
		}
	}

	public static int getLast(String folder) throws Exception{
		System.out.println(folder);
		File dir = new File(folder);
		File[] ls = dir.listFiles();
			
		int higher = 0;
		
		try{
			for(File f : ls){
				String name = f.getName().split("\\.")[0];
				
				higher = (Integer.parseInt(name) > higher)?Integer.parseInt(name):higher;
			}
		}catch(Exception e){}

		System.out.println("last:"+higher);
		
		return higher;
	}

	public static void main(String[]args) throws Exception{
		run(args);
	}

}
