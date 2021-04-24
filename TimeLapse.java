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
	}

	public static void main(String[]args) throws Exception{
		int i = 0;
		DecimalFormat df = new DecimalFormat("#000");
		while(true){
			capture(args[0]+"/"+df.format(i++)+"");
			Thread.sleep(33*Integer.parseInt(args[1]));
		}
	}

}
