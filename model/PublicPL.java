package model;

public class PublicPL extends PlayList{
    private int calificationNumbers;
    private int allCalification;
    private float averageMark;

    public float getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(float averageMark) {
        this.averageMark = averageMark;
    }
    
    public PublicPL(String name){
    super(name);
    allCalification = 0;
    calificationNumbers = 0;
    averageMark = 0;
    }
    
    public String averageMark(int calification){
        String mark = "";
        
        allCalification +=calification;
        calificationNumbers++;
            if(calificationNumbers != 0){
                averageMark = Math.round(((allCalification /calificationNumbers) * 10d)/10d); 
                mark = "Se añadio la calificacion a la playList " + getName() + ".";
            }
        return mark;
    }
    
    
}
