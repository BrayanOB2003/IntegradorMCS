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