package me.tolkstudio.myapplication;

public class SocChangableSource implements SocialChangableSource {

    private int count;
    private SocialDataSource dataSource;

    public SocChangableSource(SocialDataSource dataSource){
        count = 0;
        this.dataSource = dataSource;
    }

    public void add(){
        if (count < dataSource.size()){
            count++;
        }
    }

    public void delete(){
        if (count > 0 ){
            count--;
        }
    }

    public Soc getSoc(int position){ return dataSource.getSoc(position);}

    public int size(){ return count;}

}
