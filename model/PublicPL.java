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
    
    public String addSong(Song song){
        String addTrue = "";
        addAllSong(song);
        addTrue = "Se agrego la cancion correctamente.\n\n";
        
        return addTrue;
    }
    
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
