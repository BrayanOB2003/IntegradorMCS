package model;

public class PublicPL extends PlayList{
    private float calificationNumbers;
    private float allCalification;
    private float averageMark;
    
    public PublicPL(String name){
    super(name);
    allCalification = 0;
    calificationNumbers = 0;
    averageMark = 0;
    }
    
    public float getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(float averageMark) {
        this.averageMark = averageMark;
    }
    
    /**
     * Calcula el promedio de calificaciones.<br>
     * <b> pre: </b> La playList esta creada <br>
     * <b> post: </b> Calcula el promedio de calificaciones.
     * @param calification calificacion dada por el usuario. califiction >= 0 && 5 >= calification.
     * @return 
     */
    
    public String averageMark(float calification){
        String mark = "";
        
        allCalification +=calification;
        calificationNumbers++;
            if(calificationNumbers != 0){
                averageMark = allCalification /calificationNumbers;
                mark = "Se añadio la calificacion a la playList " + getName() + ".";
            }
        return mark;
    }
    
    /**
     * Add song to playlist.<br>
     * <b> pre: </b> User access previously logged in and existing song in pool.<br>
     * <b> post: </b> The song is added to the playList.
     * @param song song from the song pool. song! = null.
     * @return 
     */
    
    public String addSong(Song song){
        String addTrue = "";
        addAllSong(song);
        addTrue = "Se agrego la cancion correctamente.\n\n";
        
        return addTrue;
    }
    
    /**
     * Show information from the playlist <br>
     * <b> pre: </b> Playlist created and updated. <br>
     * <b> post: </b> They return all the updated information from the playList.
     * @return
     */
    
    @Override
    public String showInformation(){
        String allInfo = "";
        
        allInfo += "**************  Playlist **************\n";
        allInfo += "**  Title: " + getName() + "\n";
        allInfo += "**  Duration: " + getDuration() + "\n";
        allInfo += "**  Genre: " + getGenders() + "\n";
        allInfo += "**  Calification: " + getAverageMark() + "\n\n";
                
        return allInfo;
    }
}
