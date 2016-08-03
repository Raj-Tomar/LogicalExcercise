package com.raj.thumbnail;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;

public class CreateThumbnail {

	public static void main(String[] args) throws Exception {
		new CreateThumbnail().createThumbnail();
		new ThumbnailGenerator().transform("C:/Documents and Settings/Administrator/Desktop/Waterlilies.jpg",
				"C:/Documents and Settings/Administrator/Desktop/thumb.png",
				100,100,1000);
	}
	
	private void createThumbnail() throws FileNotFoundException,IOException{
        File file = new File("C:/Documents and Settings/Administrator/Desktop/Waterlilies.jpg");
        BufferedImage img = ImageIO.read(file);
        BufferedImage thumb = Scalr.resize(img, Scalr.Method.SPEED,102, 102, Scalr.OP_ANTIALIAS);
        ImageIO.write(thumb, "png", new File("C:/Documents and Settings/Administrator/Desktop/thumb1.png"));
   }
}
