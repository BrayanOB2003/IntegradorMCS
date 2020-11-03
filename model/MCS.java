package model;

public class MCS {
    private final static int MAX_USERS = 10;
    private final static int MAX_PLAYLIST = 20;
    private final static int MAX_SONGS = 30;
    private int userAccess;
    private User[] users;
    private PlayList[] playLists;    
    private Song[] poolSongs;
    
    public MCS(){
        users = new User[MAX_USERS];
        playLists = new PlayList[MAX_PLAYLIST];
        poolSongs = new Song[MAX_SONGS];
        userAccess = -1;
    }
    
    public String loginUser(String name, String password){
        String access = "";
        
        for(int i = 0; i < users.length; i++){
            if(users[i] != null){
                if(users[i].getName().equals(name) && users[i].getPassword().equals(password)){
                    userAccess = i;
                    access = "\n\nEl usuario " + users[i].getName() + " ingreso correctamente.";
                    break;
                } else {
                    access = "\n\nEl usuario no se encuentra registrado.";
                }
            }
        }
        
        return access;
    }
    
    public String addUser(String name, String password, int age){
        User user = new User(name, password, age);
        String userRegister = "";
        
        for(int i = 0; i < users.length; i++){
            if(users[i] == null){
                users[i] = user;
                userRegister = "\n\nEl usuario se añadio correctamente.";
            } else{            
                userRegister = "\n\nEl limite de usuarios ha sido superado, no se pudo agregar.";
            }
        }
        
        return userRegister;
    }
    
    public String showUsers(){
        String userInfo = "";
        
        for(int i=0; i < users.length; i++){
            if(users[i] != null){
                userInfo =  "*************  User **************\n"; 
                userInfo += "**  UserName: " + users[i].getName() + "\n";
                userInfo += "**  Age: " + users[i].getAge() + "\n";
                userInfo += "**  Category: " + users[i].getCategory() + "\n";
                userInfo += "***********************************\n\n";
            }
        }
        
        return userInfo;
    }
    
    public String addPoolSong(String title, String artistName, String releaseDate, String duration, int gender){
        Song addSong = new Song(title, artistName, releaseDate, duration, gender);
        String addTrue = "";
        if(userAccess > 0){
            for(int i = 0; i < poolSongs.length; i++){
                if(poolSongs[i] == null){
                    poolSongs[i] = addSong;
                    users[userAccess].setSharedSongs(1);
                    addTrue = "\n\nSe añadio correctamente al pool de canciones.";
                    break;
                }
            }
        }
        return addTrue;
    }

    public String showSongs(){
    
        String allInfo = "";
        
        for(int i = 0; i < poolSongs.length; i++){
        
            if(poolSongs[i] != null){
                allInfo =  "**************  Song **************\n";
                allInfo += "**  Title: " + poolSongs[i].getTitle() + "\n";
                allInfo += "**  Artist: " + poolSongs[i].getArtistName() + "\n";
                allInfo += "**  Duration: " + poolSongs[i].getDuration() + "\n";
                allInfo += "**  Genre: " + poolSongs[i].getGender() + "\n";
                allInfo += "***********************************\n\n";
            }
            
        }
        
        return allInfo;
    }
    
    public String addPlayList(){
        String addTrue = "";
        
        
        
        return addTrue;
    }
}
