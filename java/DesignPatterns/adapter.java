/* The purpose of the adapter pattern is so that in your main 
 * implementation of the logic you only have one interface, in this
 * example the play method. Behind the scenes however when additional
 * steps need to be taken they are handed off to a differnt class.  */ 

//---------------------------------------------------------
// Main Class 
//---------------------------------------------------------
public class adapter{
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3","beyond the horizon.mp3");
        audioPlayer.play("mp4","alone.mp4");
        audioPlayer.play("vlc","far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}

//---------------------------------------------------------
// Defines the interface for the MediaPlayer, simply a 
// play method
//---------------------------------------------------------
interface MediaPlayer{
    public void play(String audioType, String fileName);
}

//---------------------------------------------------------
// Defines the interface for the AdvancedMediaPlayer, defines
// a method for playing VLC and MP4
//---------------------------------------------------------
interface AdvancedMediaPlayer{
    public void playVlc(String fileName);
    public void playMp4(String fileName);
}

//---------------------------------------------------------
// Offers a concrete implementation of AdvancedMediaPlayer
// for VLC
//---------------------------------------------------------
class VlcPlayer implements AdvancedMediaPlayer{
    @Override public void playVlc(String fileName){
       System.out.println("Playing vlc file. Name: " + fileName);
    }

    @Override public void playMp4(String fileName){}
}

//---------------------------------------------------------
// Offers a concrete implementation of AdvancedMediaPlayer
// for MP4
//---------------------------------------------------------
class Mp4Player implements AdvancedMediaPlayer{
    @Override public void playVlc(String fileName){}

    @Override public void playMp4(String fileName){
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}

//---------------------------------------------------------
// MediaAdapter class which provides an adapter for
// AudioPlayer
//---------------------------------------------------------
class MediaAdapter implements MediaPlayer{

    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType){
        if(audioType.equalsIgnoreCase("vlc")){
            advancedMediaPlayer = new VlcPlayer();
        }else if(audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer = new Mp4Player();
        }
    }

    @Override public void play(String audioType,String fileName){
        if(audioType.equalsIgnoreCase("vlc")){
            advancedMediaPlayer.playVlc(fileName);
        }else if(audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}

//---------------------------------------------------------
// AudioPlayer plays mp3 files and passes on the work to the 
// MediaAdapter if a format besides mp3 is used at which point
// play is called from the AudioPlayer
//---------------------------------------------------------
class AudioPlayer implements MediaPlayer{

    MediaAdapter mediaAdapter;

    @Override public void play(String audioType, String fileName){
        if(audioType.equalsIgnoreCase("mp3")){
            System.out.println("Playing mp3 file. Name: " + fileName);
        }else if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")){
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType,fileName);
        }else{
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}
