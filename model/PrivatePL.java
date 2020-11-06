package model;

public class PrivatePL extends PlayList{
    private User userAccess;
    
    public PrivatePL(String name, User userAccess){
        super(name);
        this.userAccess = userAccess;
    }

    public User getUserAccess() {
        return userAccess;
    }

    public void setUserAccess(User userAccess) {
        this.userAccess = userAccess;
    }
    
    @Override
    public String showInformation(){
        String allInfo = "";
        
        allInfo += "**************  Playlist **************\n";
        allInfo += "**  Title: " + getName() + "\n";
        allInfo += "**  Duration: " + getDuration() + "\n";
        allInfo += "**  Genre: " + getGenders() + "\n";
        allInfo += "**  Usuario con acceso: " + getUserAccess().getName() + "\n\n";
                
        return allInfo;
    }
    
    public String addSong(Song song, User userAccess){
        String addTrue = "";
        if(this.userAccess.equals(userAccess)){
            addAllSong(song);
            addTrue = "Se agrego correctamente la cancion.";
        } else {
            addTrue = "El usuario logeado no tiene acceso a esta playList.";
        }
        
        return addTrue;
    }
}
