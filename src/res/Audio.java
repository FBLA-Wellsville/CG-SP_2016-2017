package res;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import io.github.trinnorica.utils.Sound;
import io.github.trinnorica.utils.SoundType;
import io.github.trinnorica.utils.Utils;

public class Audio {
	
	public static Clip background = null;
	final static Timer timer = new Timer();	
	
	public static synchronized void playSound(final Sound sound) {
		
		if(sound.getSoundType().equals(SoundType.BACKGROUND)){
			playBackground(sound);
			return;
		}
		
		try {
			
			
			
			final String name = sound.getSoundString();
			
			
			
			final Clip clip = AudioSystem.getClip();
			final AudioInputStream audioStream = AudioSystem.getAudioInputStream(new BufferedInputStream(Audio.class.getResourceAsStream("sounds/" + name)));
			
			clip.open(audioStream);
				
			
			
			
			clip.start();
			AudioFormat format = clip.getFormat();
			long frames = clip.getFrameLength();
			double time = (frames+0.0) / format.getFrameRate();
			final Timer timer = new Timer();	
//			timer.schedule(new TimerTask() {	
//				@Override		
//				public void run() {	
//					clip.flush();
//					
//					timer.cancel();
//				}	
//			}, (long) time*1000);
			
			
			try {
				audioStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		    
		} catch (Exception e) { e.printStackTrace();}
	}

	public static void nextSong() {
		background.stop();
//		playSound(SoundType.BACKGROUND.);
	}

	public static void playBackground(final Sound sound) {
		
		try{
			if(background!=null){
				try{
					timer.cancel();
				} catch(IllegalStateException ex){
					
				}
				background.close();
			}
			final String name = sound.getSoundString();
			
			
			
			final Clip clip = AudioSystem.getClip();
			final AudioInputStream audioStream = AudioSystem.getAudioInputStream(new BufferedInputStream(Audio.class.getResourceAsStream("sounds/" + name)));
			
			clip.open(audioStream);
				
			
			
			
			
			if(sound.getSoundType().equals(SoundType.BACKGROUND)){
				background = clip;
				background.loop(Clip.LOOP_CONTINUOUSLY);
				background.start();
			
				AudioFormat format = background.getFormat();
				long frames = background.getFrameLength();
				double time = (frames+0.0) / format.getFrameRate(); 			
				
				try{
					timer.schedule(new TimerTask() {
						@Override		
						public void run() {	
							clip.flush();
							playSound(sound);
							timer.cancel();	
						}	
					}, (long) time);
				} catch(IllegalStateException ex){
					
				}
				
				try {
					audioStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}
