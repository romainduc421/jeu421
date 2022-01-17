package testIG.sample;


public class Counter {


    private int val;

    public Counter(){
        setVal(0);
    }

    public void incrementation(int decompte){
        setVal(this.val+decompte);
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }
}
