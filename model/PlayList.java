package model;

import java.util.ArrayList;

public abstract class PlayList {
    private String name;
    private String duration;
    private String genders;
    private ArrayList<Song> songs;
    
    public PlayList(String name) {
        this.name = name;
        
        duration = "00:00";
        songs = new ArrayList<Song>();
        genders = "Desconocido";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getGenders() {
        return genders;
    }

    public void setGenders(String genders) {
        this.genders = genders;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }
    
    public void addAllSong(Song song){
        songs.add(song);
    }
    
    public void upgrapePLayList(){

        int second = 0;
        int min = 0;
        int hours = 0;
        
        for(int i = 0; i < songs.size(); i++){

            min  += Integer.parseInt(songs.get(i).getDuration().substring(0, 2));
            second += Integer.parseInt(songs.get(i).getDuration().substring(3,5));
        }

        while(second >= 60){
            min++;
            second -= 60;
        }

        while(min >= 60){
           hours++;
           min -=60;
        }

        duration = String.valueOf(hours) + ":" + String.valueOf(min) + ":" + String.valueOf(second);
        
        final int MAX_GENDERS = 6;
        String[] allGenders = new String[MAX_GENDERS];
        String genders = "";
        int cont = 0;
        
        if(songs == null || songs.isEmpty()){
            
        }else{
            for(int i = 0; i < songs.size(); i++){
                for(int j = 0; j < allGenders.length; j++){
                    if(songs.get(i).getGender().equals(allGenders[j])){
                      cont++;
                    }
                }
                
                if(cont == 0){
                    for(int j = 0; j < allGenders.length; j++){
                        if(allGenders[j] == null){
                            allGenders[j] = songs.get(i).getGender();
                            j = allGenders.length;
                        }
                    }
                }
            }
            
            for(int i = 0; i < allGenders.length; i++){
                if(allGenders[i] != null){
                    genders += allGenders[i] + ", ";
                }
            }
            
            this.genders = genders.substring(0,genders.length() - 2);
        }
        
        
    }
    
    public abstract String showInformation();
}
