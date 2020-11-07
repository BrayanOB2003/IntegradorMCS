package model;

public class RestrictedPL extends PlayList{
    private final static int MAX_ACCESS = 5;
    private User[] userAccess;
    
    public RestrictedPL(String name, User access){
        super(name);
        userAccess = new User[MAX_ACCESS];
        userAccess[0] = access;
    }

    public User[] getUserAccess() {
        return userAccess;
    }

    public void setUserAccess(User[] userAccess) {
        this.userAccess = userAccess;
    }
    
    /**
     * Add selected user. <br>
     * <b> pre: </b> A restricted playList has been created. <br>
     * <b> post: </b> User has been given access.
     * @param userAccess user to which access will be given. userAccess! = null.
     * @Return
     */
    
    public String addUserAccess(User userAccess){
        String addTrue = "";
        int cont = 0;
        
        for(int i = 0; i < MAX_ACCESS; i++){
        
            if(this.userAccess[i] == null){
                this.userAccess[i] = userAccess;
                for(int j = 0; j < MAX_ACCESS; j++){
                    if(this.userAccess[j] == null){
                        cont++;
                        addTrue = "\n\nEl usuario " + this.userAccess[i].getName() + " tiene acceso a la playList restringida, " + cont + " de 5 accesos diponibles.";
                        j = MAX_ACCESS;
                    } else {
                        addTrue = "\n\nEl usuario " + this.userAccess[i].getName() + " tiene acceso a la playList restringida, 5 de 5 accesos ocupados.";
                    }
                }
                i = MAX_ACCESS;
            }else{
            
                addTrue = "\n\nEl numero de usuarios con acceso llego al limite, no se pueden dar mas accesos.";
                
            }
        
        }
        
        return addTrue;
        
        
    }
    
    /**
     * Add song to playlist. <br>
     * <b> pre: </b> User access previously logged in and existing song in pool. <br>
     * <b> post: </b> The song is added to the playList.
     * @param song song from the song pool. song! = null.
     * @param access user logged into the program. access! = null && access == userAcces [].
     * @return 
     */
    
    public String addSong(Song song, User access){
        String addTrue = "";
        
        for(int i = 0; i < MAX_ACCESS; i++){
            if(userAccess[i].equals(access)){
                addAllSong(song);
                addTrue = "Se agrego correctamente la cancion.";
                i = MAX_ACCESS;
            } else {
                addTrue = "El usuario logeado no tiene acceso a esta playList.";
            }                                                                         
        }
        
        return addTrue;
    }
    
    /**
     * Update names of users with access to the playList. <br>
     * <b> pre: </b> There must be users with access to the playList. <br>
     * <b> post: </b> The updated user names are returned.
     * @return
     */
    
    public String updateAccess(){
        String restringedUsers = "";
    
        for (int i = 0; i < getUserAccess().length; i++){

            if(getUserAccess()[i] != null){
                 restringedUsers += getUserAccess()[i].getName() + ", ";
            }
        }
        
        restringedUsers = restringedUsers.substring(0, restringedUsers.length() - 2);
        
        return restringedUsers;
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
        allInfo += "**  Usuarios con acceso: " + updateAccess() + "\n\n";
        
        return allInfo;
    }
}