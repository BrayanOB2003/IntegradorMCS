package model;

public class RestrictedPL extends PlayList{
    private final static int MAX_USERS_ACCESS = 5;
    private User[] userAccess;
    
    public RestrictedPL(String name, User userAccess){
        super(name);
        this.userAccess[0] = userAccess;
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
        
        for(int i = 0; i < this.userAccess.length; i++){
        
            if(this.userAccess[i] == null){
                this.userAccess[i] = userAccess;
                for(int j = 0; i < this.userAccess.length; j++){
                    if(this.userAccess[i] == null){
                        cont++;
                        addTrue = "\n\nEl usuario " + this.userAccess[i].getName() + "tiene acceso a la playList restringida, " + cont + " de 5 usuarios con acceso.";
                    }
                }
                
            }else{
            
                addTrue = "\n\nEl numero de usuarios con acceso llego al limite, no se pueden dar mas accesos.";
            }
        
        }
        
        return addTrue;
        
        
    }
}