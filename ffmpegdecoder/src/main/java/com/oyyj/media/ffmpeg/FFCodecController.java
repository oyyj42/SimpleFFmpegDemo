package com.oyyj.media.ffmpeg;

import android.util.Log;

public class FFCodecController {
	private static final String TAG =FFCodecController.class.getSimpleName();

	public FFCodecController() {

		for (int i = 0; i < FFMPEG_LIBS.length; i++) {
			try {				
				System.loadLibrary(FFMPEG_LIBS[i]);
			} catch (Exception e) {
					Log.e(TAG, "load:"+FFMPEG_LIBS[i]+"error!");
					e.printStackTrace();
			}
		}
	}
	
	private static final String[] FFMPEG_LIBS = { 
			"avcodec-56", 
			"avdevice-56", 
			"avfilter-5", 
			"avformat-56",
			"avutil-54",
			"postproc-53",
			"swresample-1", 
			"swscale-3", 
			"ffcodec_controller"
	};

	
	/* new api*/
	public native int ffcodec_init_h264_decoder(int width ,int height);
	public native int ffcodec_decode_h264_frame(byte[] frame,int length,byte[] out);
	public native int ffcodec_deinit_h264_decoder();

	//测试用
	public native int ffcodec_decodefile_h264_to_yuv(String h264file,String yuvFile);
}
