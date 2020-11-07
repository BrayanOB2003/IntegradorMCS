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

    public int getUserAccess() {
        return userAccess;
    }

    public void setUserAccess(int userAccess) {
        this.userAccess = userAccess;
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public PlayList[] getPlayLists() {
        return playLists;
    }

    public void setPlayLists(PlayList[] playLists) {
        this.playLists = playLists;
    }

    public Song[] getPoolSongs() {
        return poolSongs;
    }

    public void setPoolSongs(Song[] poolSongs) {
        this.poolSongs = poolSongs;
    }
    
    
    /**
     * User login <br>
     * <b> pre: </b> The user must be created before logging in <br>
     * <b> post: </b> The user enters the system. <br>
     * @param name name of the user. name! = null.
     * @param password password of the user. password! = null.
     * @return
     */
    
    public String loginUser(String name, String password){
        String access = "";
        
        for(int i = 0; i < users.length; i++){
            if(users[i] != null){
                if(users[i].getName().equals(name) && users[i].getPassword().equals(password)){
                    setUserAccess(i);
                    access = "\n\nEl usuario " + users[i].getName() + " ingreso correctamente.";
                    i = users.length;
                } else {
                    access = "\n\nEl usuario no se encuentra registrado.";
                }
            }
        }
        
        return access;
    }
    
    
    /**
     * Add user <br>
     * <b> pre: </b> <br>
     * <b> post: </b> The user is added to the system. 
     * @param name name of the user. name! = null.
     * @param password password of the user. password! = null.
     * @param age age of the user. age! = null.
     * @return
     */
    
    public String addUser(String name, String password, int age){
        User user = new User(name, password, age);
        String userRegister = "";
        
        for(int i = 0; i < users.length; i++){
            if(users[i] == null){
                users[i] = user;
                userRegister = "\n\nEl usuario se añadio correctamente.";
                i = users.length;
            } else{            
                userRegister = "\n\nEl limite de usuarios ha sido superado, no se pudo agregar.";
            }
        }
        
        return userRegister;
    }
    
    
    /**
     * Show information of all users. <br>
     * <b> pre: </b> Users created <br>
     * <b> post: </b> The information of all registered users is displayed. 
     * @return
     */
    
    public String showUsers(){
        String userInfo = "";
        
        for(int i=0; i < users.length; i++){
            if(users[i] != null){
                userInfo += "*************  User **************\n"; 
                userInfo += "**  UserName: " + users[i].getName() + "\n";
                userInfo += "**  Age: " + users[i].getAge() + "\n";
                userInfo += "**  Category: " + users[i].getCategory() + "\n";
                userInfo += "***********************************\n\n";
            }
        }
        
        return userInfo;
    }
    
    /**
     * Add song to song pool. <br>
     * <b> pre: </b> A user must be logged in. <br>
     * <b> post: </b> Song is added to the song pool.
     * @param title title of the song. title! = null.
     * @param artistName name of the artist or band. artistName! = null.
     * @param releaseDate release date. releaseDate! = null.
     * @param duration duration of the song. duration! = null && duration> 01:00.
     * @param gender gender of the song.
     * @return
     */
    
    public String addPoolSong(String title, String artistName, String releaseDate, String duration, int gender){
        Song addSong = new Song(title, artistName, releaseDate, duration, gender);
        String addTrue = "";
        if(userAccess >= 0){
            for(int i = 0; i < poolSongs.length; i++){
                if(poolSongs[i] == null){
                    poolSongs[i] = addSong;
                    users[userAccess].upgrapeShredSongs(1);
                    users[userAccess].upgrapeUserCategoy();
                    addTrue = "\n\nSe añadio correctamente al pool de canciones.";
                    i = poolSongs.length;
                }
            }
        }
        return addTrue;
    }
    
    
    /**
     * Show the information of all the songs in the pool. <br>
     * <b> pre: </b> There must be songs added in the song pool <br>
     * <b> post: </b> All the information of the songs of the poool is returned.
     * @return
     */
    
    public String showSongs(){
    
        String allInfo = "";
        
        for(int i = 0; i < poolSongs.length; i++){
        
            if(poolSongs[i] != null){
                allInfo +=  "**************  Song **************\n";
                allInfo += "**  Title: " + poolSongs[i].getTitle() + "\n";
                allInfo += "**  Artist: " + poolSongs[i].getArtistName() + "\n";
                allInfo += "**  Duration: " + poolSongs[i].getDuration() + "\n";
                allInfo += "**  Genre: " + poolSongs[i].getGender() + "\n";
                allInfo += "***********************************\n\n";
            }
            
        }
        
        return allInfo;
    }
    
    
    /**
     * Add private playList. <br>
     * <b> pre: </b> A user must be logged in. <br>
     * <b> post: </b> Add private playList.
     * @param name name of the playList. name! = null.
     * @return
     */
    
    public String addPrivatePL(String name){ //Añadir playList privada
        String addTrue = "Debes logearte primero";
        if(userAccess > -1){
            PlayList newPlayList = new PrivatePL(name, users[userAccess]);
            
            for(int i = 0; i < playLists.length; i++){

                if(playLists[i] == null){
                    playLists[i] = newPlayList;

                    addTrue = "\n\nSe añadio la playList correctamente.";
                    break;
                } else {
                    addTrue = "\n\nNo se pueden agregar mas playList, limite alcanzado.";
                }
            }
        }
        
        return addTrue;
    }
    
   /**
     * Add restricted playList. <br>
     * <b> pre: </b> A user must be logged in. <br>
     * <b> post: </b> Add private playList.
     * @param name name of the playList. name! = null.
     * @return
     */
   
    public String addRestrictedPL(String name){  //Añadir playList restringida
        String addTrue = "Debes logearte primero.";
        
        if(userAccess > -1){
            PlayList newPlayList = new RestrictedPL(name, users[userAccess]);
            
            for(int i = 0; i < playLists.length; i++){

                if(playLists[i] == null){
                    playLists[i] = newPlayList;

                    addTrue = "\n\nSe añadio la playList correctamente, 1 de 5 usuarios tienen acceso.";
                    break;
                } else {
                    addTrue = "\n\nNo se pueden agregar mas playList, limite alcanzado.";
                }
            }
        }
            
        return addTrue;
    }
    
    
    /**
     * Update all playlists. <br>
     * <b> pre: </b> PlayLists created <br>
     * <b> post: </b> All available playlists are updated.
     * @return
     */
    
    public String upgrapePlayList(){
    
        String durationUpgrape = "";
        
        for(int i = 0; i < playLists.length; i++){
        
            if(playLists[i] != null){
                playLists[i].upgrapePLayList();
            }
        }
        
        durationUpgrape = "Se actualizo correctamente.";
        
        return durationUpgrape; 
    }
   
    
    /**
     * Give access to restricted playList. <br>
     * <b> pre: </b> Restricted PLay created. <br>
     * <b> post: </b> A user is given access to a restricted playList.
     * @param restrictedPL playList selected by user. restrictedPL! = null.
     * @param userAccess user selected to give you access. userAccess 1 = null.
     * @return
     */
    
    public String addUserAccess(int restrictedPL, int userAccess){
        String addUser = "";
        
        RestrictedPL addAccess = (RestrictedPL)playLists[restrictedPL];
        addUser = addAccess.addUserAccess(users[userAccess]);
        
        return addUser;
    }
    
    /**
     * Add public playList. <br>
     * <b> pre: </b>  <br>
     * <b> post: </b> Add private playList.
     * @param name name of the playList. name! = null.
     * @return
     */
    
    public String addPublicPL(String name){
        String addTrue = "";
        PublicPL newPlayList = new PublicPL(name);
        for(int i = 0; i < playLists.length; i++){
            if(playLists[i] == null){

                playLists[i] =  newPlayList;
                addTrue = "\n\nSe añadio la playList correctamente.";
                i = playLists.length;
            }else {
                addTrue = "\n\nNo se pueden agregar mas playList, limite alcanzado.";
            }
        } 
        
        return addTrue;
    }
    
    /**
     * Add rating to public playList. <br>
     * <b> pre: </b> You must have created at least one public playList. <br>
     * <b> post: </b> Add grade to public playList.
     * @param playList public playList selected to be rated. playList! = null.
     * @param calification qualification of the playList. qualification> = 0 && 5> = qualification.
     * @return
     */
    
    public String addCalificationPL(int playList, float calification){
        
        String addTrue = "";
        
        PublicPL addCalification = (PublicPL)playLists[playList-1];
        addCalification.averageMark(calification);
                
        return addTrue;
    }
    
    /**
     * Add song to private playlist <br>
     * <b> pre: </b> private playList created and song available <br>
     * <b> post: </b> Song from pool is added to playList
     * @param playList playList selected by user. playList! = null.
     * @param song song selected by the pool user. song 1 = null.
     * @return
     */
    
    public String addSongPrivate(int playList, int song){
    
        String addTrue;
        
            PrivatePL privatePL = (PrivatePL)playLists[playList];
            addTrue = privatePL.addSong(poolSongs[song], users[userAccess]);
                
        return addTrue;
    }
    
    /**
     * Add song to restricted playlist <br>
     * <b> pre: </b> private playList created and song available <br>
     * <b> post: </b> Song from pool is added to playList
     * @param playList playList selected by user. playList! = null.
     * @param song song selected by the pool user. song 1 = null.
     * @return
     */
    
    
    public String addSongRestricted(int playList, int song){
    
        String addTrue;
        
        RestrictedPL restrictedPL = (RestrictedPL) playLists[playList];
        addTrue = restrictedPL.addSong(poolSongs[song], users[userAccess]);
        
        return addTrue;
    }
    
    /**
     * Add song to public playlist <br>
     * <b> pre: </b> private playList created and song available <br>
     * <b> post: </b> Song from pool is added to playList
     * @param playList playList selected by user. playList! = null.
     * @param song song selected by the pool user. song 1 = null.
     * @return
     */
    
    
    public String addSongPublic(int playList, int song){
    
        String addTrue;
        
        PublicPL publicPL = (PublicPL) playLists[playList];
        addTrue = publicPL.addSong(poolSongs[song]);
        
        return addTrue;
    }
    
    /**
     * Show playlist information <br>
     * <b> pre: </b> PLayLists available. for
     * <b> post: </b> The information of the available playlists is displayed.
     * @return
     */
    
    public String showPlayList(){
        String allInfo = "";
    
        for(int i = 0; i < playLists.length; i++){
            if(playLists[i] != null){
                allInfo += playLists[i].showInformation();
            }
        }
        
        return allInfo;
    }
}
