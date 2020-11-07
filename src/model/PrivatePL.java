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
        allInfo += "**  Usuario con acceso: " + getUserAccess().getName() + "\n\n";
                
        return allInfo;
    }
    
    /**
     * Add song to playlist. <br>
     * <b> pre: </b> User access previously logged in and existing song in pool. <br>
     * <b> post: </b> The song is added to the playList.
     * @param song song from the song pool. song! = null.
     * @param userAccess user logged into the program. access! = null && access == userAcces.
     * @return 
     */
    
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
