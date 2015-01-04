package com.hemika.javacv;


import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameGrabber;


/**
 * Created by hemikakodikara on 12/31/14.
 */
public class JavaCVTestReading {
    public static void main(String[] args) throws Exception {


        FrameGrabber grabber = new OpenCVFrameGrabber("src/main/resources/video/tunnel.mp4");
        grabber.start();
        opencv_core.IplImage grabbedImage = grabber.grab();
        CanvasFrame canvasFrame = new CanvasFrame("Video with JavaCV");
        canvasFrame.setCanvasSize(grabbedImage.width(), grabbedImage.height());
        canvasFrame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        System.out.println("framerate = " + grabber.getFrameRate());
        grabber.setFrameRate(grabber.getFrameRate());


        while (canvasFrame.isVisible() && (grabbedImage = grabber.grab()) != null) {
            canvasFrame.showImage(grabbedImage);
        }

        grabber.stop();
        canvasFrame.dispose();



//        //System.loadLibrary("opencv_core");
//        //Create canvas frame for displaying video.
//        CanvasFrame canvas = new CanvasFrame("VideoCanvas");
//
//        //Set Canvas frame to close on exit
//        canvas.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
//
//        //Declare FrameGrabber to import video from "video.mp4"
//        FrameGrabber grabber = new FFmpegFrameGrabber("/Users/hemikakodikara/Desktop/tunnel.mp4");
//        try {
//
//            //Start grabber to capture video
//            grabber.start();
//
//            //Declare img as IplImage
//            opencv_core.IplImage img;
//
//            while (true) {
//
//                //inser grabed video fram to IplImage img
//                img = grabber.grab();
//
//                //Set canvas size as per dimentions of video frame.
//                canvas.setCanvasSize(grabber.getImageWidth(), grabber.getImageHeight());
//
//                if (img != null) {
//                    //Show video frame in canvas
//                    canvas.showImage(img);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
