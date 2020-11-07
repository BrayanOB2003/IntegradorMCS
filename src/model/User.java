package model;

public class User {
    private String name;
    private String password;
    private int age;
    private String category;
    private int sharedSongs;
            
    public User(String name, String password, int age) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.category = "Newbie";
        sharedSongs = 0;    
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSharedSongs() {
        return sharedSongs;
    }

    public void setSharedSongs(int sharedSongs) {
        this.sharedSongs = sharedSongs;
    }

    
    /**
     * Update user category <br>
     * <b> pre: </b> User logged in <br>
     * <b> post: </b> As you add songs, the user's category is updated.
     */
    
    public void upgrapeUserCategoy(){
        
        String clasification;
        
        if(sharedSongs < 3){
            clasification = String.valueOf(Categories.Newbie);
        } else if(sharedSongs < 10){
            clasification = String.valueOf(Categories.LittleContributor);
        } else if(sharedSongs < 30){
            clasification = String.valueOf(Categories.MildContributor);
        } else{
            clasification = String.valueOf(Categories.StarContributor);
        }
        
        category = clasification;
    }
    
    /**
     * Update number of songs shared by the user. <br>
     * <b> pre: </b> User logged in <br>
     * <b> post: </b> Increase sharedSongs every time the user adds a song to the poolSongs.
     * @param song number of songs shared. song == 1.
     */
    
    public void upgrapeShredSongs(int song){
    
        sharedSongs += song;
    }
}
