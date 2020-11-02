package model;

public class PrivatePL extends PlayList{
    private User userAcces;
    
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
}
